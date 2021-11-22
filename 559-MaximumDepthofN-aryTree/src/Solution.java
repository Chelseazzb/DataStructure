import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/3 16:52
 * @Description : 给定一个N叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    //定义树的节点
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

    public int maxDepth(Node root) {

        int depth = 0;
        if (root == null)
            return 0;

        for (int i = 0; i < root.children.size(); i++) {
            depth = Math.max(depth,maxDepth(root.children.get(i)));
        }

        return depth + 1;
    }


}
