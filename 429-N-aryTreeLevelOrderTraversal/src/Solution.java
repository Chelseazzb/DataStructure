import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/2 14:12
 * @Description : 给定一个 N叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）
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
    }

    public List<List<Integer>> levelOrder(Node root) {
        //1、定义返回值
        List<List<Integer>> result = new ArrayList<>();

        //2、判断边界值
        if (root == null)
            return result;

        //3、开始层次遍历
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (! queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node pop = queue.poll();
                list.add(pop.val);
                for (int j = 0; j < pop.children.size(); j++) {
                    queue.add(pop.children.get(j));
                }
            }
            result.add(list);
        }

        return result;
    }
}
