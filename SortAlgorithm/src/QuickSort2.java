//优化partition函数，避免当很多元素相等时，退化到O(N^2)
public class QuickSort2 {
    //本算法不产生任何实例
    private QuickSort2() {
    }

    //外部调用算法
    public static void sort(Comparable[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    //递归快排
    private static void quickSort(Comparable[] arr, int left, int right) {
//        //1、递归终止条件
//        if (left >= right)
//            return;

        //第一处优化：在范围小的时候，使用插入排序
        if (right - left <= 15) {
            insertionSort(arr, left, right);
            return;
        }


        int p = partition(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p + 1, right);
    }

    private static void insertionSort(Comparable[] arr, int left, int right) {
        for (int i = left; i <= right; i++) {
            Comparable temp = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1].compareTo(temp) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    //以left元素作为分割点，将数组拆分为左边都不大于left元素，右边都不小于left
    private static int partition(Comparable[] arr, int left, int right) {

        //优化一：随机选取分割点
        swap(arr, left, (int) (Math.random() * (right - left + 1)) + left);

        Comparable e = arr[left];

        //arr[l+1,i) <= e, arr(j,r] >= e
        int i = left + 1;
        int j = right;
        while (true) {

            while (i <= right && arr[i].compareTo(e) < 0) i ++;
            while (j > left && arr[j].compareTo(e) > 0) j --;
            if (i > j)
                break;
            swap(arr,i,j);
            i++;
            j--;

        }
        swap(arr,j,left);
        return j;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr1 = SortTestHelper.copyArray(arr);
        Integer[] arr2 = SortTestHelper.copyArray(arr);
        SortTestHelper.testSort("QuickSort", arr);
        SortTestHelper.testSort("QuickSort2", arr1);
        SortTestHelper.testSort("MergeSort", arr2);

        Integer[] arr3 = SortTestHelper.generateNearlyOrderedArray(N, 100);
        Integer[] arr4 = SortTestHelper.copyArray(arr3);
        Integer[] arr5 = SortTestHelper.copyArray(arr3);
        SortTestHelper.testSort("QuickSort", arr3);
        SortTestHelper.testSort("QuickSort2", arr4);
        SortTestHelper.testSort("MergeSort", arr5);

        Integer[] arr6 = SortTestHelper.generateRandomArray(N, 0, 10);
        Integer[] arr7 = SortTestHelper.copyArray(arr6);
        Integer[] arr8 = SortTestHelper.copyArray(arr6);
        SortTestHelper.testSort("QuickSort", arr6);
        SortTestHelper.testSort("QuickSort2", arr7);
        SortTestHelper.testSort("MergeSort", arr8);
    }
}
