import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//给定一个二叉树，返回其节点值的锯齿形层序遍历。
// （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
public class Solution {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    Queue<TreeNode> queue; //双端队列
    List<List<Integer>> lists;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        queue = new LinkedList<>();
        lists = new LinkedList<>();
        if (root == null)
            return lists;

        levelOrder(root); //从root第一层开始遍历

        return lists;
    }

    private void levelOrder(TreeNode root){

        int level = 1;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Deque<Integer> deque = new LinkedList<>(); //使用双端队列
            for (int i = 0; i < size; i++) {
                TreeNode cur;
                if ( (level & 1) == 0){ //level是偶数
                    cur = queue.poll();
                    deque.offerFirst(cur.val); //不断放在第一个就相当于是从右到左
                } else { //level是奇数
                    cur = queue.poll();
                    deque.offerLast(cur.val); //顺序放
                }
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right!=null)
                    queue.add(cur.right);
            }
            lists.add(new LinkedList<>(deque));
            level ++;
        }

    }

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);

        System.out.println(deque.pollLast());
        System.out.println(deque.size());
    }

}
