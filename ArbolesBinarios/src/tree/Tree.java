package tree;

import nodo.Nodo;
import java.util.NoSuchElementException;

public interface Tree<T> {
    void insert(T value);
    void insert(Nodo<T> value);

    Nodo<T> delete(T value);

    Nodo<T> delete(Nodo<T> value);

    void inorder()  throws NoSuchElementException;
    void preorder() throws NoSuchElementException;
    void postorder()throws NoSuchElementException;

    boolean isEmpty();

    int Height() throws NoSuchElementException;
    int Weight() throws NoSuchElementException;
    int Degree() throws NoSuchElementException;

}
