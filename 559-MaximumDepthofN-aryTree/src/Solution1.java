import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/3 17:28
 * @Description : 使用层序遍历
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {

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
        
        if (root == null)
            return 0;

        int depth = 0;
        //利用队列实现层序遍历
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()){
            depth ++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node pop = queue.poll();
                if (pop != null){
                    for (Node child : pop.children){
                        if (child != null)
                            queue.add(child);
                    }
                }
            }
        }

        return depth;
    }
}
