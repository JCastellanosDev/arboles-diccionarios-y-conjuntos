import dqueue.DQueue;


void main() {
    DQueue <Integer> queue = new DQueue<>();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    try {
        IO.println("EL siguiente en salir: "+queue.front());
        IO.println("Salio el: "+queue.dequeue());

        IO.println("EL siguiente en salir: "+queue.front());
        IO.println("Salio el: "+queue.dequeue());

        IO.println("EL siguiente en salir: "+queue.front());
        IO.println("Salio el: "+queue.dequeue());

        IO.println("EL siguiente en salir: "+queue.front());
        IO.println("Salio el: "+queue.dequeue());

    }catch(NoSuchElementException nsee) {
        IO.println("El queue esta vacio");
    }

    DQueue<Integer> cola = new DQueue<>();

    if (cola.isEmpty()) {
        IO.println("Cola recien creada: vacia");
    } else {
        IO.println("ERROR: deberia estar vacia");
    }

    cola.enqueue(1);

    if (cola.isEmpty()) {
        IO.println("ERROR: deberia tener un elemento");
    } else {
        IO.println("Despues de enqueue(1): no esta vacia");
    }

    cola.dequeue();

    if (cola.isEmpty()) {
        IO.println("Despues de dequeue(): vacia");
    } else {
        IO.println("ERROR: deberia estar vacia");
    }
}