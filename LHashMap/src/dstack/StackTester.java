import dlinklist.DLinkList;
import dstack.DStack;

void main() {
    DStack<Integer> stack = new DStack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    try {
        IO.println("El siguiente que va a salir es: " + stack.peek());
        IO.println("Salio el valor de : " + stack.pop());
        IO.println("El siguiente que va a salir es: " + stack.peek());
        IO.println("Salio el valor de : " + stack.pop());
        IO.println("El siguiente que va a salir es: " + stack.peek());
        IO.println("Salio el valor de : " + stack.pop());
        IO.println("El siguiente que va a salir es: " + stack.peek());
        IO.println("Salio el valor de : " + stack.pop());
        IO.println("El siguiente que va a salir es: " + stack.peek());

    } catch (EmptyStackException e) {
        IO.println("Salieron todos los elementos");
    }

    DStack<Integer> pila = new DStack<>();

    if (pila.isEmpty()) {
        IO.println("Pila recien creada: vacia");
    } else {
        IO.println("ERROR: deberia estar vacia");
    }

    pila.push(1);

    if (pila.isEmpty()) {
        IO.println("ERROR: deberia tener un elemento");
    } else {
        IO.println("Despues de push(1): no esta vacia");
    }

    pila.pop();

    if (pila.isEmpty()) {
        IO.println("Despues de pop(): vacia");
    } else {
        IO.println("ERROR: deberia estar vacia");
    }
}