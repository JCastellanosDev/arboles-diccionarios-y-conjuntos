package conjuntos;

public interface Conjuntable<T> {
    boolean isEmpty();
    void clear();
    void add(T elemento);
    void remove(T elemento);
    int contains(T elemento);
    DLSet<T> union(DLSet<T> other);
    DLSet<T> inter(DLSet<T> other);
    DLSet<T> diff(DLSet<T> other);
    boolean subset(DLSet<T> other);
}
