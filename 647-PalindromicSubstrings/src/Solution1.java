public class Solution1 {

    //使用动态规划
    //1 <= s.length <= 1000
    //s 由小写英文字母组成
    public int countSubstrings(String s) {
        int result = 0;
        int[] dp = new int[s.length()+1]; //代表截止到第i-1个字符，最多有多少个回文子串

        for (int start = 0; start < s.length(); start++) {
            for (int end = start + 1; end <= s.length() ; end++) {
                if (isPalindromic(s.substring(start,end))){
                    dp[end] = dp[end-1] + 1;
                }
            }
        }
        return dp[s.length()];
    }

    //判断是否为回文串
    private static boolean isPalindromic(String s){
        int start = 0;
        int end = s.length() - 1;

        while (start < end){
            if (s.charAt(start) == s.charAt(end)){
                start ++;
                end --;
            }else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(isPalindromic(s));
        System.out.println(new Solution1().countSubstrings(s));
    }
}
