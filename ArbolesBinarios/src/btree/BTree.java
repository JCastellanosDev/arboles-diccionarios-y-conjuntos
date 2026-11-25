package btree;

import dqueue.DQueue;
import nodo.Nodo;
import tree.Tree;
import utilis.TreePrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BTree<T extends Comparable<T>> implements Tree<T> {
    private Nodo<T> root;

    public BTree() {
        this.root = null;
    }


    @Override
    public void insert(T value) {
        if (value == null) {
            throw new IllegalArgumentException("No se puede insertar un null");
        }
        Nodo<T>nuevo = new Nodo<>(value);
        insert(nuevo);

    }

    @Override
    public void insert(Nodo<T> value) {
        if (value == null) {
            throw new IllegalArgumentException("No se puede insertar un null");
        }
        if (root == null) {
            root = value;
        }else {
            insert(root,value);
        }
    }
    private void insert(Nodo<T> nodo, Nodo<T> value) {
       if (nodo.getElemento().compareTo(value.getElemento()) <= 0) {
           if (nodo.getDer() == null) {
               nodo.setDer(value);
           }else {
               insert(nodo.getDer(),value);
           }
       }else {
           if (nodo.getIzq() == null) {
               nodo.setIzq(value);
           }else {
               insert(nodo.getIzq(),value);
           }
       }
    }

    @Override
    public Nodo<T> delete(T value) {
        if (isEmpty())
            throw new NoSuchElementException("El arbol esta vacio");
        if (value == null) {
            throw new IllegalArgumentException("No se puede eliminar un null");
        }
        this.root = delete(this.root,value);
        return this.root;
    }

    @Override
    public Nodo<T> delete(Nodo<T> value) {
        if (isEmpty())
            throw new NoSuchElementException("El arbol esta vacio");
        if (value == null) {
            throw new IllegalArgumentException("No se puede eliminar un null");
        }
        this.root = delete(this.root,value.getElemento());
        return root;
    }

    private Nodo<T> delete(Nodo<T> root, T value) {
        Nodo<T> tmp;
        if (root == null) {
            return null;
        }
        if (root.getElemento().compareTo(value) < 0) {
            tmp = delete(root.getDer(),value);
            root.setDer(tmp);
        }else if (root.getElemento().compareTo(value) > 0) {
            delete(root.getIzq(),value);
            root.setIzq(delete(root.getIzq(),value));
        }else {
            if (root.getIzq() == null) {
                return root.getDer();
            }
            if (root.getDer() == null) {
                return root.getIzq();
            }
            //tiene los dos hojas
            Nodo<T> small = minmax(root);
            root.setElemento(small.getElemento());
            tmp = delete(root.getDer(),small.getElemento());
            root.setDer(tmp);
        }
        return root;
    }

    private Nodo<T> minmax(Nodo<T> current) {
        current = current.getDer();

        while (current != null && current.getIzq() != null) {
            current = current.getIzq();
        }

        return current;
    }

    @Override
    public void inorder(Nodo nodo) throws NoSuchElementException {
        if (nodo == null){
            throw new NoSuchElementException("El arbol esta vacio");
            inorderAyudin(nodo);
        }

    }
    private void inorderAyudin(Nodo nodo){
        if (nodo==null)return;
        inorderAyudin(nodo.getIzq());
        IO.println(nodo.dato+ " ");
        inorderAyudin((nodo.getDer()));
    }

    @Override
    public void preorder() throws NoSuchElementException {

    }

    @Override
    public void postorder() throws NoSuchElementException {

    }

    /**
     * Busqueda en amplitud (BFS): recorre el arbol nivel por nivel usando una cola (FIFO).
     * Devuelve el nodo que contiene el valor, o null si no existe.
     */
    @Override
    public Nodo<T> ampSearch(T value) throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("El arbol esta vacio");
        }
        if (value == null) {
            throw new IllegalArgumentException("No se puede buscar un null");
        }
        DQueue<Nodo<T>> cola = new DQueue<>();          // 1. cola vacia
        cola.enqueue(root);                                   // 2. insertar la raiz
        while (!cola.isEmpty()) {                             // 3. mientras la cola no este vacia
            Nodo<T> actual = cola.dequeue();             //    extraer el frente
            if (actual.getElemento().compareTo(value) == 0) { //    procesar el nodo
                return actual;
            }
            if (actual.getIzq() != null) {                    //    encolar hijos (izq -> der)
                cola.enqueue(actual.getIzq());
            }
            if (actual.getDer() != null) {
                cola.enqueue(actual.getDer());
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int Height() throws NoSuchElementException {
        return 0;
    }

    @Override
    public int Weight() throws NoSuchElementException {
        return 0;
    }

    @Override
    public int Degree() throws NoSuchElementException {
        return 0;
    }


    public void printTree(){
           if( isEmpty()) {
               throw new NoSuchElementException("El arbol esta vacio");
           }
            TreePrinter<T> printer = new TreePrinter();
            List<String> idnt = new ArrayList();
            printer.printFullTree(root, "-", idnt, true);

    }
}
