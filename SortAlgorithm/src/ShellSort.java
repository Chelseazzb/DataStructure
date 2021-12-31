//希尔排序是插入排序的延伸
//希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
//该算法是冲破O(n^2）的第一批算法之一
public class ShellSort {

    // 我们的算法类不允许产生任何实例
    public ShellSort() {
    }

//    public static void sort(Comparable[] arr){
//        int length = arr.length;
//        int group = length / 2; //奇数的时候正好是中间元素，偶数时偏右
//        while (group > 0){
//            //从后向前遍历
//            for (int i = group; i < length; i++) {
//                int j = i;
//                //单独处理每个分组
//                while (j >= 0){
//                    //直接进行插入排序
//                    if (j - group >= 0 && arr[j].compareTo(arr[j-group]) < 0)
//                        swap(arr,j,j-group);
//                    j -= group;
//                }
//            }
//            group /= 2; //缩小范围
//        }
//    }

    //优化版本：使用赋值代替交换
    public static void sort(Comparable[] arr) {
        int length = arr.length;
        int group = length / 2; //奇数的时候正好是中间元素，偶数时偏右
        while (group > 0) {
            //从后向前遍历
            for (int i = group; i < length; i++) {
                int j = i;
                Comparable temp = arr[j];
                //单独处理每个分组
                if (arr[j].compareTo(arr[j - group]) < 0) {
                    while (j - group >= 0 && temp.compareTo(arr[j - group]) < 0) {
                        //移动法
                        arr[j] = arr[j - group];
                        j -= group;
                    }
                    arr[j] = temp;
                }
            }
            group /= 2; //缩小范围
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10000);
        Integer[] arr2 = SortTestHelper.copyArray(arr);
        Integer[] arr3 = SortTestHelper.copyArray(arr);
        Integer[] arr4 = SortTestHelper.copyArray(arr);
        SortTestHelper.testSort("InsertionSort", arr);
        SortTestHelper.testSort("ShellSort", arr2);
        SortTestHelper.testSort("SelectionSort2", arr3);
        SortTestHelper.testSort("BubbleSort", arr4);
    }


}
