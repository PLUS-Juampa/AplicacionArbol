package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    ComboBox cmbMetodos;

    @FXML
    ListView listNumeros;

    @FXML
    Button btnTotalNodos;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cmbMetodos.getItems().addAll("Pre Orden","In Orden", "Post Orden");

        MetodosArbol arbol = new MetodosArbol();

        Nodo raiz = new Nodo(1);

        Nodo nodo2 = new Nodo(2);
        Nodo nodo3 = new Nodo(3);

        nodo3.setNodoDerecho(new Nodo(6));
        nodo3.setNodoIzquierdo(new Nodo(5));

        nodo2.setNodoIzquierdo(new Nodo(4));

        raiz.setNodoIzquierdo(nodo2);
        raiz.setNodoDerecho(nodo3);

        this.cmbMetodos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listNumeros.getItems().clear();
                arbol.limpiarArrayList();
                if(cmbMetodos.getValue().equals("")){
                    return;
                }else {
                    switch (cmbMetodos.getValue().toString()){
                        case "Pre Orden":
                            arbol.preOrden(raiz);   // Llamada a método de ordenamiento
                            listNumeros.getItems().addAll(arbol.auxiliarArrayList());
                            break;
                        case "In Orden":
                            arbol.preOrden(raiz);   // Llamada a método de ordenamiento
                            listNumeros.getItems().addAll(arbol.auxiliarArrayList());
                            break;
                        case "Post Orden":
                            arbol.preOrden(raiz);   // Llamada a método de ordenamiento
                            listNumeros.getItems().addAll(arbol.auxiliarArrayList());
                            break;
                        default:
                            Alert alert = new Alert(Alert.AlertType.ERROR);   // Mensaje de información tipo alert
                            alert.setTitle("Administración de Árbol");
                            alert.setHeaderText("Métodos de Ordenamiento");
                            alert.setContentText("Opción Incorrecta");
                            alert.showAndWait();

                    }
                }
            }
        });

        this.btnTotalNodos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);   // Mensaje de información tipo alert
                alert.setTitle("Administración de Árbol");
                alert.setHeaderText("Total de Nodos");
                alert.setContentText("Nodos en el árbol:  " + arbol.getSize());
                alert.showAndWait();
            }
        });

    }
}
