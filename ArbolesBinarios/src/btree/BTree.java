package btree;

import nodolista.Nodo;
import tree.Tree;
import utilis.TreePrinter;
import dstack.DStack;

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
    public void inorder() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("El arbol esta vacio");
        }
        inorder(root);
    }

    private void inorder(Nodo<T> nodo) {
        if (nodo != null) {
            inorder(nodo.getIzq());
            IO.println(nodo.getElemento());
            inorder(nodo.getDer());
        }
    }

    @Override
    public void preorder() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("El arbol esta vaico");
        }

        DStack<Nodo<T>> pila = new DStack<>();
        pila.push(root);

        while (!pila.isEmpty()) {
            Nodo<T> actual = pila.pop();
            IO.println(actual.getElemento());

            if (actual.getDer() != null) {
                pila.push(actual.getDer());
            }
            if (actual.getIzq() != null) {
                pila.push(actual.getIzq());
            }
        }
    }

    @Override
    public void postorder() throws NoSuchElementException {
        if (isEmpty()) {
            throw  new NoSuchElementException("El arbol esta vacio");
        }

        postorder(root);
    }

    private void postorder(Nodo<T> nodo) {
        if (nodo != null) {
            postorder(nodo.getIzq());
            postorder(nodo.getDer());
            IO.println(nodo.getElemento());
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int Height() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("El arbol esta vacio");
        }

        return Height(root);
    }

    private int Height(Nodo<T> nodo) {
        if (nodo == null) {
            return -1;
        }
        int izq = Height(nodo.getIzq());
        int der = Height(nodo.getDer());
        if (izq > der) {
            return izq + 1;
        }

        return der + 1;
    }

    @Override
    public int Weight() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("El arbol esta vacio");
        }

        return Weight(root);
    }

    private int Weight(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;
        }

        return 1 + Weight(nodo.getIzq()) + Weight(nodo.getDer());
    }

    @Override
    public int Degree() throws NoSuchElementException {
        if( isEmpty()) {
            throw new NoSuchElementException("El arbol esta vacio");
        }

        return Degree(root);
    }

    private int Degree(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        int grado = 0;
        if (nodo.getIzq() != null) {
            grado = grado + 1;
        }
        if (nodo.getDer() != null) {
            grado = grado + 1;
        }

        int izq = Degree(nodo.getIzq());
        int der = Degree(nodo.getDer());

        if (izq > grado) {
            grado = izq;
        }
        if (der > grado) {
            grado = der;
        }

        return grado;
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
