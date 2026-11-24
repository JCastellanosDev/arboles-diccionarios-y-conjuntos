package dstack;

import dlinklist.DLinkList;
import stack.Stack;

import java.util.EmptyStackException;

public class DStack<T> implements Stack<T> {
    private DLinkList<T> dLinkList;

    public DStack() {
        dLinkList = new DLinkList<>();
    }

    @Override
    public void push(T element) {
        if (element == null) {
            throw new NullPointerException();
        }else {
            dLinkList.reappend(element);
        }
    }

    @Override
    public T pop() throws EmptyStackException {
       T element =null;
        try {
           element = peek();
           dLinkList.deleteFirst();
       }catch (EmptyStackException e) {
           IO.println(e.getMessage());
       }
       return element;
    }
    @Override
    public T peek() throws EmptyStackException {
       if (!isEmpty()) {
           return dLinkList.getFirst();
       }else {
           throw new EmptyStackException();
       }
    }

    @Override
    public boolean isEmpty() {
        T element = dLinkList.getFirst();
        return element == null;
    }
}
