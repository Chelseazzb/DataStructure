package per.zzb.Array;
/**
 * @Author Zhai Zhibin
 * @Description 数组的基础定义和遍历
 * @Date 2020/9/26 10:31
 * @MethodName
 * @Param
 * @Return
 **/
public class Main {

    public static void main(String[] args) {
//	// 一些数组的基本操作
//        System.out.println("Hey DataStructure");
//
//        int[] arr = new int[10];
//        for (int i = 0 ; i < arr.length ; i ++){
//            arr[i] = i; //循环为每个位置初始化
//        }
//
//        int[] scores = new int[]{100,85,60};
//        for (int score: scores) {
//            System.out.println("score = " + score);
//        }
//    }
        MyArray myArray = new MyArray(20);
        for (int j = 0; j < 10; j++) {
            myArray.addLast(j);
        }
        System.out.println(myArray);

        myArray.add(1,100);
        System.out.println(myArray);

        myArray.addFirst(-1);
        System.out.println(myArray);

        System.out.println("the sixth of array is : " + myArray.get(5));

        myArray.set(1,9);
        System.out.println(myArray);

        System.out.println("count of 9 in array : " + myArray.contain(9));

        System.out.println("myArray.find(100) = " + myArray.find(100));

        myArray.remove(0);
        System.out.println(myArray);

        myArray.removeFirst();
        System.out.println(myArray);

        myArray.removeLast();
        System.out.println(myArray);

        myArray.removeElement(1);
        System.out.println(myArray);

        myArray.addFirst(2);
        System.out.println(myArray);

        System.out.println("myArray.findAll(2) = " + myArray.findAll(2));

        myArray.removeAllElement(2);
        System.out.println(myArray);

        //尝试边界情况，是不是预期的效果
        myArray.add(20,2);
    }
}
