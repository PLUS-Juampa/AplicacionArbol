package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    ComboBox cmbMetodos;

    @FXML
    Label lblNumerosOrdenados;

    @FXML
    ListView listNumeros;

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
                if(cmbMetodos.getValue().equals("")){
                    return;
                }else {
                    //lblNumerosOrdenados.setText(arbol.preOrden(raiz));
                    listNumeros.getItems().addAll(arbol.preOrden(raiz));
                }
            }
        });

    }
}
