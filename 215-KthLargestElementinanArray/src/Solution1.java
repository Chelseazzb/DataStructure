import java.util.Random;

/**
 * 快速排序
 */
class Solution1 {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        // 要找到的元素所在索引:  前K大，即倒数索引第K个
        int index = nums.length - k;
        int right = nums.length - 1;
        int left = 0;
        return quickSelect(nums, left, right, index);
    }

    public int quickSelect(int[] nums, int left, int right, int index) {
        // 得到分区值索引q
        int q = randomPartition(nums, left, right);


        if (q == index) {
            // 如果刚好索引q就是想要的索引，则直接返回
            return nums[q];

        } else {
            // 如果不是，比较q 与 index ,确定下次要检索的区间, 要么是[q+1, right], 要么就是[left, q-1]
            return q < index ? quickSelect(nums, q + 1, right, index) : quickSelect(nums, left, q - 1, index);
        }
    }

    public int randomPartition(int[] nums, int l, int r) {
        // 1. 随机数范围: [0, r-l+1) 同时加l, 则是 [l, r+1) = [l, r] 也就是在这个[l,r] 中随机选一个索引出来
        int i = random.nextInt(r - l + 1) + l;

        // 2. 交换nums[i]， nums[r], 也就是将随机数先放在[l,r]最右边nums[r]上
        swap(nums, i, r);
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        // 3. 在调用当前方法的randomPartition方法中，已经确定了了随机数是nums[r]
        int x = nums[r], i = l - 1;

        // 首先比较区间在[l， r]之间， 所以nums[j]中的    l<= j <= r
        for (int j = l; j < r; ++j) {
            // 4. nums[j] 跟随机数 x 比较, 小于x的数都跟[l,r]左边区间交换，i=l-1,所以++i=l,初始索引就是l,
            if (nums[j] <= x) {
                swap(nums, ++i, j);//两两交换
            }
        }// 这个for循环操作就是将小于 x 的数都往[i, j]的左边区间设置，从而实现存在[l, i]区间,使得对应数值都 小于 x

        //5. 既然已经将<x的值都放在一边了，现在将x也就是nums[r] 跟nums[i+1]交换，从而分成两个区间[l.i+1]左, [i+2, r]右，左边区间的值都小于x
        swap(nums, i + 1, r);

        // 然后返回这个分区值
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
