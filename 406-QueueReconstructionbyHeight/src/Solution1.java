import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public int[][] reconstructQueue(int[][] people) {
        //按数组第一个元素进行降序，按第二个元素进行升序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2){
                if (person1[0] != person2[0]){
                    //第一个元素不相等时，第一个元素降序
                    return person2[0] - person1[0];
                }else{
                    //第一个元素相等时，第二个元素升序
                    return person1[1] - person2[1];
                }
            }
        });
        //新建一个list,用于保存结果集
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            if (list.size() > people[i][1]){
                //结果集中元素个数大于第i个人前面应有的人数时，将第i个人插入到结果集的 people[i][1]位置
                list.add(people[i][1],people[i]);
            }else{
                //结果集中元素个数小于等于第i个人前面应有的人数时，将第i个人追加到结果集的后面
                list.add(list.size(),people[i]);
            }
        }
        //将list转化为数组，然后返回
        return list.toArray(new int[list.size()][]);
    }
}
