import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @ClassName : Solution1
 * @Author : Zhai Zhibin
 * @Date : 2021/8/19 11:47
 * @Description : 使用java自带的PriorityQueue(最小堆)，并使用Comparator
 * @Modified_by :
 * @Version : 1.0
 **/
public class Solution2 {

    private class Freq {
        public int v;
        public int f;

        public Freq(){}

        public Freq(int v,int f){
            this.v = v;
            this.f = f;
        }

    }

    private class FreqComparator implements Comparator<Freq>{

        @Override
        public int compare(Freq a, Freq b) {
            return a.f - b.f;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        //第一步，计算nums中元素的频率
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int num : nums){
            if (!map.containsKey(num)){
                map.put(num,1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        //第二步，将频率高的前k个元素放到优先队列中中
        PriorityQueue<Freq> queue = new PriorityQueue<>(new FreqComparator());
        for (int key : map.keySet()){

            //需要判断queue中元素个数是否已经到达k个
            if (queue.size() < k){
                queue.add(new Freq(key,map.get(key)));
            } else if (map.get(key) > queue.peek().f){ //如果后来的key的频率比前k个中最小的大
                //先出队，再入队
                queue.remove();
                queue.add(new Freq(key,map.get(key)));
            }

        }


        //第三步，将最大堆中的前k个元素一个个取出
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.remove().v;
        }

        return res;
    }
}
