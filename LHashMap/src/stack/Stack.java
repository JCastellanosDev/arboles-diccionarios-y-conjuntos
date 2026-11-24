package stack;

import java.util.EmptyStackException;

public interface Stack<T> {
    void  push(T element);
    T pop() throws EmptyStackException;
    T peek()throws EmptyStackException;
    boolean isEmpty();
}
