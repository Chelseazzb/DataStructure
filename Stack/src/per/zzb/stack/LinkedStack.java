package per.zzb.stack;

/**
 * 链表栈
 */

public class LinkedStack<E> implements Stack<E> {

    //底层的数据结构是链表
    private LinkedList<E> linkedStack;

    public LinkedStack(){
        linkedStack = new LinkedList<>();
    }


    @Override
    public int getSize() {
        return linkedStack.getSize();
    }

    @Override
    public E pop() {
        return linkedStack.deleteFirst();
    }

    @Override
    public void push(E e) {
        linkedStack.addFirst(e);
    }

    @Override
    public boolean isEmpty() {
        return linkedStack.isEmpty();
    }

    @Override
    public E peek() {
        return linkedStack.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Stack size is %d  \n",linkedStack.getSize()));
        res.append("top [");
        for (int i = 0 ; i < linkedStack.getSize() ; i ++){
            res.append(linkedStack.get(i));
            if (i != linkedStack.getSize()-1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
