import java.util.ArrayList;
import java.util.TreeMap;

//给定两个数组，编写一个函数来计算它们的交集。
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        TreeMap<Integer,Integer> map = new TreeMap<>();

        for (int i : nums1){
            if (map.containsKey(i)){
                map.put(i,map.get(i)+1); //写入重复元素的个数
            } else {
                map.put(i,1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        //遍历第二个数组
        for (int j : nums2){
            if (map.containsKey(j)){
                list.add(j);
                map.put(j,map.get(j)-1);

                //当value为0时可以直接清除map中的元素
                if (map.get(j) == 0){
                    map.remove(j);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
