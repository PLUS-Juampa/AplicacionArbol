package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by juam_ on 27/11/2017.
 */
public class MetodosArbol {

    //Metodo Buscar... Angel Enrique

    public boolean buscar(int valorBuscado){
        for(int i=0; i<arrayList.size(); i++){
            if(arrayList.get(i) == valorBuscado){
                return true;
            }
        }
        return false;
    }



    private int size=0;
    public ListView listNumeros = new ListView();
    public ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private int i = 0;

    public void preOrden(Nodo raiz){
        try {
            if(raiz != null){

                arrayList.add(raiz.getValor());
                i++;
                preOrden(raiz.getNodoIzquierdo());
                preOrden(raiz.getNodoDerecho());

            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

    }
    public void limpiarArrayList(){
        arrayList.clear();
    }

    public ArrayList auxiliarArrayList(){
        return arrayList;
    }

    public void inOrden(Nodo raiz){
        if(raiz != null){
            inOrden(raiz.getNodoIzquierdo());
            System.out.print(raiz.getValor() + " ");
            inOrden(raiz.getNodoDerecho());
        }
    }

    public void postOrden(Nodo raiz){
        if(raiz != null){
            postOrden(raiz.getNodoIzquierdo());
            postOrden(raiz.getNodoDerecho());
            System.out.print(raiz.getValor() + " ");
        }
    }

    public int getSize() {
        return arrayList.size();
    }
}
