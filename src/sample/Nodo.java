package sample;

public class Nodo {

    private Nodo nodoIzquierdo = null, nodoDerecho = null; // Instancias de la clase Nodo
    private int valor;  // declaración de variable valor de tipo entero

    public Nodo(int valor) {    // Constructor con parámetro tipo entero
        this.valor = valor;
    }

    public Nodo getNodoIzquierdo() {    // Método para devolver el valor de la instancia de clase nodoIzquierdo
        return nodoIzquierdo;
    }

    public void setNodoIzquierdo(Nodo nodoIzquierdo) {  // Método para asignar un nuevo valor a la instancia de clase nodoIzquierdo
        this.nodoIzquierdo = nodoIzquierdo;
    }

    public Nodo getNodoDerecho() {  // Método para devolver el valor de la instancia de clase nodoIzquierdo
        return nodoDerecho;
    }

    public void setNodoDerecho(Nodo nodoDerecho) {  // Método para asignar un nuevo valor a la instancia de clase nodoIzquierdo
        this.nodoDerecho = nodoDerecho;
    }

    public int getValor() { // Método para devolver el valor de tipo entero en variable valor
        return valor;
    }
}
