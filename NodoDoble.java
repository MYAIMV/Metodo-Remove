public class NodoDoble {
    int dato;
    NodoDoble siguiente;
    NodoDoble anterior;
    public NodoDoble(int dato) {
        this.dato = dato;
    }
}
class ListaEnlazadaDoble {
    NodoDoble primero;
    NodoDoble ultimo;
    public void insertar(int valor) {
        NodoDoble nuevoNodo = new NodoDoble(valor);
        if (primero == null) {
            primero = ultimo = nuevoNodo;
        } else {
            ultimo.siguiente = nuevoNodo;
            nuevoNodo.anterior = ultimo;
            ultimo = nuevoNodo;
        }
    }
    public void imprimirLista() {
        if (primero == null) {
            System.out.println("La lista está vacía, no hay nada que mostrar.");
            return;
        }
        NodoDoble aux = primero;
        System.out.print("Contenido actual: ");
        while (aux != null) {
            System.out.print(aux.dato + " ");
            aux = aux.siguiente;
        }
        System.out.println();
    }
    public void borrarElemento(int valor) {
        if (primero == null) {
            System.out.println("No se puede eliminar, la lista está vacía.");
            return;
        }
        NodoDoble actual = primero;
        while (actual != null && actual.dato != valor) {
            actual = actual.siguiente;
        }
        if (actual == null) {
            System.out.println("El valor " + valor + " no se encontró en la lista.");
            return;
        }
        if (actual == primero) {
            primero = primero.siguiente;
            if (primero != null) {
                primero.anterior = null;
            } else {
                ultimo = null;
            }
        }
        else if (actual == ultimo) {
            ultimo = ultimo.anterior;
            ultimo.siguiente = null;
        }
        else {
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }
        System.out.println("Elemento con valor " + valor + " eliminado correctamente.");
    }
}
class DemoListaDoble {
    public static void main(String[] args) {
        ListaEnlazadaDoble lista = new ListaEnlazadaDoble();
        lista.insertar(5);
        lista.insertar(15);
        lista.insertar(25);
        lista.insertar(35);
        System.out.println("Estado inicial de la lista:");
        lista.imprimirLista();
        lista.borrarElemento(15);
        lista.borrarElemento(35);
        System.out.println("Estado final de la lista:");
        lista.imprimirLista();
    }
}
