import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26]; //一共就26个字母
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i; //记录每个字符最后出现的位置
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']); //更新右边界
            if (i == end) { //到达右边界
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
