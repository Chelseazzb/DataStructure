package per.zzb.set;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName : BST
 * @Author : Zhai Zhibin
 * @Date : 2021/7/31 9:40
 * @Description : 二分搜索树的实现
 * @Modified_by :
 * @Version : 1.0
 **/
public class BST<E extends Comparable> {

    //定义树的节点
    private class Node {
        public E e; //定义节点的值
        Node left, right; //定义左孩子和右孩子

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return this.e.toString();
        }
    }

    //定义树的根和节点数量
    private Node root;
    private int size;

    //构造函数
    public BST() {
        root = null;
        size = 0;
    }

    //判断树是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //获得树的节点数量
    public int getSize() {
        return size;
    }

    //增加节点，不支持重复元素
    public void add(E e) {

//        if (root == null){
//            root = new Node(e);
//            size ++;
//        } else {
//            add(root,e);
//        }

        root = add(root, e);
    }

    private Node add(Node node, E e) {
        //这次递归到底
        if (node == null) {
            size ++;
            return new Node(e);
        }

        if (e.equals(node.e)) {
            return node;
        } else if (e.compareTo(node.e) < 0) {
            node.left = add(node.left,e);
        } else { // e.compareTo(node.e) > 0
            node.right = add(node.right,e);
        }

        return node;
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

        Node node = find(root, e);
        return node;
    }

    private Node find(Node node, E e) {

        //设置递归终止条件
        if (e.equals(node.e)) {
            return node;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            System.out.println("没有找到此元素left: " + e);
            return null;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            System.out.println("没有找到此元素right: " + e);
            return null;
        }

        Node res = null; //设置返回的节点

        if (e.compareTo(node.e) < 0) {
            res = find(node.left, e);
        } else {
            res = find(node.right, e);
        }

        return res;
    }

    //判断是否包含元素
    public boolean contains(E e){
        Node node = find(e);
        if (node == null)
            return false;
        else
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


    //删除节点
    public void delete(E e) {
        root = delete(root, e);
    }

    //删除以node为根的BST中值为e的节点
    //并返回新的树根，在该节点的右子树中找到最小值作为根
    private Node delete(Node node, E e) {

        //递归终止条件
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = delete(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = delete(node.right, e);
            return node;

        } else { //要删除的就是这个节点

            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }
            if (node.right == null) {
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            }

            Node min = minimum(node.right);
            min.left = node.left;
            min.right = removeMin(node.right);
            node.left = node.right = null;
            return min;

        }

    }

    //删除最小值节点
    public E removeMin() {
        Node min = minimum(root);
        root = removeMin(root);
        return min.e;
    }

    private Node removeMin(Node node) {

        //设置递归终止条件
        if (node.left == null) {
            Node right = node.right;
            node.right = null;
            size--;
            return right;
        }

        node.left = removeMin(node.left);
        return node;
    }


    //删除最大值节点
    public E removeMax() {
        Node max = maximum();
        removeMax(root);
        return max.e;
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
}
