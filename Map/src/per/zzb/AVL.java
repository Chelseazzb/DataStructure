package per.zzb;

import java.util.*;

/**
 * @ClassName : AVL
 * @Author : Zhai Zhibin
 * @Date : 2021/7/31 9:40
 * @Description : 平衡的二分搜索树的实现
 * @Modified_by :
 * @Version : 1.0
 **/
public class AVL<E extends Comparable, V> {

    //定义树的节点
    private class Node {
        public E key; //定义节点的值
        public V value; //定义节点的值
        public int height; //节点的高度
        Node left, right; //定义左孩子和右孩子

        public Node(E key, V value) {
            this.key = key;
            this.value = value;
            this.height = 1; //添加的都为叶子结点
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return this.key.toString();
        }
    }

    //定义树的根和节点数量
    private Node root;
    private int size;

    //构造函数
    public AVL() {
        root = null;
        size = 0;
    }

    //判断树是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //判断是否为BST树
    public boolean isBST() {
        List<E> list = new ArrayList<>();
        inorder(root, list);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).compareTo(list.get(i)) > 0)
                return false;
        }
        return true;
    }

    private void inorder(Node node, List<E> list) {
        if (node == null)
            return;

        inorder(node.left, list);
        list.add(node.key);
        inorder(node.right, list);

    }

    // 判断该二叉树是否是一棵平衡二叉树
    public boolean isBalanced(){
        return isBalanced(root);
    }

    // 判断以Node为根的二叉树是否是一棵平衡二叉树，递归算法
    private boolean isBalanced(Node node){

        if(node == null)
            return true;

        int balanceFactor = getBalanceFactor(node);
        if(Math.abs(balanceFactor) > 1)
            return false;
        return isBalanced(node.left) && isBalanced(node.right);
    }

    //获得树的节点数量
    public int getSize() {
        return size;
    }

    //获得节点的高度
    public int getHeight(Node node) {
        //判断边界值
        if (node == null)
            return 0;
        return node.height;
    }

    //获得节点的平衡因子
    public int getBalanceFactor(Node node) {
        //判断边界值
        if (root == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    //增加节点，不支持重复元素
    public void add(E key, V value) {

//        if (root == null){
//            root = new Node(e);
//            size ++;
//        } else {
//            add(root,e);
//        }

        root = add(root, key, value);
    }

    private Node add(Node node, E key, V value) {
        //这次递归到底
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.equals(node.key)) {
            node.value = value;
        } else if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else { // e.compareTo(node.e) > 0
            node.right = add(node.right, key, value);
        }

        //更新height值
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        //判断是否破坏了平衡
//        if (Math.abs(getBalanceFactor(node)) > 1) {
//            System.out.println("Unbalanced: " + node.key);
//        }

        //在这里需要去维护AVL的平衡性质
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0)
            return rightRotate(node);

        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0)
            return leftRotate(node);

        //LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left); //变为LL
            return rightRotate(node);
        }

        //RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right); //变为RR
            return leftRotate(node);
        }


        return node;
    }


    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;

        // 向右旋转过程
        x.right = y;
        y.left = T3;

        // 更新height，！！！一定要注意更新顺序，先更新子树，在更新树根
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        // 向左旋转过程
        x.left = y;
        y.right = T2;

        // 更新height，！！！一定要注意更新顺序，先更新子树，在更新树根
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    //可以进一步简化
//    private void add(Node node, E e) {
//
//        //设置递归终止条件
//        if (e.equals(node.e)){
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size ++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null){
//            node.right = new Node(e);
//            size ++;
//            return;
//        }
//
//        //递归调用函数add
//        if (e.compareTo(node.e) < 0){
//            add(node.left,e);
//        }else {
//            add(node.right,e);
//        }
//    }

    //查找节点
    public Node find(E e) {

        Node node = getNode(root, e);
        return node;
    }

    // 返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, E key) {

        if (node == null)
            return null;

        if (key.equals(node.key))
            return node;
        else if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else // if(key.compareTo(node.key) > 0)
            return getNode(node.right, key);
    }

    //查找树中是否包含key
    public boolean contains(E key) {
        Node node = getNode(root, key);
        if (node == null)
            return false;
        return true;
    }


    //查找最小值节点
    public Node minimum() {
        return minimum(root);
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    //查找最大值节点
    public Node maximum() {
        return maximum(root);
    }

    private Node maximum(Node node) {
        if (node == null) {
            return null;
        }

        if (node.right == null)
            return node;

        return maximum(node.right);
    }

    /**
     * @Author Zhai Zhibin
     * @Description 四种遍历树的方式
     * @Date 2021/7/31 9:57
     **/

    //前序遍历
    public void preorder() {
        System.out.print("前序遍历：");
        preorder(root);
        System.out.println();
    }

    private void preorder(Node node) {

        //设置递归终止条件
        if (node == null) {
            return;
        }

        System.out.print(node);
        preorder(node.left);
        preorder(node.right);


    }

    //非递归的前序遍历
    public void nonRecursionPreorder() {
        int count = 1;
        System.out.print("非递归的前序遍历：");

        //定义队列存放节点
        Stack<Node> stack = new Stack<>();

        if (root == null)
            return;

        stack.add(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.print(cur);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        System.out.println();

    }

    //中序遍历
    public void inorder() {
        System.out.print("中序遍历：");
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node);
        inorder(node.right);

    }

    //后序遍历
    public void postorder() {
        System.out.print("后序遍历：");
        postorder(root);
        System.out.println();
    }

    private void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node);
    }

    //层次遍历
    public void levelorder() {
        System.out.print("BST层次遍历：");
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.print(cur);

            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        System.out.println();
    }


    // 从二分搜索树中删除键为key的节点
    public V remove(E key){

        Node node = getNode(root, key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    //删除以node为根的AVL中值为e的节点
    //不能直接返回，需要旋转保持平衡
    private Node remove(Node node, E key){

        if( node == null )
            return null;

        Node retNode;
        if( key.compareTo(node.key) < 0 ){
            node.left = remove(node.left , key);
            // return node;
            retNode = node;
        }
        else if(key.compareTo(node.key) > 0 ){
            node.right = remove(node.right, key);
            // return node;
            retNode = node;
        }
        else{   // key.compareTo(node.key) == 0

            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                // return rightNode;
                retNode = rightNode;
            }

            // 待删除节点右子树为空的情况
            else if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                // return leftNode;
                retNode = leftNode;
            }

            // 待删除节点左右子树均不为空的情况
            else{
                // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                Node successor = minimum(node.right);
                //successor.right = removeMin(node.right);
                successor.right = remove(node.right, successor.key);
                successor.left = node.left;

                node.left = node.right = null;

                // return successor;
                retNode = successor;
            }
        }

        if(retNode == null)
            return null;

        // 更新height
        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));

        // 计算平衡因子
        int balanceFactor = getBalanceFactor(retNode);

        // 平衡维护
        // LL
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0)
            return rightRotate(retNode);

        // RR
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0)
            return leftRotate(retNode);

        // LR
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }

        // RL
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }

        return retNode;
    }


    //修改节点key的value值
    public void set(E key, V value) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");
        else
            node.value = value;
    }

    //查询节点key的value值
    public V get(E key) {
        Node node = getNode(root, key);
        if (node == null)
            return null;
        else
            return node.value;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        System.out.println();
        generateBSTString(res, 0, root);
        return res.toString();
    }

    private void generateBSTString(StringBuilder res, int depth, Node node) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node + "\n");
        generateBSTString(res, depth + 1, node.left);
        generateBSTString(res, depth + 1, node.right);
    }

    //表示树的深度
    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            AVL<String, Integer> map = new AVL<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));

            System.out.println("当前的AVL是否保持了BST的性质：" + map.isBST());
            System.out.println("当前的AVL是否保持了平衡：" + map.isBalanced());

            for(String word: words){
                map.remove(word);
                if(!map.isBST() || !map.isBalanced())
                    throw new RuntimeException();
            }
        }

        System.out.println();
    }
}
