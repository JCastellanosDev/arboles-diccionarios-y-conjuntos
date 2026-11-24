import dlinklist.DLinkList;
import nodo.Nodo;

void main() {
    DLinkList<String> names = new DLinkList<>();

    // autos
    names.append("tsuru");
    names.append("yaris");
    names.append("city");
    names.append("chevy");
    names.append("civic");

    names.reappend("vocho");

    /// PROBANDO CON ITERADOR (adelante -> atras)
    for (String s : names) {
        IO.println(s);
    }

    IO.println();

    /// PROBANDO PRINT() (atras -> adelante)
    names.print();

    IO.println();

    /// PROBANDO GETFIRST() Y GETLAST()
    IO.println("Primer nodo: " + names.getFirst());
    IO.println("Ultimo nodo: " + names.getLast());

    IO.println();

    /// BUSCADOR
    IO.println("Buscando city...");

    Nodo<String> encontrado = names.search("city");

    if (encontrado != null) {
        IO.println("Elemento encontrado: " + encontrado.getElemento());
    } else {
        IO.println("Elemento no encontrado");
    }

    IO.println();
    IO.println("Buscando batmovil...");

    Nodo<String> encontrado2 = names.search("batmovil");

    if (encontrado2 != null) {
        IO.println("Elemento encontrado: " + encontrado2.getElemento());
    } else {
        IO.println("Elemento no encontrado");
    }

    IO.println();
    IO.println("Buscando con un Nodo nuevo (chevy)...");

    Nodo<String> encontrado3 = names.search(new Nodo<>("chevy"));

    if (encontrado3 != null) {
        IO.println("Elemento encontrado: " + encontrado3.getElemento());
    } else {
        IO.println("Elemento no encontrado");
    }

    IO.println();

    /// PROBANDO DELETE EN MEDIO
    IO.println("Eliminar city (medio)");
    names.delete("city");
    names.print();

    IO.println();

    /// PROBANDO DELETE DEL PRIMERO
    IO.println("Eliminar el primero: " + names.getFirst());
    names.delete(names.getFirst());
    names.print();

    IO.println();

    /// PROBANDO DELETE DEL ULTIMO
    IO.println("Eliminar el ultimo: " + names.getLast());
    names.delete(names.getLast());
    names.print();

    IO.println();

    /// PROBANDO DELETE CON NODO
    IO.println("Eliminar Nodo yaris");
    names.delete(new Nodo<>("yaris"));
    names.print();

    IO.println();

    /// PROBANDO ERRORES
    IO.println("Eliminar elemento que no existe");
    names.delete("noexiste");

    IO.println("Eliminar elemento vacio");
    names.delete((String) null);

    IO.println("Eliminar nodo vacio");
    names.delete((Nodo<String>) null);

    IO.println("Agregar elemento vacio");
    names.append((String) null);

    IO.println();

    /// PROBANDO DELETEFIRST()
    IO.println("deleteFirst()");
    names.deleteFirst();
    names.print();

    IO.println();

    /// PROBANDO DELETELAST() CON UN SOLO ELEMENTO
    IO.println("deleteLast() con un solo elemento");
    names.deleteLast();
    names.print();
    IO.println("Primer nodo: " + names.getFirst());
    IO.println("Ultimo nodo: " + names.getLast());

    IO.println();

    /// PROBANDO BORRAR EN LISTA VACIA
    IO.println("deleteFirst() y deleteLast() en lista vacia");
    names.deleteFirst();
    names.deleteLast();
    IO.println("Sin errores");

    IO.println();

    /// REUSANDO LA LISTA DESPUES DE VACIARLA
    IO.println("Agregando de nuevo...");
    names.append("corsa");
    names.reappend("beetle");

    for (String s : names) {
        IO.println(s);
    }

    IO.println();
    names.print();

    /// PROBANDO ISEMPTY
    DLinkList<String> autos = new DLinkList<>();
    autos.append("tsuru");
    autos.deleteFirst();

    if (autos.isEmpty()) {
        IO.println("deleteFirst con un solo elemento: vacia");
    } else {
        IO.println("ERROR: deberia estar vacia");
    }

    autos.append("yaris");
    autos.deleteLast();

    if (autos.isEmpty()) {
        IO.println("deleteLast con un solo elemento: vacia");
    } else {
        IO.println("ERROR: deberia estar vacia");
    }

    /// CASOS CON VALOR ESPERADO: append(Nodo), reappend(Nodo), delete con duplicados
    String texto;
    IO.println();
    DLinkList<String> dn = new DLinkList<>();
    dn.append("a");
    dn.append(new Nodo<>("b"));
    texto = "";
    for (String x : dn) {
        texto = texto + x + " ";
    }
    if ((texto).compareTo("a b ") == 0) {
        IO.println("OK: DLinkList append(Nodo)");
    } else {
        IO.println("ERROR: DLinkList append(Nodo) -> esperado [a b ] obtenido [" + (texto) + "]");
    }

    DLinkList<String> ajena = new DLinkList<>();
    ajena.append("x");
    ajena.append("y");
    dn.append(ajena.search("x"));
    texto = "";
    for (String x : dn) {
        texto = texto + x + " ";
    }
    if ((texto).compareTo("a b x ") == 0) {
        IO.println("OK: DLinkList append(Nodo) con nodo de otra lista no arrastra cola");
    } else {
        IO.println("ERROR: DLinkList append(Nodo) con nodo de otra lista no arrastra cola -> esperado [a b x ] obtenido [" + (texto) + "]");
    }
    if (("" + dn.getLast()).compareTo("x") == 0) {
        IO.println("OK: DLinkList getLast tras append(Nodo)");
    } else {
        IO.println("ERROR: DLinkList getLast tras append(Nodo) -> esperado [x] obtenido [" + ("" + dn.getLast()) + "]");
    }

    dn.reappend(new Nodo<>("z"));
    texto = "";
    for (String x : dn) {
        texto = texto + x + " ";
    }
    if ((texto).compareTo("z a b x ") == 0) {
        IO.println("OK: DLinkList reappend(Nodo)");
    } else {
        IO.println("ERROR: DLinkList reappend(Nodo) -> esperado [z a b x ] obtenido [" + (texto) + "]");
    }
    if (("" + dn.getFirst()).compareTo("z") == 0) {
        IO.println("OK: DLinkList getFirst tras reappend(Nodo)");
    } else {
        IO.println("ERROR: DLinkList getFirst tras reappend(Nodo) -> esperado [z] obtenido [" + ("" + dn.getFirst()) + "]");
    }

    DLinkList<String> ajena2 = new DLinkList<>();
    ajena2.append("p");
    ajena2.append("q");
    DLinkList<String> destino = new DLinkList<>();
    destino.append("m");
    destino.reappend(ajena2.search("q"));
    destino.delete(ajena2.search("q"));
    texto = "";
    for (String x : destino) {
        texto = texto + x + " ";
    }
    if ((texto).compareTo("m ") == 0) {
        IO.println("OK: DLinkList delete(Nodo) de un nodo reinsertado");
    } else {
        IO.println("ERROR: DLinkList delete(Nodo) de un nodo reinsertado -> esperado [m ] obtenido [" + (texto) + "]");
    }

    DLinkList<String> dup = new DLinkList<>();
    dup.append("k");
    dup.append("v");
    dup.append("k");
    dup.append("k");
    dup.delete("k");
    texto = "";
    for (String x : dup) {
        texto = texto + x + " ";
    }
    if ((texto).compareTo("v k k ") == 0) {
        IO.println("OK: DLinkList delete(T) duplicados: borra solo el primero");
    } else {
        IO.println("ERROR: DLinkList delete(T) duplicados: borra solo el primero -> esperado [v k k ] obtenido [" + (texto) + "]");
    }
    dup.delete(new Nodo<>("k"));
    texto = "";
    for (String x : dup) {
        texto = texto + x + " ";
    }
    if ((texto).compareTo("v k ") == 0) {
        IO.println("OK: DLinkList delete(Nodo) duplicados: borra solo uno");
    } else {
        IO.println("ERROR: DLinkList delete(Nodo) duplicados: borra solo uno -> esperado [v k ] obtenido [" + (texto) + "]");
    }
    if (("" + dup.getLast()).compareTo("k") == 0) {
        IO.println("OK: DLinkList getLast tras borrar duplicados");
    } else {
        IO.println("ERROR: DLinkList getLast tras borrar duplicados -> esperado [k] obtenido [" + ("" + dup.getLast()) + "]");
    }
    dup.delete("k");
    dup.delete("k");
    texto = "";
    for (String x : dup) {
        texto = texto + x + " ";
    }
    if ((texto).compareTo("v ") == 0) {
        IO.println("OK: DLinkList delete de un valor que ya no esta no cambia la lista");
    } else {
        IO.println("ERROR: DLinkList delete de un valor que ya no esta no cambia la lista -> esperado [v ] obtenido [" + (texto) + "]");
    }
}
