package btree;

import nodo.Nodo;
import tree.Tree;
import utilis.TreePrinter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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

    //
    //lo nuevo
    //
    @Override
    public void inorder() throws NoSuchElementException {
        if (isEmpty()){
            throw new NoSuchElementException("El arbol esta vacio");
        }
        inorderAyudin(root);
    }
    private void inorderAyudin(Nodo nodo){
        if (nodo==null)return;
        inorderAyudin(nodo.getIzq());
        IO.println(nodo.getElemento() + " ");
        inorderAyudin((nodo.getDer()));
    }

    @Override
    public void preorder() throws NoSuchElementException {
    if (isEmpty())
        throw new NoSuchElementException("El arbol esta vacio");
        preorderAyudin(root);
    }

    public void preorderAyudin(Nodo nodo){
        if (nodo == null)return;
        IO.println(nodo.getElemento()+" ");
        preorderAyudin(nodo.getIzq());
        preorderAyudin(nodo.getDer());
    }

    @Override
    public void postorder() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("El arbol esta vacio");
        postorderAyudin(root);
    }

    private void postorderAyudin(Nodo nodo){
        if ( nodo== null)return;
        postorderAyudin(nodo.getIzq());
        postorderAyudin(nodo.getDer());
        IO.println(nodo.getElemento()+" ");
    }
    //
    // lo nuevo
    //
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int Height() throws NoSuchElementException {
        if (isEmpty()){
            throw new NoSuchElementException("El arbol esta vacio");
        }
        Queue<Nodo<T>> cola = new LinkedList<>();
        cola.add(root);
        int altura = -1;
        while (!cola.isEmpty()){
            int tamañoNivel = cola.size();
            altura++;
            for (int i = 0; i < tamañoNivel; i++){
                Nodo<T> actual = cola.poll();
                if (actual.getIzq() != null) cola.add(actual.getIzq());
                if (actual.getDer() != null) cola.add(actual.getDer());
            }
        }
        return altura;
    }

    @Override
    public int Weight() throws NoSuchElementException {
        if (isEmpty()){
            throw new NoSuchElementException("El arbol esta vacio");
        }
        Queue<Nodo<T>> cola = new LinkedList<>();
        cola.add(root);
        int peso = 0;
        while (!cola.isEmpty()){
            Nodo<T> actual = cola.poll();
            peso++;
            if (actual.getIzq() != null) cola.add(actual.getIzq());
            if (actual.getDer() != null) cola.add(actual.getDer());
        }
        return peso;
    }

    @Override
    public int Degree() throws NoSuchElementException {
        if (isEmpty()){
            throw new NoSuchElementException("El arbol esta vacio");
        }
        Queue<Nodo<T>> cola = new LinkedList<>();
        cola.add(root);
        int grado = 0;
        while (!cola.isEmpty()){
            Nodo<T> actual = cola.poll();
            int hijos = 0;
            if (actual.getIzq() != null){
                hijos++;
                cola.add(actual.getIzq());
            }
            if (actual.getDer() != null){
                hijos++;
                cola.add(actual.getDer());
            }
            if (hijos > grado) grado = hijos;
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
