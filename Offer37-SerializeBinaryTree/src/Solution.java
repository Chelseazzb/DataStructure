//请实现两个函数，分别用来序列化和反序列化二叉树。
//你需要设计一个算法来实现二叉树的序列化与反序列化。
// 这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
//提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode序列化二叉树的格式。
// 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //判断边界条件
        if (root == null)
            return "[]";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        //层序遍历
        res.append("[");
        while (!queue.isEmpty()) {
            int size = queue.size(); //提前记录本层的节点个数，因为出队会变化
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    res.append("null,"); //代表叶子节点为空
                } else {
                    res.append(cur.val + ",");
                    //无论子节点是否为空，都需要加入队列
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }
        }
        res.deleteCharAt(res.length() - 1); //去掉最后一个逗号
        res.append("]");

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null; // 空字符串直接返回
        String[] str = data.substring(1,data.length()-1).split(","); // 去掉[] 和最后一个 ","
        int i = 0; // 遍历数组
        TreeNode root = new TreeNode(Integer.parseInt(str[i]));
        i++; // 跳过根结点
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!"null".equals(str[i])){
                node.left = new TreeNode(Integer.parseInt(str[i]));
                queue.add(node.left);
            }
            i++; // 更新下标
            if(!"null".equals(str[i])){
                node.right = new TreeNode(Integer.parseInt(str[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode secondLeft = new TreeNode(4);
        TreeNode secondRight = new TreeNode(5);

        root.left = left;
        root.right = right;
        right.left = secondLeft;
        right.right = secondRight;

        System.out.println( "序列化：" + new Solution().serialize(root));

        String s = "[]";
        TreeNode cur = new Solution().deserialize(s);
        System.out.println( "反序列化："  + cur);
    }
}
