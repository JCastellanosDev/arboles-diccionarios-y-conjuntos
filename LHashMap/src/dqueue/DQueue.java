package dqueue;

import dlinklist.DLinkList;
import queue.Queue;
import java.util.NoSuchElementException;

public class DQueue<T> implements Queue<T> {
    private DLinkList<T> dLinkList;

    public DQueue() {
        this.dLinkList = new DLinkList<>();
    }

    @Override
    public void enqueue(T element) {
        if (element == null) {
            throw new NullPointerException();
        }else {
            dLinkList.reappend(element);
        }
    }

    @Override
    public T dequeue() throws NoSuchElementException {
        T element =null;
        try {
            element = front();
            dLinkList.deleteLast();
        }catch (NoSuchElementException e) {
            IO.println(e.getMessage());
        }
        return element;
    }

    @Override
    public T front() throws NoSuchElementException {
        if (!isEmpty()) {
            return dLinkList.getLast();
        }else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean isEmpty() {
        T element = dLinkList.getLast();
        return element == null;
    }
}
