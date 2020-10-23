package per.zzb.queue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();

        System.out.println("队列是否为空：" + arrayQueue.isEmpty());

        for (int i = 0 ; i < 20 ; i ++){
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
        }

        System.out.println("队首元素为：" + arrayQueue.getFront());
        System.out.println("出队："  + arrayQueue.dequeue());
        System.out.println(arrayQueue);

    }
}
