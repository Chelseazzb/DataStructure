import java.util.Arrays;

//归并排序自底向上
public class MergeSortBU {

    //本算法不产生任何实例
    private MergeSortBU() {
    }

    //自底向上方法，归并排序
    public static void sort(Comparable[] arr){
        int n = arr.length;

        // Merge Sort Bottom Up 无优化版本
//        for (int sz = 1; sz < n; sz *= 2)
//            for (int i = 0; i < n - sz; i += sz+sz)
//                // 对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1] 进行归并
//                merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1));

        // Merge Sort Bottom Up 优化
        // 对于小数组, 使用插入排序优化
        for( int i = 0 ; i < n ; i += 16 )
            insertionSort(arr, i, Math.min(i+15, n-1) );

        for( int sz = 16; sz < n ; sz += sz )
            for( int i = 0 ; i < n - sz ; i += sz+sz )
                // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
                if( arr[i+sz-1].compareTo(arr[i+sz]) > 0 )
                    merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1) );
    }

    //使用之前实现的归并方法
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

    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(10000,0,1000000);
        Integer[] arr2 = SortTestHelper.copyArray(arr);
        SortTestHelper.testSort("MergeSortBU", arr);
        SortTestHelper.testSort("MergeSort", arr2);
    }
}
