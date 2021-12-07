import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
// 返回一个表示每个字符串片段的长度的列表
public class Solution {

    public List<Integer> partitionLabels(String s) {

        int[] location = new int[s.length()];
        //遍历确定位置
        for (int i = 0; i < s.length(); i++) {
            location[i] = s.lastIndexOf(s.charAt(i));
        }

        List<Integer> list = new LinkedList<>();
        int start = 0;
        int end = location[0];
        for (int i = 0; i < location.length; i++) {
            if (end == location.length - 1) {
                int length = end - start + 1;
                list.add(length);
                break;
            }
            if (i < end) {
                end = Math.max(end, location[i]); //更新结尾的位置
            } else {
                int length = end - start + 1;
                list.add(length);
                start = end + 1;
                end = location[start];
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<Integer> list = solution.partitionLabels("jybmxfgseq");
        System.out.println(list.size());
        for (int i : list)
            System.out.println(i);

    }
}
