public class Solution1 {

    //使用递归的方式
    public boolean isMatch(String s, String p) {
        int length = s.length();
        int pattern = p.length();

        return isMatch(s, length, p, pattern, 0, 0);
    }

    private boolean isMatch(String s, int length, String p, int pattern, int sStart, int pStart) {

        //1、递归终止条件
        if (sStart == length && pStart >= pattern) //字符串s和模式p都遍历到最后才返回true
            return true;

        if (sStart < length && pStart >= pattern) //字符串s还有，但是模式p没了就返回false
            return false;

        if (sStart >= length) {//字符串已经遍历到最后了
            System.out.println(pStart);
            return cutP(p,pStart,pattern);
        }

        //p只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'
        if (pStart + 1 < pattern && p.charAt(pStart + 1) == '*') { //最为复杂的情况
            if (p.charAt(pStart) == s.charAt(sStart) || p.charAt(pStart) == '.') {
                return isMatch(s, length, p, pattern, sStart + 1, pStart + 2) //进入下一个匹配状态
                        || isMatch(s, length, p, pattern, sStart + 1, pStart) //模式p原地不动
                        || isMatch(s, length, p, pattern, sStart, pStart + 2); //直接跳过 a*，模式向后移动两位

            } else {
                return isMatch(s, length, p, pattern, sStart, pStart + 2); //直接跳过 a*，模式向后移动两位
            }
        }

        if (p.charAt(pStart) == s.charAt(sStart) || p.charAt(pStart) == '.')
            return isMatch(s, length, p, pattern, sStart + 1, pStart + 1); //两个字符串都向后移动一位

        return false;
    }

    private boolean cutP(String p, int pStart, int pattern) {

        //必须还剩偶数个，且每个第二位都是'*'
        if ( (pattern-pStart) % 2 != 0)
            return false;

        for (int i = pStart + 1; i < pattern; i += 2) {
            if (p.charAt(i) != '*')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        new Solution1().isMatch("ab", ".*c");
        System.out.println(new Solution1().isMatch("ab", "abc*"));
    }
}
