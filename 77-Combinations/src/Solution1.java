import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/14 17:39
 * @Description : 对回溯的遍历进行优化剪枝
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {

    private List<List<Integer>> lists; //保存最终结果
    private Stack<Integer> path; //保存每个结果
    public List<List<Integer>> combine(int n, int k) {
        lists = new ArrayList<>();
        path = new Stack<>();
        backtracking(1, n, k);
        return lists;
    }

    void backtracking(int start, int end, int count) {

        //回溯终止条件
        if (path.size() == count) { //找到一个结果
            lists.add(new ArrayList<>(path));
            return;
        }

        //提前判断start到end还够不够count个数字
        for (int i = start; i <= (end - (count - path.size()) + 1); i++) {
            path.push(i);
            backtracking(i+1,end,count);
            path.pop();
        }
    }
}
