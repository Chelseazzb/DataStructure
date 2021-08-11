import java.util.ArrayList;
import java.util.TreeSet;

//给定两个数组，编写一个函数来计算它们的交集。
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        TreeSet<Integer> treeSet = new TreeSet<>();

        //遍历第一个集合，找到唯一的元素
        for (int i : nums1){
            treeSet.add(i);
        }

        //遍历第二个集合，共同元素放到list中
        ArrayList<Integer> list = new ArrayList<>();
        for (int j : nums2){
            if (treeSet.contains(j)) {
                list.add(j);
                //需要在集合中也删除，否则会有重复元素
                treeSet.remove(j);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {


            result[i] = list.get(i);
        }

        return result;
    }
}
