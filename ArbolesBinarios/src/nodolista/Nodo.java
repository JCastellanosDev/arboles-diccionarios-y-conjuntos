package nodolista;

public class Nodo<T> {
    private T elemento;
    private Nodo<T> izq,der;
    private int nivel;

    public Nodo(){
        this(null);
    }
    public Nodo(T elemento){
        this.elemento = elemento;
        this.izq = null;
        this.der = null;
        this.nivel = 0;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public Nodo<T> getIzq() {
        return izq;
    }

    public void setIzq(Nodo<T> izq) {
        this.izq = izq;
    }

    public Nodo<T> getDer() {
        return der;
    }

    public void setDer(Nodo<T> der) {
        this.der = der;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}