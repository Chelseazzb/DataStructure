public class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letter = new int[26]; //存储ransomNote中每个字符的出现次数

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            letter[c - 'a']++;
        }

        for (int j = 0; j < magazine.length(); j++) {
            char ch = magazine.charAt(j);
            if (letter[ch - 'a'] != 0)
                letter[ch-'a']--;
        }

        for (int k = 0; k < letter.length; k++) {
            if (letter[k] != 0)
                return false;
        }
        return true;
    }
}
