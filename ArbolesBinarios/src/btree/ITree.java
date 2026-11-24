package btree;

import exceptions.EmptyException;
import exceptions.FullException;



public interface ITree <T>{
    boolean add(T element) throws FullException;
    boolean remove(T element) throws EmptyException;
    void inOrder()  throws EmptyException;
    void preOrder()  throws EmptyException;
}
