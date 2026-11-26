import conjuntos.DLSet;

void main() {
    DLSet<Integer> dlset = new DLSet<>();

    dlset.add(1);
    dlset.add(2);
    dlset.add(3);
    dlset.add(4);
    dlset.add(4);
    dlset.add(4);
    dlset.add(5);
    dlset.add(5);

    DLSet<Integer> b = new DLSet<>();
    b.add(5);
    b.add(6);
    b.add(7);


    IO.println("Esta vacio dlset? " + dlset.isEmpty());

    DLSet<Integer> c = dlset.union(b);
    IO.println("Union:");
    for (Integer i : c) {
        IO.println(i);
    }

    IO.println("=".repeat(40));
    DLSet<Integer> inter = dlset.inter(b);
    IO.println("Interseccion:");
    for (Integer i : inter) {
        IO.println(i);
    }

    DLSet<Integer> diff = dlset.diff(b);
    IO.println("Diferencia:");
    for (Integer i : diff) {
        IO.println(i);
    }

    IO.println("=".repeat(40));
    DLSet<Integer> d = new DLSet<>();
    d.add(2);
    d.add(3);
    IO.println("d subconjunto de dlset? " + d.subset(dlset));
    IO.println("b subconjunto de dlset? " + b.subset(dlset));

    IO.println("=".repeat(40));
    DLSet<Integer> conjuntoVacio = new DLSet<>();
    DLSet<Integer> unionVacia = dlset.union(conjuntoVacio);
    IO.println("Union con conjunto vacio es null? " + (unionVacia == null));
    IO.println("Union con conjunto vacio:");
    for (Integer i : unionVacia) {
        IO.println(i);
    }

    IO.println("=".repeat(40));
    IO.println("contains(3): " + dlset.contains(3));
    IO.println("contains(9): " + dlset.contains(9));
    dlset.remove(3);
    IO.println("Despues de remove(3), contains(3): " + dlset.contains(3));
    dlset.clear();
    IO.println("Despues de clear, esta vacio? " + dlset.isEmpty());

}