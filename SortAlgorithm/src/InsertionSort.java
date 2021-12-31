//插入排序，类似于洗牌
public class InsertionSort {

    // 我们的算法类不允许产生任何实例
    private InsertionSort() {
    }

    //插入排序和选择排序的区别是第二层循环可以提前结束，但是当前版本还是选择排序更快，因为交换这个操作也耗时比较长
//    public static void sort(Comparable[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//
//            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
//                swap(arr,j,j-1); //一次交换，三次赋值
//            }
//        }
//    }

    //第二版：改进的插入排序算法
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {

            Comparable e = arr[i]; //记录要进行向前插入的元素
            int j = i; //记录最后e应该放的位置
            for ( ; j > 0 && arr[j - 1].compareTo(e) > 0; j--) {
                arr[j] = arr[j-1]; //向后移动一位
            }
            arr[j] = e; //退出循环的条件是找到插入位置
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        //情况一：无序数组，选择排序略胜一筹
        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10000);
        Integer[] arr2 = SortTestHelper.copyArray(arr);
        SortTestHelper.testSort("InsertionSort", arr);
        SortTestHelper.testSort("SelectionSort", arr2);

        //情况二：几乎有序，插入排序优势明显
//        int N = 100000;
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 3);
//        Integer[] arr2 = SortTestHelper.copyArray(arr);
//        SortTestHelper.testSort("InsertionSort", arr);
//        SortTestHelper.testSort("SelectionSort", arr2);

        //情况3：完全有序的数组
//        int N = 100000;
//        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(10000,0);
//        Integer[] arr2 = SortTestHelper.copyArray(arr);
//        SortTestHelper.testSort("InsertionSort", arr);
//        SortTestHelper.testSort("SelectionSort", arr2);
    }
}
