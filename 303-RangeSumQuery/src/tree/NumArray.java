package tree;

/**
 * @ClassName : NumArray
 * @Author : Zhai Zhibin
 * @Date : 2021/8/25 8:21
 * @Description : ToDo
 * @Modified_by :
 * @Version : 1.0
 **/
public class NumArray {

    public interface Merger<E> {
        E merge(E a, E b);
    }

    public class SegmentTree<E> {

        private E[] data; //存放数据
        private E[] tree; //存放线段类
        private Merger<E> merger;

        public SegmentTree(E[] arr, Merger<E> merger){

            this.merger = merger;

            data = (E[])new Object[arr.length];
            tree = (E[])new Object[4 * arr.length]; //需要四倍的存储空间，因为arr.length可能大于2^k + 1

            //赋值data数组
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }

            //递归构造线段树，从根节点开始，从左到右
            buildSegmentTree(0,0,arr.length-1);

        }

        private void buildSegmentTree(int index, int l, int r) {

            //设置递归终止条件
            if (l == r){
                tree[index] = data[l];
                return;
            }



            //找到中间位置
            int mid = l + (r - l) / 2; //防止加法溢出

            int leftChild = leftChild(index);
            int rightChild = rightChild(index);

            //构造左右两颗线段树子树
            buildSegmentTree(leftChild,l,mid);
            buildSegmentTree(rightChild,mid+1,r);

            //当前节点需要做一下融合
            tree[index] = merger.merge(tree[leftChild],tree[rightChild]);
        }

        private int rightChild(int index) {
            return  2 * index + 2;
        }

        private int leftChild(int index) {
            return  2 * index + 1;
        }

//    public E findSegemnt(){
//
//    }

        public int getSize(){
            return data.length;
        }

        public E get(int index){
            if (index < 0 || index > data.length - 1){
                throw new IllegalArgumentException("Get failed. Index err");
            }

            return data[index];
        }

        //查找区间的值
        public E findSegment(int i,int j){

            //判断边界条件
            if (i < 0 || j < 0 || j > data.length -1 || i > j || i >data.length -1 ){
                throw new IllegalArgumentException("find segment failed. bound err!");
            }

            //递归查询区间值
            return findSegmentRecursion(0, 0,data.length-1, i, j);
        }

        public E findSegmentRecursion(int index, int l, int r,int i,int j){

            //递归终止条件
            if ( i == l && r == j)
                return tree[index];

            //计算中间值和左右孩子
            int mid = l + (r-l)/2;
            int leftChild = leftChild(index);
            int rightChild = rightChild(index);

            //如果查找的左边界大于中间值
            if (i >= mid + 1){
                return findSegmentRecursion(rightChild, mid +1 , r , i ,j);
            } else if (j <= mid){ //如果查找的边右界小于中间值
                return findSegmentRecursion(leftChild,l ,mid , i, j);
            }

            E leftResult = findSegmentRecursion(leftChild,l,mid,i,mid);
            E rightResult = findSegmentRecursion(rightChild,mid + 1 , r, mid + 1, j);

            return merger.merge(leftResult,rightResult);
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

    //初始化一个区间树
    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        //初始化一个数组接收数据
        Integer[] data = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }
        segmentTree = new SegmentTree<Integer>(data, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });

    }

    public int sumRange(int left, int right) {

        //判断是否为空
        if (segmentTree == null)
            throw new IllegalArgumentException("err");

        return segmentTree.findSegment(left,right);
    }
}
