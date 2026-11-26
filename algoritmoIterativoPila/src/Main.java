import btree.BTree;
import nodo.Nodo;

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

    IO.println("=".repeat(40));
    IO.println("Busqueda en amplitud con cola:");
    IO.println("BFS 5: " + (numeros.ampSearch(5) != null ? "encontrado" : "no encontrado"));
    IO.println("BFS 9: " + (numeros.ampSearch(9) != null ? "encontrado" : "no encontrado"));

    IO.println("=".repeat(40));
    IO.println("Inorden:");
    numeros.inorder();
    IO.println("Postorden:");
    numeros.postorder();

    IO.println("=".repeat(40));
    IO.println("numeros esta vacio? " + numeros.isEmpty());
    IO.println("vacio esta vacio? " + vacio.isEmpty());
    IO.println("Altura: " + numeros.Height());
    IO.println("Peso: " + numeros.Weight());
    IO.println("Grado: " + numeros.Degree());

    IO.println("=".repeat(40));
    IO.println("insert(Nodo) con 7:");
    numeros.insert(new Nodo<>(7));
    numeros.printTree();
    IO.println("delete(Nodo) con 6:");
    numeros.delete(new Nodo<>(6));
    numeros.printTree();
}