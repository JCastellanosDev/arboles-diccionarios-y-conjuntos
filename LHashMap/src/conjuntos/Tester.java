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
 //   b.remove(7);

    DLSet<Integer> c = dlset.union(b);

    for (Integer i : c) {
        IO.println(i);
    }
}