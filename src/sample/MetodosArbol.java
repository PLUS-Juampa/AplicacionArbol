package sample;

import javax.swing.*;
import java.util.ArrayList;

public class MetodosArbol {

    public ArrayList<Integer> arrayList = new ArrayList<Integer>(); //  Declaración de nueva ArrayList para almacenar elementos del árbol
    private int maximo; // Variable tipo entero para almacenar el valor más grande en los nodos del árbol
    private int minimo; // Variable tipo entero para almacenar el valor más grande en los nodos del árbol

    //Metodo Buscar que devolverá una variable tipo boolean en caso de encontrar el valor que se manda como parámetro
    public boolean buscar(int valorBuscado){    // Comparará todos los nodos del árbol en caso de ser igual al parámetro retornará verdadero
        for(int i=0; i<arrayList.size(); i++){
            if(arrayList.get(i) == valorBuscado){
                return true;
            }
        }
        return false;   // En caso de no coincidir con ningún valor devolverá falso
    }

    public int valorMaximo(){   // Método para devolver el valor entero que corresponda al valor máximo
        // Se reoorren todos los nodos del árbol, en caso de que ese valor sea más grande que la variable, se asigna el valor a la misma variable
        for(int i=0; i<arrayList.size(); i++){
            if(arrayList.get(i) > maximo){
                maximo = arrayList.get(i);
            }
        }
        return maximo;  // Devolverá el valor de la variable máximo
    }

    public int valorMinimo(){   // Método para devolver el valor entero que corresponda al valor mínimo
        // Se reoorren todos los nodos del árbol, en caso de que ese valor sea menor que la variable, se asigna el valor a la misma variable
        for (int i=0; i<arrayList.size(); i++){
            if(arrayList.get(i) < minimo){
                minimo = arrayList.get(i);
            }
        }
        return minimo;  // Devolverá el valor de la variable mínimo
    }

    //Método para ordenar los nodos del árbol de acuerdo al método de ordenamiento PreOrden
    public void preOrden(Nodo raiz){
        if(raiz != null){
            arrayList.add(raiz.getValor()); // Se llenará el ArrayList dependiendo de la recursividad del método
            maximo = arrayList.get(0);  // Asignación de valor a variable maximo con el primer valor en el ArrayList
            minimo = raiz.getValor();   // Asignación de valor a variable minimo con el valor del nodo raiz del árbol
            preOrden(raiz.getNodoIzquierdo());
            preOrden(raiz.getNodoDerecho());
        }
    }

    public void limpiarArrayList(){ // Método que al ser invocado eliminará todos los elementos del ArrayList
        arrayList.clear();
    }

    public ArrayList auxiliarArrayList(){   // Método que al ser invocado devolverá los elementos del ArrayList
        return arrayList;
    }

    //Método para ordenar los nodos del árbol de acuerdo al método de ordenamiento InOrden
    public void inOrden(Nodo raiz){
        if(raiz != null){
            inOrden(raiz.getNodoIzquierdo());
            arrayList.add(raiz.getValor()); // Se llenará el ArrayList dependiendo de la recursividad del método
            maximo = arrayList.get(0);  // Asignación de valor a variable maximo con el primer valor en el ArrayList
            minimo = raiz.getValor();   // Asignación de valor a variable minimo con el valor del nodo raiz del árbol
            inOrden(raiz.getNodoDerecho());
        }
    }

    //Método para ordenar los nodos del árbol de acuerdo al método de ordenamiento PostOrden
    public void postOrden(Nodo raiz){
        if(raiz != null){
            postOrden(raiz.getNodoIzquierdo());
            postOrden(raiz.getNodoDerecho());
            arrayList.add(raiz.getValor()); // Se llenará el ArrayList dependiendo de la recursividad del método
            maximo = arrayList.get(0);  // Asignación de valor a variable maximo con el primer valor en el ArrayList
            minimo = raiz.getValor();   // Asignación de valor a variable minimo con el valor del nodo raiz del árbol
        }
    }

    public int getSize() {  // Método que devolverá el tamaño del ArrayList
        return arrayList.size();
    }
}
