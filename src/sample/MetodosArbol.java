package sample;

/**
 * Created by juam_ on 27/11/2017.
 */
public class MetodosArbol {

    private int size=0;

    public void preOrden(Nodo raiz){
        if(raiz != null){
            size++;
            System.out.print(raiz.getValor() + " ");
            preOrden(raiz.getNodoIzquierdo());
            preOrden(raiz.getNodoDerecho());
        }
    }

    public void inOrden(Nodo raiz){
        if(raiz != null){
            size++;
            inOrden(raiz.getNodoIzquierdo());
            System.out.print(raiz.getValor() + " ");
            inOrden(raiz.getNodoDerecho());
        }
    }

    public void postOrden(Nodo raiz){
        if(raiz != null){
            size++;
            postOrden(raiz.getNodoIzquierdo());
            postOrden(raiz.getNodoDerecho());
            System.out.print(raiz.getValor() + " ");
        }
    }

    public int getSize() {
        return size;
    }
}
