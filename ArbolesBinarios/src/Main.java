import btree.BTree;

import java.util.NoSuchElementException;

void main() {
    BTree<Integer> numeros = new BTree<>();

    numeros.insert(4);
    numeros.insert(3);
    numeros.insert(6);
    numeros.insert(5);
    numeros.insert(8);
    numeros.insert(0);
    numeros.insert(1);

    numeros.printTree();
    IO.println("=".repeat(40));
    IO.println("Preorden con pila:");
    numeros.preorder();

    IO.println("=".repeat(40));
    numeros.delete(1);
    numeros.printTree();

    IO.println("=".repeat(40));
    BTree<Integer> vacio = new BTree<>();
    try {
        vacio.preorder();
    } catch (NoSuchElementException e) {
        IO.println(e.getMessage());
    }
}