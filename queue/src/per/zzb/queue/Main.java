package per.zzb.queue;

public class Main {

    public static void main(String[] args) {
	// 普通队列
//        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
//
//        System.out.println("队列是否为空：" + arrayQueue.isEmpty());
//
////        for (int i = 0 ; i < 20 ; i ++){
////            arrayQueue.enqueue(i);
////            System.out.println(arrayQueue);
////        }
//
////        System.out.println("队首元素为：" + arrayQueue.getFront());
//        System.out.println("出队："  + arrayQueue.dequeue());
//        System.out.println(arrayQueue);

        //循环队列
        LoopQueue<Integer> loopQueue = new LoopQueue<>(4);
        System.out.println("循环队列是否为空: " + loopQueue.isEmpty());
        System.out.println("循环队列的长度: " + loopQueue.getSize());

        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
        }

        System.out.println("循环队列的对头元素: " + loopQueue.getFront());

        for (int i = 0; i < 11; i++) {
            loopQueue.dequeue();
            System.out.println(loopQueue);
        }
    }
}
