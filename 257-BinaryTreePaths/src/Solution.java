import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/4 19:18
 * @Description : 给你一个二叉树的根节点 root ，按任意顺序 ，返回所有从根节点到叶子节点的路径。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        if (root == null)
            return list;

        getPath(root,path,list);

        return list;
    }

    //递归函数
    private void getPath(TreeNode node , List<Integer> path,List<String> list){
        //中，走到该节点，path中记录
        path.add(node.val);

        //1.递归终止条件
        if (node.left == null && node.right == null){ //找到一条路径，到达叶子结点
            int size = path.size();
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < size; i++) {
                if (i == size - 1)
                    res.append(path.get(i));
                else {
                    res.append(path.get(i));
                    res.append("->");
                }
            }
            list.add(res.toString()); //添加一条新路径
            return;
        }

        //2.单层递归逻辑
        if (node.left != null){ //左
            getPath(node.left,path,list);
            path.remove(path.size()-1); //回溯
        }

        if (node.right != null){ //右
            getPath(node.right,path,list);
            path.remove(path.size()-1); //回溯
        }

    }
}
