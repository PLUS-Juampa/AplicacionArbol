package sample;

/**
 * Created by juam_ on 27/11/2017.
 */
public class MetodosArbol {

    private int size=0;

    public int preOrden(Nodo raiz){
        int valor = 0;
        if(raiz != null){

            valor = raiz.getValor();
            preOrden(raiz.getNodoIzquierdo());
            preOrden(raiz.getNodoDerecho());
        }
        return valor;
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
