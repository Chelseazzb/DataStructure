/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/11/17 10:47
 * @Description : 修改原字符串，不额外存储
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution1 {

    //双指针法
    public String replaceSpace(String s) {
        int tail = s.length()-1; //s原来的最后一个字符位置
        int count = 0; //统计空格数量
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                count ++;
        }
        if (count == 0) //没有空格
            return s;


        int newTail = tail + 2 * count; //得到s最新的尾部字符位置
        char[] arr = new char[newTail + 1];
        while (tail >= 0 && newTail > tail){ //开始移动两个指针
            if (s.charAt(tail) == ' '){
                tail --;
                arr[newTail --] = '0';
                arr[newTail --] = '2';
                arr[newTail --] = '%';
            } else {
                arr[newTail --] = s.charAt(tail --);
            }
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().replaceSpace("We are happy."));
    }
}
