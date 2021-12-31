import java.util.Arrays;

//归并排序
public class MergeSort {

    //本算法不产生任何实例
    private MergeSort() {
    }

    //归并排序：分治，递归拆分为左右两部分
    public static void sort(Comparable[] arr) {
        // [l,r]区间左闭右闭
        mergeSort(arr, 0, arr.length - 1);
    }

    //递归：左右两边进行归并
    private static void mergeSort(Comparable[] arr, int left, int right) {
//        //1、递归终止条件
//        if (left >= right)
//            return;
        //第二处优化：在小范围使用插入排序，有序的可能更高
        if (right - left <= 15){
            insertionSort(arr,left,right);
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        //第一步优化：将排好序的左右两边合并，有序就不需要合并
        if (arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, left, mid, right);
    }

    private static void insertionSort(Comparable[] arr, int left, int right) {
        for (int i = left; i <= right ; i++) {
            Comparable temp = arr[i];
            int j = i;
            for (; j > 0 && arr[j-1].compareTo(temp)  > 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }

    //将[l,mid] 和 [mid+1,r] 合并为一段有序数组
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        //定义辅助数组
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {

            if (i > mid) {  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }


    }

    public static void main(String[] args) {
        //情况1：在有序数组的情况下，归并排序比插入排序慢（插入退化成O(n)）
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(100000, 20);
        Integer[] arr2 = SortTestHelper.copyArray(arr);
        SortTestHelper.testSort("InsertionSort", arr);
        SortTestHelper.testSort("MergeSort", arr2);
    }
}
