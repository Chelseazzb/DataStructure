import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/14 19:17
 * @Description : 剪枝优化
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {

    List<List<Integer>> lists;
    Stack<Integer> stack;
    public List<List<Integer>> combinationSum3(int k, int n) {
        lists = new ArrayList<>();
        stack = new Stack<>();

        backTracking(0,k, 1, n);
        return lists;
    }

    private void backTracking(int current,int count, int start, int sum) {
        //1、回溯终止条件
        if (current > sum)
            return;

        if (stack.size() == count) {
            if (current == sum){
                lists.add(new ArrayList<>(stack));
                return;
            }

        }

        //for循环遍历子集，只允许1-9
        for (int i = start; i <= 9; i++) {
            stack.push(i);
            current += i;
            backTracking(current,count, i + 1, sum );
            stack.pop();
            current -= i;
        }
    }
}
