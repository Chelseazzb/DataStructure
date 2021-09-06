//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
//注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean isAnagram(String s, String t) {
        //判断边界条件，字符长度一致
        if (s.length() != t.length())
            return false;

        //定义集合映射保存字符和出现次数
        Map<Character,Integer> map = new HashMap<>();

        //遍历第一个字符串
        char c;
        char ch;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);
            } else{
                map.put(c,1);
            }
        }

        //遍历第二个字符串，如果字符存在，value就减一，减到0就删除
        for (int i = 0; i < t.length(); i++) {
            ch = t.charAt(i);
            if (!map.containsKey(ch)){
                return false;
            } else {
                //当value==1时，map中删除ch
                if (map.get(ch) == 1)
                    map.remove(ch);
                else {
                    map.put(ch,map.get(ch)-1);
                }
            }
        }


        if (map.isEmpty())
            return true;
        else
            return false;

    }
}
