package per.zzb;

//使用BST实现的二分搜索树
public class BSTMap<K extends Comparable,V> implements Map<K ,V> {

    //定义树的节点
    private class Node {
        public K k; //定义节点的key
        public V v; //定义节点的value
        Node left, right; //定义左孩子和右孩子

        public Node(K k,V v) {
            this.k = k;
            this.v = v;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return "(key:"+k.toString()+",value:"+v.toString()+")";
        }
    }

    //定义树的根和节点数量
    private Node root;
    private int size;

    //构造函数
    public BSTMap() {
        root = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean contains(K k) {
        return get(k) != null;
    }

    @Override
    public void add(K k, V v) {
        root = add(root,k,v);
    }

    //递归方法
    private Node add(Node node, K k, V v) {
        //设置递归终止条件
        if (node == null){
            size ++;
            return new Node(k,v);
        }
//
//        //遍历到最左边或最右边
//        if (node.left == null){
//            node.left = new Node(k,v);
//        } else if (node.right == null){
//            node.right = new Node(k,v);
//        }

        if (k.equals(node.k)){
//            System.out.println("Key："+k.toString()+"在BSTMap中已经存在！");
            return node;
        } else if (k.compareTo(node.k)<0){
            node.left = add(node.left,k,v);
        } else {
            node.right = add(node.right,k,v);
        }
        return node;
    }

    @Override
    public void set(K k, V v) {
        if (!contains(k)){
            System.out.println("Key："+k.toString()+"在BSTMap中不存在，无法修改！");
            return;
        }

        Node node = get(root,k);
        node.v = v;
    }

    @Override
    public void remove(K k) {
        root = remove(root,k);
    }

    //递归方法
    private Node remove(Node node, K k) {

        if (node == null){
            System.out.println("不存在Key为"+k.toString()+"的元素");
            return null;
        }

        if (k.equals(node.k)){ //当前删除的节点是这个，主要业务逻辑实现
            if (node.left == null){
                Node right = node.right;
                node.right = null;
                size --;
                return right;
            }

            if (node.right == null){
                Node left = node.left;
                node.left = null;
                size --;
                return left;
            }

            //核心部分，被删除的节点，既有左子树又有右子树
            //使用的策略是找到左子树中的最大值作为新的根
            Node leftMax = maximum(node.left);
            leftMax.right = node.right;
            leftMax.left = removeMax(node.left);
            node.left= node.right = null;
            size --;
            return leftMax;

        } else if (k.compareTo(node.k) < 0){
            node.left = remove(node.left,k);
            return node;
        } else {
            node.right = remove(node.right,k);
            return node;
        }

    }

    private Node removeMax(Node node) {
        //设置递归终止条件
        if (node.right == null) {
            Node left = node.left;
            node.left = null;
            size--;
            return left;
        }

        node.right = removeMax(node.right);
        return node;
    }

    //找到以node节点为根的最大节点

    private Node maximum(Node node) {
        if (node == null) {
            return null;
        }

        if (node.right == null)
            return node;

        return maximum(node.right);
    }

    @Override
    public V get(K k) {
        Node res = get(root,k);
        if (res == null)
            return null;
        else
            return res.v;
    }

    //递归方法
    private Node get(Node node, K k) {
        //设置递归终止条件
        if (node == null){
            return null;
        }

        //设置返回的节点
//        Node res;
        if (k.equals(node.k)){
//            res = node;
            return node;
        }else if (k.compareTo(node.k)<0){
//            res = get(node.left,k);
            return get(node.left,k);
        } else {
//            res = get(node.right,k);
            return get(node.right,k);
        }

//        return res;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("BSTMap{ root: "+ root + ",size is "+size+"}\n");
        generateBSTString(res, root,0);
        return res.toString();
    }

    private void generateBSTString(StringBuilder res,Node node,int depth) {
        //设置递归终止条件
        if (node == null){
            res.append(generateDepthString(depth)+"null\n");
            return;
        }

        res.append(generateDepthString(depth)+ node +"\n");
        generateBSTString(res,node.left,depth+1);
        generateBSTString(res,node.right,depth+1);

    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
