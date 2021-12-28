import java.util.LinkedList;
import java.util.List;

//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
// 要求不能创建任何新的节点，只能调整树中节点指针的指向。
public class Solution {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    //特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
    Node head, pre;
    public Node treeToDoublyList(Node root) {
        //判断边界条件
        if (root == null)
            return null;

        inorder(root);
        //头结点需要和尾结点连接起来
        head.left = pre;
        pre.right = head;

        return head;
    }

    //中序遍历
    private void inorder(Node cur) {
        //1、递归终止条件
        if (cur == null)
            return;

        inorder(cur.left);
        //2、递归单层处理
        if (pre != null){
            pre.right = cur;
        } else
            head = cur; //没有前驱的是头结点
        cur.left = pre;
        pre = cur;
        inorder(cur.right);
    }


    public static void main(String[] args) {
        Node root = new Node(4);
        Node left = new Node(2);
        Node right = new Node(5);
        Node secondLeft = new Node(1);
        Node secondRight = new Node(3);

        root.left = left;
        root.right = right;
        left.left = secondLeft;
        left.right = secondRight;

    }
}
