import javax.swing.text.Segment;

/**
 * @ClassName : NumArray
 * @Author : Zhai Zhibin
 * @Date : 2021/8/25 8:54
 * @Description : 给你一个数组 nums ，请你完成两类查询，其中一类查询要求更新数组下标对应的值，
 * 另一类查询要求返回数组中某个范围内元素的总和。
 * @Modified_by :
 * @Version : 1.0
 **/
class NumArray {

    public class SegmentTree<E> {

        private E[] data; //存放数据
        private E[] tree; //存放线段类
        private Merger<E> merger;

        public SegmentTree(E[] arr, Merger<E> merger) {

            this.merger = merger;

            data = (E[]) new Object[arr.length];
            tree = (E[]) new Object[4 * arr.length]; //需要四倍的存储空间，因为arr.length可能大于2^k + 1

            //赋值data数组
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }

            //递归构造线段树，从根节点开始，从左到右
            buildSegmentTree(0, 0, arr.length - 1);

        }

        private void buildSegmentTree(int index, int l, int r) {

            //设置递归终止条件
            if (l == r) {
                tree[index] = data[l];
                return;
            }


            //找到中间位置
            int mid = l + (r - l) / 2; //防止加法溢出

            int leftChild = leftChild(index);
            int rightChild = rightChild(index);

            //构造左右两颗线段树子树
            buildSegmentTree(leftChild, l, mid);
            buildSegmentTree(rightChild, mid + 1, r);

            //当前节点需要做一下融合
            tree[index] = merger.merge(tree[leftChild], tree[rightChild]);
        }

        private int rightChild(int index) {
            return 2 * index + 2;
        }

        private int leftChild(int index) {
            return 2 * index + 1;
        }

//    public E findSegemnt(){
//
//    }

        public int getSize() {
            return data.length;
        }

        public E get(int index) {
            if (index < 0 || index > data.length - 1) {
                throw new IllegalArgumentException("Get failed. Index err");
            }

            return data[index];
        }

        //查找区间的值
        public E findSegment(int i, int j) {

            //判断边界条件
            if (i < 0 || j < 0 || j > data.length - 1 || i > j || i > data.length - 1) {
                throw new IllegalArgumentException("find segment failed. bound err!");
            }

            //递归查询区间值
            return findSegmentRecursion(0, 0, data.length - 1, i, j);
        }

        public E findSegmentRecursion(int index, int l, int r, int i, int j) {

            //递归终止条件
            if (i == l && r == j)
                return tree[index];

            //计算中间值和左右孩子
            int mid = l + (r - l) / 2;
            int leftChild = leftChild(index);
            int rightChild = rightChild(index);

            //如果查找的左边界大于中间值
            if (i >= mid + 1) {
                return findSegmentRecursion(rightChild, mid + 1, r, i, j);
            } else if (j <= mid) { //如果查找的边右界小于中间值
                return findSegmentRecursion(leftChild, l, mid, i, j);
            }

            E leftResult = findSegmentRecursion(leftChild, l, mid, i, mid);
            E rightResult = findSegmentRecursion(rightChild, mid + 1, r, mid + 1, j);

            return merger.merge(leftResult, rightResult);
        }

        //更新操作
        public void set(int index, E e) {
            if (index < 0 || index > data.length - 1)
                throw new IllegalArgumentException("Set failed. Index err");

            data[index] = e;
            //递归更新整个线段树
            set(0, 0, data.length - 1, index, e);
        }

        private void set(int treeIndex, int l, int r, int index, E e) {
            //判断递归终止条件
            if (l == r) {
                tree[treeIndex] = e;
                return;
            }


            int mid = l + (r - l) / 2;
            int leftChild = leftChild(index);
            int rightChild = rightChild(index);

            if (index >= mid + 1)
                set(rightChild, mid + 1, r, index, e);
            else if (index <= mid)
                set(leftChild, 0, mid, index, e);

            tree[treeIndex] = merger.merge(tree[leftChild], tree[rightChild]);

        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();

            res.append('[');
            for (int i = 0; i < tree.length; i++) {

                if (tree[i] != null)
                    res.append(tree[i]);
                else
                    res.append("null");

                if (i != tree.length - 1)
                    res.append(", ");
            }

            res.append(']');
            return res.toString();
        }
    }

    public interface Merger<E> {
        E merge(E a, E b);
    }

    //定义一个线段树
    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        Integer[] data = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }

        segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
    }

    public void update(int index, int val) {
        segmentTree.set(index,val);
    }

    public int sumRange(int left, int right) {
        return segmentTree.findSegment(left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
