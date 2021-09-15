//给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        return (s+s).indexOf(s,1) != s.length();
    }
}
