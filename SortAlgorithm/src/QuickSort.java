import java.util.Random;

public class QuickSort {

    //本算法不产生任何实例
    private QuickSort(){}

    //外部调用算法
    public static void sort(Comparable[] arr){
        quickSort(arr,0,arr.length-1);
    }

    //递归快排
    private static void quickSort(Comparable[] arr,int left,int right){
//        //1、递归终止条件
//        if (left >= right)
//            return;

        //第一处优化：在范围小的时候，使用插入排序
        if (right - left <= 15){
            insertionSort(arr,left,right);
            return;
        }


        int p = partition(arr,left,right);
        quickSort(arr,left,p-1);
        quickSort(arr,p+1,right);
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

    //以left元素作为分割点，将数组拆分为左边都比left元素小，右边都比left大
    //最差情况：退化为O(n^2)
    private static int partition(Comparable[] arr, int left, int right) {

        //优化一：随机选取分割点
        swap(arr,left, (int)(Math.random()*(right-left+1))+left);

        Comparable e = arr[left];

        //arr[l+1,j] < e, arr[j+1,i) > e
        int j = left; //记录分割点元素的下标
        for (int i = left + 1; i <= right; i++) {
            if (arr[i].compareTo(e) < 0){
                swap(arr,i,j+1);
                j ++;
            }
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
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,N);
        Integer[] arr2 = SortTestHelper.copyArray(arr);
        SortTestHelper.testSort("QuickSort", arr);
        SortTestHelper.testSort("MergeSort", arr2);

        Integer[] arr3 = SortTestHelper.generateNearlyOrderedArray(N,100);
        Integer[] arr4 = SortTestHelper.copyArray(arr3);
        SortTestHelper.testSort("QuickSort", arr3);
        SortTestHelper.testSort("MergeSort", arr4);

        Integer[] arr5 = SortTestHelper.generateRandomArray(N,0,10);
        Integer[] arr6 = SortTestHelper.copyArray(arr);
        SortTestHelper.testSort("QuickSort", arr5);
        SortTestHelper.testSort("MergeSort", arr6);
    }
}
