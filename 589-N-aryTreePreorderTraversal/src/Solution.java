import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/2 12:06
 * @Description : 给定一个 N 叉树，返回其节点值的前序遍历 。
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    //树结点的定义
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    //递归法
    public List<Integer> preorder(Node root) {

        //1、初始化
        List<Integer> list = new ArrayList<>();

        if (root == null)
            return list;

        recursion(root,list);

        return list;

    }

    public void recursion(Node node , List<Integer> list){
        if (node == null) return;

        list.add(node.val); //中
        for (int i = 0; i < node.children.size(); i++) {
            recursion(node.children.get(i),list);
        }

    }
}
