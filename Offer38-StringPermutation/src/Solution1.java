import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//全排列+去重
public class Solution1 {

    //还要强调的是去重一定要对元素经行排序，这样我们才方便通过相邻的节点来判断是否重复使用了
    List<String> res;
    StringBuilder tmp;
    boolean[] visited;
    public String[] permutation(String s) {
        //全局变量初始化
        this.res = new ArrayList<String>();
        this.tmp = new StringBuilder();
        this.visited = new boolean[s.length()];

        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        dfs(temp,0);
        return res.toArray(new String[0]);
    }

    void dfs(char[] cs,int depth){
        if(depth == cs.length){
            res.add(tmp.toString());
            return;
        }
        for(int i = 0; i < cs.length; i++){
            if(visited[i])  continue;
            if(i > 0 && cs[i - 1] == cs[i] && !visited[i - 1])  continue;

            tmp.append(cs[i]);
            visited[i] = true;

            dfs(cs,depth + 1);

            visited[i] = false;
            tmp.deleteCharAt(tmp.length() - 1);
        }

    }
}
