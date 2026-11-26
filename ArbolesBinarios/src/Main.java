import btree.BTree;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
    IO.println("BFS 5: " + (numeros.ampSearch(5) != null ? "encontrado" : "no encontrado"));
    IO.println("BFS 9: " + (numeros.ampSearch(9) != null ? "encontrado" : "no encontrado"));
    IO.println("=".repeat(40));
    numeros.delete(1);
    numeros.printTree();

}
