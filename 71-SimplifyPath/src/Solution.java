import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName : Solution
 * @Author : Zhai Zhibin
 * @Date : 2021/9/19 22:24
 * @Description : 简化路径
 * @Modified_by :
 * @Version : 1.0
 **/

public class Solution {
    //给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
    //
    //在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。
    // 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
    //
    //请注意，返回的 规范路径 必须遵循下述格式：
    //
    //始终以斜杠 '/' 开头。
    //两个目录名之间必须只有一个斜杠 '/' 。
    //最后一个目录名（如果存在）不能 以 '/' 结尾。
    //此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
    //返回简化后得到的 规范路径 。

    public String simplifyPath(String path) {
        // 双端队列
        Deque<String> queue = new LinkedList<>();
        // 分割字符
        String[] res = path.split("/");
        for(int i = 0; i < res.length; i++){
            String s = res[i];
            if(s.equals(".") || s.equals("")) continue;
            else if (s.equals("..")){
                if(!queue.isEmpty()){
                    queue.pollLast();
                }
            }else{
                queue.offer(s);
            }
        }
        // 拼接
        StringBuilder sb = new StringBuilder("/");
        while(!queue.isEmpty()){
            sb.append(queue.poll());
            if(!queue.isEmpty()){
                sb.append("/");
            }
        }
        // 判空
        return sb.toString().equals("") ? "/" : sb.toString();
    }

    public static void main(String[] args) {
//        String s = "/a//b";
//        String[] arr = s.split("/");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(i + " " + arr[i] );
//        }


        String path = "/a//b////c/d//././/..";
//        new Solution().simplifyPath(path);
        System.out.println(new Solution().simplifyPath(path));
    }
}

