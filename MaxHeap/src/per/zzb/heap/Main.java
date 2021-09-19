package per.zzb.heap;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName : Main
 * @Author : Zhai Zhibin
 * @Date : 2021/8/16 10:39
 * @Description : 堆的测试类
 * @Modified_by :
 * @Version : 1.0
 **/
public class Main {

    public double testHeap(Integer[] testData, boolean isHeapify) {

        long startTime = System.nanoTime();


        MaxHeap<Integer> maxHeap;

        if (isHeapify){
            maxHeap = new MaxHeap<>(testData);
        } else {
            maxHeap = new MaxHeap<>(testData.length);
            for (int num : testData)
                maxHeap.add(num);
        }

        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++)
            arr[i] = maxHeap.extractMax();

        for (int i = 1; i < testData.length; i++)
            if (arr[i - 1] < arr[i])
                throw new IllegalArgumentException("Error");

        System.out.println("Test MaxHeap completed.");

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;

//        long startTime = System.nanoTime();
//
//        MaxHeap<Integer> maxHeap;
//        if(isHeapify)
//            maxHeap = new MaxHeap<>(testData);
//        else{
//            maxHeap = new MaxHeap<>(testData.length);
//            for(int num: testData)
//                maxHeap.add(num);
//        }
//
//        int[] arr = new int[testData.length];
//        for(int i = 0 ; i < testData.length ; i ++)
//            arr[i] = maxHeap.extractMax();
//
//        for(int i = 1 ; i < testData.length ; i ++)
//            if(arr[i-1] < arr[i])
//                throw new IllegalArgumentException("Error");
//        System.out.println("Test MaxHeap completed.");
//
//        long endTime = System.nanoTime();
//
//        return (endTime - startTime) / 1000000000.0;

    }

    public static void main(String[] args) {
        int n = 10000000;
//
//        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
//        for(int i = 0 ; i < n ; i ++)
//            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
//
//        int[] arr = new int[n];
//        for(int i = 0 ; i < n ; i ++)
//            arr[i] = maxHeap.extractMax();
//
//        for(int i = 1 ; i < n ; i ++)
//            if(arr[i-1] < arr[i])
//                throw new IllegalArgumentException("Error");
//
//        System.out.println("Test MaxHeap completed.");

        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }


        System.out.println("Heapify的时间：" + new Main().testHeap(testData,true));
        System.out.println("Add的时间：" + new Main().testHeap(testData,false));
    }
}
