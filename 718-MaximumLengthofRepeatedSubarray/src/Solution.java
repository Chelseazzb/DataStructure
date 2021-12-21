//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
public class Solution {

    //1 <= len(A), len(B) <= 1000
    //0 <= A[i], B[i] < 100
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int result = 0;
        for (int i = 0; i < len1; i++) {
            int count = 0;
            for (int j = 0; j < len2; j++) {
                if (nums2[j] != nums1[i])
                    continue;
                else { //找到第一个相等元素
                    count=1;
                    int index1 = i+1;
                    int index2 = j+1;
                    while (index1 < len1 && index2 < len2){
                        if (nums1[index1 ++] == nums2[index2 ++]){
                            count ++;
                        } else {
                            break;
                        }
                    }
                    if (count > result) result = count;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0,0,0,0,0};
        int[] nums2 = new int[]{0,0,0,0,0};

        System.out.println(new Solution().findLength(nums1,nums2));
    }
}
