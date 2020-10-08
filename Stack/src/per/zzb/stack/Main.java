package per.zzb.stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("This is my stack");

        MyStack<Integer> stack = new MyStack<>(7);

        for (int i = 0 ; i < 7 ; i ++){
            stack.push(i);
        }

        System.out.println(stack);

        stack.push(7);
        System.out.println(stack);

        stack.pop();stack.pop();stack.pop();stack.pop();stack.pop();
        System.out.println(stack);

        System.out.println(stack.peek());
    }
}
