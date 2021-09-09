public class Solution1 {
    public String reverseLeftWords(String s, int n) {
        String res = "";
        for(int i = n; i < s.length(); i++)
            res += s.charAt(i);
        for(int i = 0; i < n; i++)
            res += s.charAt(i);
        return res;

//        StringBuilder res = new StringBuilder();
//        for(int i = n; i < s.length(); i++)
//            res.append(s.charAt(i));
//        for(int i = 0; i < n; i++)
//            res.append(s.charAt(i));
//        return res.toString();

    }
}
