//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
// 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。


public class Solution {

    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        int size = s.length();
        char[] arr = s.toCharArray();
        int count = 0;

        for (int i = 0; i < n; i++) {
            res.append(arr[i]);
        }

        for (int i = 0; i < size - n; i++) {
            arr[i] = arr[i + n];
        }

        for (int i = size - n; i < size; i++) {
            arr[i] = res.charAt(count++);
        }


        return new String(arr);
    }
}
