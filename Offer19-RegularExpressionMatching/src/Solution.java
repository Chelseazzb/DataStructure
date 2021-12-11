//请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
// 而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。
// 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。


public class Solution {

    //s 可能为空，且只包含从 a-z 的小写字母。
    //p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。

    // 最直观版
    //还不能完全理解状态转移方程
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        // dp[i][j]表示s前i-1个字符,p前j-1个字符是否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        // dp[0][0] :s前0个字符和p的前0个字符默认是空串=匹配
        // 注意：由于多了[0][0],所以dp[i][j],定位到的是s[i-1]和p[j-1]的字符
        dp[0][0] = true;
        // 初始化首行:当s为空串,p的偶数位为*才能匹配
        for (int j = 2; j < n + 1; j += 2) {
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        }
        // 状态转移
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // 当p[j-1]=*时,有三种情况
                if (p.charAt(j - 1) == '*') {
                    if (dp[i][j - 2]) {// p[j-2]出现0次,i和j指向字符的长度均相同
                        dp[i][j] = true;
                    } else if (dp[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2)) {// p[j-2]出现1次 且 当前i-1和j-2指向的字符相同
                        dp[i][j] = true;
                    } else if (dp[i - 1][j] && p.charAt(j - 2) == '.') {// 最特殊情况:p[j-2]=. p[j-1]=*时 是万能匹配
                        dp[i][j] = true;
                    }
                } else {// 当p[j-1]!=*时,有两种情况
                    if (dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1)) {// 前面元素之前都匹配 且 当前元素也相容
                        dp[i][j] = true;
                    } else if (dp[i - 1][j - 1] && p.charAt(j - 1) == '.') { //  前面元素之前都匹配 且 p的当期元素是.
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[m][n];
    }

    //动态规划解析：
    //状态定义： 设动态规划矩阵 dp ， dp[i][j] 代表字符串 s 的前 i 个字符和 p 的前 j 个字符能否匹配。
    //
    //转移方程： 需要注意，由于 dp[0][0] 代表的是空字符的状态， 因此 dp[i][j] 对应的添加字符是 s[i - 1] 和 p[j - 1] 。
    //
    //当 p[j - 1] = '*' 时， dp[i][j] 在当以下任一情况为 true 时等于 true ：
    //1、dp[i][j - 2]： 即将字符组合 p[j - 2] * 看作出现 0 次时，能否匹配；
    //2、dp[i - 1][j] 且 s[i - 1] = p[j - 2]: 即让字符 p[j - 2] 多出现 1 次时，能否匹配；
    //3、dp[i - 1][j] 且 p[j - 2] = '.': 即让字符 '.' 多出现 1 次时，能否匹配；
    //
    // 当 p[j - 1] != '*' 时， dp[i][j] 在当以下任一情况为 true 时等于 true ：
    //1、dp[i - 1][j - 1] 且 s[i - 1] = p[j - 1]： 即让字符 p[j - 1] 多出现一次时，能否匹配；
    //2、dp[i - 1][j - 1] 且 p[j - 1] = '.'： 即将字符 . 看作字符 s[i - 1] 时，能否匹配；


    public static void main(String[] args) {

        new Solution().isMatch("aaa","a*");
    }
}
