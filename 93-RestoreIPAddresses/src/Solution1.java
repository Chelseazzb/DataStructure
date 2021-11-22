import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/17 20:47
 * @Description : 第二版回溯
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {

    List<String> res = new ArrayList<>();
    Deque<String> path = new ArrayDeque<>(4);
    String s;
    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        dfs(0, 4);
        return res;
    }
    //剔除一些不变量，最后只保留当前索引和剩余段数
    public void dfs(int begin, int reside){
        if(begin == s.length()){
            //当遍历到最后一个字符且剩余段数为0时，将此时的path添加到结果中
            if(reside==0){
                res.add(String.join(".", path));
            }
            return;
        }
        //每段最多只截取3个数
        for(int i=begin; i<begin+3; i++){
            if(i >= s.length())
                break;
            //字符串剩余长度和分段所需长度
            if(s.length()-i > reside*3)
                continue;
            //当截取的字符串满足条件
            if(judgeNumber(s, begin, i)){
                String curS = s.substring(begin, i+1);
                path.addLast(curS);
                dfs(i+1, reside-1);
                path.removeLast();
            }
        }
    }

    public boolean judgeNumber(String s, int left, int right){
        int len = right - left + 1;
        //当前为0开头的且长度大于1的数字需要剪枝
        if(len>1 && s.charAt(left)=='0')
            return false;
        //将当前截取的字符串转化成数字
        int res = len<=0 ? 0 : Integer.parseInt(s.substring(left, right+1));
        //判断截取到的数字是否符合
        return res>=0 && res<=255;
    }
}
