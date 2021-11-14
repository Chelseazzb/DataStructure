import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/11/14 19:34
 * @Description : 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution {

    String[] map;
    List<String> list;
    StringBuilder path;
    public List<String> letterCombinations(String digits) {
        list = new ArrayList<>();

        if (digits.length() == 0) //处理边界值
            return list;

        map = new String[]{
                "",    //0
                "",    //1
                "abc", //2
                "def", //3
                "ghi", //4
                "jkl", //5
                "mno", //6
                "pqrs",//7
                "tuv", //8
                "wxyz",//9
        };
        path = new StringBuilder();
        backTracking(digits,0);
        return list;
    }

    private void backTracking(String digits,int index){
        //1、回溯终止条件
        if (index == digits.length()){
            list.add(path.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letter = map[digit];
        for (int i = 0; i < letter.length(); i++) {
            path.append(letter.charAt(i));
            backTracking(digits,index + 1);
            path.deleteCharAt(path.length());
        }
    }
}
