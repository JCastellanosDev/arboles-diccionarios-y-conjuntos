package dlinklist;

import lista.Lista;
import nodo.Nodo;

import java.util.Iterator;

public class DLinkList<T> implements Lista<T>,Iterable<T>  {

    private Nodo<T> head,tail;

    public DLinkList() {
        this(null);
    }
    public DLinkList(T elemento) {
        this.head = new Nodo<>();
        this.tail = new Nodo<>();
        if (elemento != null) {
            Nodo<T> nuevo = new Nodo<>(elemento);
            this.head.setSiguiente(nuevo);
            this.tail.setAnterior(nuevo);
        }
    }

    @Override
    public void append(T elemento) {
        if (elemento != null) {
            Nodo<T> nuevo = new Nodo<>(elemento);
            append(nuevo);
        }else {
            IO.println("Error: elemento vacio");
        }
    }

    @Override
    public void append(Nodo<T> elemento) {
        if (elemento != null) {
            elemento.setAnterior(null);
            elemento.setSiguiente(null);
            if(head.getSiguiente() == null) {
                tail.setAnterior(elemento);
                head.setSiguiente(elemento);
            }else{
                Nodo<T> back = tail.getAnterior();
                tail.setAnterior(elemento);
                elemento.setAnterior(back);
                back.setSiguiente(elemento);
            }
        }else {
            IO.println("Error: elemento vacio");
        }
    }

    @Override
    public void reappend(T elemento) {
        if (elemento != null) {
            Nodo<T> nuevo = new Nodo<>(elemento);
            reappend(nuevo);
        }else {
            IO.println("Error: elemento vacio");
        }
    }

    @Override
    public void reappend(Nodo<T> elemento) {
        if (elemento != null) {
            elemento.setAnterior(null);
            elemento.setSiguiente(null);
            if(head.getSiguiente() == null) {
                tail.setAnterior(elemento);
                head.setSiguiente(elemento);
            }else{
                Nodo<T> next = head.getSiguiente();
                head.setSiguiente(elemento);
                elemento.setSiguiente(next);
                next.setAnterior(elemento);
            }
        }else {
            IO.println("Error: elemento vacio");
        }
    }

    @Override
    public void delete(T elemento) {
        if (elemento != null) {
            Nodo<T> encontrado = search(elemento);

            if (encontrado != null) {
                delete(encontrado);
            } else {
                IO.println("ERROR: El elemento no existe.");
            }
        } else {
            IO.println("ERROR: No puede borrar un elemento vacio.");
        }

    }

    @Override
    public void delete(Nodo<T> elemento) {
        if (elemento == null) {
            IO.println("ERROR: No puede borrar un nodo vacio.");
            return;
        }

        Nodo<T> actual = search(elemento);
        if (actual == null) {
            IO.println("ERROR: El elemento no existe");
            return;
        }

        Nodo<T> prev = actual.getAnterior();
        Nodo<T> next = actual.getSiguiente();

        if (prev == null) {
            head.setSiguiente(next);
        } else {
            prev.setSiguiente(next);
        }

        if (next == null) {
            tail.setAnterior(prev);
        } else {
            next.setAnterior(prev);
        }

        actual.setSiguiente(null);
        actual.setAnterior(null);
    }

    @Override
    public void print() {
        if(this.tail.getAnterior() == null) {
            IO.println("ERROR: La lista esta vacia.");
        }else {
            print(this.tail.getAnterior());
        }
    }
    private void print(Nodo<T> anterior) {
        if(anterior !=null) {
            IO.println(anterior.getElemento());
            print(anterior.getAnterior());
        }
    }

    @Override
    public Nodo<T> search(T elemento) {
        Nodo<T> find = null;
        if(elemento != null) {
            if(this.head.getSiguiente() == null) {
                return null;
            }else {
                Nodo tmp = new Nodo<>(elemento);
                find = search(tmp);
            }
        }
        return find;
    }

    @Override
    public Nodo<T> search(Nodo<T> elemento) {
        Nodo<T> find = null;
        if (elemento != null) {
            find= search(head.getSiguiente(),elemento.getElemento());
        }
        return find;
    }

    private Nodo<T> search(Nodo<T> siguiente, T elemento) {
        if(siguiente != null) {
            if(siguiente.getElemento().equals(elemento)) {
                return siguiente;
            }
            return search(siguiente.getSiguiente(),elemento);
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Nodo<T> tmp = head.getSiguiente(), pos;
            @Override
            public boolean hasNext() {
                if (tmp == null) {
                    return false;
                }
                pos = tmp;
                tmp = tmp.getSiguiente();
                return true;
            }
            @Override
            public T next() {
                return pos.getElemento();
            }
        };
    }
    public void deleteFirst() {
        if (head.getSiguiente() == null) {
            return ;
        }else {
            Nodo<T> tmp = head.getSiguiente();
            head.setSiguiente(tmp.getSiguiente());
            if(tmp.getSiguiente() != null) {
                tmp.getSiguiente().setAnterior(null);
            } else {
                tail.setAnterior(null);
            }
        }
    }
    public T getFirst() {
        if (head.getSiguiente() == null) {
            return null;
        }else {
            return head.getSiguiente().getElemento();
        }
    }

    public void deleteLast() {
        if (tail.getAnterior() == null) {
            return ;
        }else {
            Nodo<T> tmp = tail.getAnterior();
            tail.setAnterior(tmp.getAnterior());
            if(tmp.getAnterior() != null) {
                tmp.getAnterior().setSiguiente(null);
            } else {
                head.setSiguiente(null);
            }
        }
    }

    public T getLast() {
        if (tail.getAnterior() == null) {
            return null;
        }else {
            return tail.getAnterior().getElemento();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.head.getSiguiente() == null;
    }

    public Nodo<T> getHead() {
        return head;
    }
}
