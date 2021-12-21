public class Solution1 {

    //双指针法
    //0 <= s.length <= 100
    //0 <= t.length <= 10^4
    //两个字符串都只由小写字符组成。
    public boolean isSubsequence(String s, String t) {
        //判断边界条件
        if (t.length() == 0 && s.length() == 0)
            return true;
        if (t.length() == 0)
            return false;
        if (s.length() == 0)
            return true;

        int index1 = 0;
        int index2 = 0;

        while (index1 < s.length() && index2 < t.length()){
            if (s.charAt(index1) == t.charAt(index2)){
                index1 ++;
                index2 ++;
            } else {
                index2 ++;
            }
        }

        return index1 == s.length();
    }
}
