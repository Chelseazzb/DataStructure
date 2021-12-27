public class Solution2 {

    //构建大根堆
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        //建堆完毕后，nums【0】为最大元素。逐个删除堆顶元素，直到删除了k-1个。
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            //先将堆的最后一个元素与堆顶元素交换，由于此时堆的性质被破坏，需对此时的根节点进行向下调整操作。
            swap(nums, 0, i);
            //相当于删除堆顶元素，此时长度变为nums.length-2。即下次循环的i
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize) {
        //从最后一个父节点位置开始调整每一个节点的子树。数组长度为heasize，因此最后一个节点的位置为heapsize-1，所以父节点的位置为heapsize-1-1/2。
        for (int i = (heapSize-1)/ 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize) {      //调整当前结点和子节点的顺序。
        //left和right表示当前父节点i的两个左右子节点。
        int left = i * 2 + 1, right = i * 2 + 2, largest = i;
        //如果左子点在数组内，且比当前父节点大，则将最大值的指针指向左子点。
        if (left < heapSize && a[left] > a[largest]) {
            largest = left;
        }
        //如果右子点在数组内，且比当前父节点大，则将最大值的指针指向右子点。
        if (right < heapSize && a[right] > a[largest]) {
            largest = right;
        }
        //如果最大值的指针不是父节点，则交换父节点和当前最大值指针指向的子节点。
        if (largest != i) {
            swap(a, i, largest);
            //由于交换了父节点和子节点，因此可能对子节点的子树造成影响，所以对子节点的子树进行调整。
            maxHeapify(a, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
