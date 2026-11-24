package mapa;

import entrada.Entrada;

public interface Mapa<K,V> {
    int size();
    boolean isEmpty();
    V put(K key, V value);
    V remove(K key);
    V get(K key);
    Iterable<V> values();
    Iterable<K> keys();
    Iterable<Entrada<K,V>> entries();

}
