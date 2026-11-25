package btree;

import exceptions.EmptyException;
import exceptions.FullException;

public interface ITree <T>{
    boolean add(T element) throws FullException;
    boolean remove(T element) throws EmptyException;
    void inOrder()  throws EmptyException;
    void preOrder()  throws EmptyException;
    void postOrder() throws EmptyException;
    void depthSearch(T element) throws EmptyException;
    void ampSearch(T element) throws EmptyException, FullException;
    long height() throws EmptyException;
    boolean isEmpty()throws EmptyException;
}
