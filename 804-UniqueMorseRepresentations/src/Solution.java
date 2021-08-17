import java.util.TreeSet;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/8/17 17:32
 * @Description : ToDo
 * @Modified_by :
 * @Version : 1.0
 **/
class Solution {
    public int uniqueMorseRepresentations(String[] words) {

        //已知条件，字母对应的摩斯密码
        String[] map = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..",
                "--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        TreeSet<String> set = new TreeSet<>();

        //遍历生成数组中每个单词的摩斯密码
        for (String word : words){
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                res.append(map[word.charAt(i) - 'a']);
             }
            set.add(res.toString());
        }



        return set.size();
    }
}
