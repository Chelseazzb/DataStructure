public class Solution1 {

    private int[] getNext(String s){
        char[] arr = s.toCharArray();
        int[] next = new int[arr.length];
        int i = 0;
        int j = -1;
        next[0] = -1;

        for (i = 1; i < arr.length; i++) {
            while (j >= 0 && arr[i] != arr[j+1])
                j = next[j];

            if (arr[i] == arr[j+1]){
                j ++;
            }

            next[i] = j;
        }
        return next;
    }

    public boolean repeatedSubstringPattern(String s) {
        int[] next = getNext(s);

        int size = s.length();

        if (next[next.length - 1] != -1 && size % (size - (next[next.length-1] + 1)) == 0 ) //有重复子串
            return true;

        return false;
    }
}
