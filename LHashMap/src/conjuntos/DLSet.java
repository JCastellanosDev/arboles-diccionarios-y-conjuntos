package conjuntos;


import dlinklist.DLinkList;

import java.util.Iterator;

public class DLSet<T> implements Conjuntable<T> ,Iterable<T> {
    private DLinkList<T> dLinkList;

    public DLSet() {
        dLinkList = new DLinkList<>();
    }

    @Override
    public boolean isEmpty() {
        return dLinkList.isEmpty();
    }

    @Override
    public void clear() {
        dLinkList = new DLinkList<>();
    }

    @Override
    public void add(T elemento) {
        if (elemento != null) {
            if (contains(elemento) ==-1){
                dLinkList.append(elemento);
            }
        }
    }

    @Override
    public void remove(T elemento) {
        if (elemento != null && contains(elemento) !=-1) {
            dLinkList.delete(elemento);
        }
    }

    @Override
    public int contains(T elemento) {
        if (elemento == null) return -1;

        int count = 0;
        for (T value : dLinkList) {
            if (value.equals(elemento))
                return count;
            count++;
        }

        return -1;
    }

    @Override
    public DLSet<T> union(DLSet<T> other) {
        DLSet<T> union = new DLSet<>();

        if (other.isEmpty()) {
            return null;
        }
        for (T value : this) {
            union.add(value);
        }
        for (T value: other){
            union.add(value);
        }

        return union;
    }

    @Override
    public DLSet<T> inter(DLSet<T> other) {
        return null;
    }

    @Override
    public DLSet<T> diff(DLSet<T> other) {
        return null;
    }

    @Override
    public boolean subset(DLSet<T> other) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new  Iterator<T>() {
            final Iterator<T> it = dLinkList.iterator();
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public T next() {
                return it.next();
            }
        };
    }
}
