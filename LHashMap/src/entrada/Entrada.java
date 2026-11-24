package entrada;

public class Entrada<K,V> implements Entry<K,V> {
    private K key;
    private V value;

    public Entrada(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "<" +
                     key +
                ","+ value +
                '>';
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
