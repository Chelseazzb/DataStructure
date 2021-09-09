//使用kmp实现
public class Solution1 {

    int[] getNext(String s){
        int i =0;
        int j = -1; //避免死循环，提前往前-1，当找到位置时j+1
        char[] arr = s.toCharArray();
        int[] next = new int[s.length()];
        next[0] = -1;

        for (i = 1; i < s.length(); i++) {
            while (j >= 0 && arr[i] != arr[j+1])
                j = next[j];

            if (arr[i] == arr[j+1]){ //找到相同的前后缀
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public int strStr(String haystack, String needle) {

        //判断边界条件
        if (needle.equals(""))
            return 0;

        int[] next = new int[needle.length()];
        int j = -1;
        next = getNext(needle);
        System.out.println(next);
        char[] s = haystack.toCharArray();

        for (int i = 0; i < haystack.length(); i++) {

            while (j >= 0 && s[i] != needle.charAt(j+1))
                j = next[j]; //回溯

            if (s[i] == needle.charAt(j+1))
                j++;

            if (j == (needle.length() -1) )
                return (i - j);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("aabaabaafa","aabaaf"));
    }
}
