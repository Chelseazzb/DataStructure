package per.zzb;

/**
 * @ClassName : Main
 * @Author : Zhai Zhibin
 * @Date : 2021/8/24 13:58
 * @Description : 线段树的测试类
 * @Modified_by :
 * @Version : 1.0
 **/
public class Main {

    public static void main(String[] args) {
        Integer[] nums = {-2,0,3,-5,2,1};

        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a,b) -> a+b);

        System.out.println(segmentTree);

        System.out.println("0-2: " + segmentTree.findSegment(0,2));
        System.out.println("0-5: " + segmentTree.findSegment(0,5));
    }
}
