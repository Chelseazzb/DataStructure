//冒泡排序
public class BubbleSort {
    //本算法不产生任何实例
    private BubbleSort() {
    }

    //冒泡算法核心思想：每次把最大的元素放到后面，每次排好一个元素
//    public static void sort(Comparable[] arr) {
//        //每次都需要从头到尾遍历
//        for (int i = 0; i < arr.length; i++) {
//            //已经有i个排好序了
//            for (int j = 0; j < arr.length - i - 1; j++) {
//                if (arr[j].compareTo(arr[j + 1]) > 0)
//                    swap(arr,j,j+1);
//            }
//        }
//    }

    //优化
    public static void sort(Comparable[] arr) {
        //每次都需要从头到尾遍历
        for (int i = 0; i < arr.length; i++) {
            //已经有i个排好序了
            int maxIndex = 0; //找到最大值的位置索引
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j].compareTo(arr[maxIndex]) > 0)
                    maxIndex = j;
            }
            swap(arr,maxIndex,arr.length-i-1); //只用交换N次
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10000);
        Integer[] arr2 = SortTestHelper.copyArray(arr);
        Integer[] arr3 = SortTestHelper.copyArray(arr);
        Integer[] arr4 = SortTestHelper.copyArray(arr);
        SortTestHelper.testSort("BubbleSort", arr);
        SortTestHelper.testSort("SelectionSort", arr2);
        SortTestHelper.testSort("InsertionSort",arr3);
        SortTestHelper.testSort("SelectionSort2", arr4);

    }
}
