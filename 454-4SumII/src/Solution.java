import java.util.HashMap;
import java.util.Map;

//使用hashmap来实现
public class Solution {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();

        //遍历求得前两个数组和及出现的次数
        for (int a : nums1){
            for (int b : nums2){
                int sum = a+b;
                if (map.containsKey(sum)){
                    map.put(sum,map.get(sum) + 1);
                } else {
                    map.put(sum,1);
                }
            }
        }

        //遍历后两个数组，看后两个元素取反是否在之前的map中存在
        for (int c : nums3){
            for (int d : nums4){
                if (map.containsKey(-c-d)){
                    ans += map.get(-c-d);
                }
            }
        }

        return ans;
    }
}
