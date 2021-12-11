public class Solution1 {

    //剑指官方的解法

    public boolean isNumber(String s) {
        char[] arr = s.trim().toCharArray();
        if (arr.length == 0) return false;
        int index = 0;
        if (arr[index] == '+' || arr[index] == '-') {
            index++;
        }
        int cur = index;
        index = scanUnsignedInteger(arr, index);
        boolean numeric = (index > cur); //判断是否有数字
        if (index < arr.length && arr[index] == '.') { //会先出现小数点之后再出现e/E
            //略过小数点
            index++;
            cur = index;
            index = scanUnsignedInteger(arr, index);
            numeric = (index > cur) || numeric; //可以是三种情况，前面有，后面有或者前后都有
        }
        if (index < arr.length && (arr[index] == 'e' || arr[index] == 'E')) {
            //略过e/E
            index++;
            //略过符号位
            if (index < arr.length &&(arr[index] == '+' || arr[index] == '-')) {
                index++;
            }
            cur = index;
            index = scanUnsignedInteger(arr, index);
            numeric = (index > cur) && numeric; //前面是数字，而且后面也有数字
        }
        return numeric && index == arr.length; //是数字，且全部遍历完成
    }

    //跳过数字，并返回非字符的第一个位置
    public int scanUnsignedInteger(char[] arr, int index) {
        while (index < arr.length && arr[index] >= '0' && arr[index] <= '9') {
            index++;
        }
        return index;
    }
}
