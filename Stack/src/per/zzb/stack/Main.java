package per.zzb.stack;

public class Main {

    //测试不同栈的入栈+出栈时间
    public double AddAndPop(Stack stack, int count){

        long startTime = System.nanoTime();

        for (int i = 0; i < count; i++) {
            stack.push(Math.random());
        }

        for (int i = 0; i < count; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;

    }

    public static void main(String[] args) {
	// write your code here
        System.out.println("This is my stack");

//        MyStack<Integer> stack = new MyStack<>(7);

//
//        for (int i = 0 ; i < 7 ; i ++){
//            stack.push(i);
//        }
//
//        System.out.println(stack);
//
//        stack.push(7);
//        System.out.println(stack);
//
//        stack.pop();stack.pop();stack.pop();stack.pop();stack.pop();
//        System.out.println(stack);
//
//        System.out.println(stack.peek());

//         LinkedStack<Integer> linkedStack = new LinkedStack<>();
//        for (int i = 0; i < 7; i++) {
//            linkedStack.push(i);
//        }
//
//        System.out.println(linkedStack);
//
//        linkedStack.push(7);
//        System.out.println(linkedStack);
//
//        linkedStack.pop();
//        System.out.println(linkedStack);
//
//        System.out.println(linkedStack.peek());

        Main main = new Main();
        int count = 10000;

        System.out.println("数组栈：" + main.AddAndPop(new MyStack(),count));
        System.out.println("链表栈：" + main.AddAndPop(new LinkedStack(),count));

    }
}
