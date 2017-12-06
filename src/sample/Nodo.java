package sample;

/**
 * Created by juam_ on 27/11/2017.
 */
public class Nodo {

    private Nodo nodoIzquierdo = null, nodoDerecho = null;
    private int valor;
    private int tam;

    public Nodo(int valor) {
        this.valor = valor;
        tam++;
    }
    public int getTam(){
        return tam;
    }

    public Nodo getNodoIzquierdo() {
        return nodoIzquierdo;
    }

    public void setNodoIzquierdo(Nodo nodoIzquierdo) {
        this.nodoIzquierdo = nodoIzquierdo;
    }

    public Nodo getNodoDerecho() {
        return nodoDerecho;
    }

    public void setNodoDerecho(Nodo nodoDerecho) {
        this.nodoDerecho = nodoDerecho;
    }

    public int getValor() {
        return valor;
    }
}