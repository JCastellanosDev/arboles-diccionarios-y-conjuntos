package lhashmap;


import dlinklist.DLinkList;
import entrada.Entrada;
import mapa.Mapa;

import java.util.Iterator;

public class LHashMap<K,V> implements Mapa<K,V> {
    private DLinkList<Entrada<K,V>> dLinkList;
    private int size;

    public LHashMap(){
        this.dLinkList = new DLinkList<>();
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return dLinkList.isEmpty();
    }

    @Override
    public V put(K key, V value) {
      for(Entrada<K,V> entrada : dLinkList){
            if(entrada.getKey().equals(key)){
                V oldValue = entrada.getValue();
                entrada.setValue(value);
                return  oldValue;
            }
        }
        size++;
        dLinkList.append(new Entrada<>(key,value));
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public Iterable<V> values() {
        return null;
    }

    @Override
    public Iterable<K> keys() {
              return new Iterable<K>(){
                  @Override
                  public Iterator<K> iterator() {
                      return new Iterator<K>(){

                           final Iterator<Entrada<K,V>> iterator = dLinkList.iterator();
                          @Override
                          public boolean hasNext() {
                              return iterator.hasNext();
                          }

                          @Override
                          public K next() {
                              return iterator.next().getKey();
                          }
                      };
                  }
              } ;
    }

    @Override
    public Iterable<Entrada<K, V>> entries() {
        return dLinkList;
    }
}
