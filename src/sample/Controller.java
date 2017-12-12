package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    ComboBox cmbMetodos;    // Inicialización de componente comboBox

    @FXML
    ListView listNumeros;   // Inicialización de componente listView

    @FXML
    TextField txtBuscar, txtAgregar;    // Inicialización de componentes textBox

    @FXML
    Button btnTotalNodos, btnMaximo, btnMinimo, btnBuscar, btnAgregar;   // Inicialización de componentes Button

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Asignación de valores a comboBox
        cmbMetodos.getItems().addAll("Pre Orden", "In Orden", "Post Orden");

        MetodosArbol arbol = new MetodosArbol();    // Declaración de instancia de clase MetodosArbol

        Nodo raiz = new Nodo(1);    // Declaración de instancia de clase Nodo y asignación de valor a raiz

        Nodo nodo2 = new Nodo(2);   // Declaración de instancia de clase Nodo y asignación de valor a raiz de rama secundaria
        Nodo nodo3 = new Nodo(3);   // Declaración de instancia de clase Nodo y asignación de valor a raiz de rama secundaria

        nodo3.setNodoDerecho(new Nodo(6));  // Asignación de nuevo valor a rama secundaria derecha de la instancia nodo3
        nodo3.setNodoIzquierdo(new Nodo(5));    // Asignación de nuevo valor a rama secundaria izquierda de la instancia nodo3

        nodo2.setNodoIzquierdo(new Nodo(4));// Asignación de nuevo valor a rama secundaria izquierda de la instancia nodo2

        raiz.setNodoIzquierdo(nodo2);   // Asignación de nuevo valor a rama secundaria izquierda de la raiz del árbol
        raiz.setNodoDerecho(nodo3); // Asignación de nuevo valor a rama secundaria derecha de la raiz del árbol

        arbol.preOrden(raiz);   // Llamada al método preOrden de instancia arbol para asignación de valores iniciales

        // Acción clic en comboBox cmbMetodos
        this.cmbMetodos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listNumeros.getItems().clear(); // Elimina los elementos del listView
                arbol.limpiarArrayList();   // Llamada al método limpiarArray para eliminar elementos del ArrayList
                if (!cmbMetodos.getValue().equals("")) {    // En caso de que el haya un valor en el combo box
                    switch (cmbMetodos.getValue().toString()) { // Dependiendo el valor en el comboBox se ejecutarán diferentes instrucciones
                        case "Pre Orden":   // En caso de ser este valor
                            arbol.preOrden(raiz);   // Llamada a método de ordenamiento PreOrden
                            listNumeros.getItems().addAll(arbol.auxiliarArrayList());   // Los valores se almacenan en el ListVoew
                            break;
                        case "In Orden":    // En caso de ser este valor
                            arbol.inOrden(raiz);   // Llamada a método de ordenamiento InOrden
                            listNumeros.getItems().addAll(arbol.auxiliarArrayList());   // Los valores se almacenan en el ListVoew
                            break;
                        case "Post Orden":  // En caso de ser este valor
                            arbol.postOrden(raiz);   // Llamada a método de ordenamiento PostOrden
                            listNumeros.getItems().addAll(arbol.auxiliarArrayList());   // Los valores se almacenan en el ListVoew
                            break;
                        default:    // En caso de no ser así se mandará un mensaje de error
                            Alert alert = new Alert(Alert.AlertType.ERROR);   // Mensaje de información tipo alert
                            alert.setTitle("Administración de Árbol");
                            alert.setHeaderText("Métodos de Ordenamiento");
                            alert.setContentText("Opción Incorrecta");
                            alert.showAndWait();
                            break;
                    }
                }
            }
        });

        // Acción clic del botón btnBuscar
        this.btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (txtBuscar.getText().isEmpty()) {    // En caso de que el campo txtBuscar esté vacío mandarpa un mensaje de advertencia
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Búsqueda de Elemento");
                        alert.setHeaderText("Nodos en Árbol");
                        alert.setContentText("El campo de texto no debe estar vacío");
                        alert.showAndWait();
                        txtBuscar.requestFocus();
                    } else {    // En caso de que exista un valor en campo txtBuscar se ejecutará lo siquiente
                        if (arbol.buscar(Integer.parseInt(txtBuscar.getText()))) {  // Sí el valor devuelto de la invocación del método es verdadero
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);   // Mensaje de información tipo alert
                            alert.setTitle("Búsqueda de Elemento");
                            alert.setHeaderText("Nodos en Árbol");
                            alert.setContentText("El número " + txtBuscar.getText() + " fue encontrado en el árbol");   // Mandará confirmación de que se encotró el elemento en los nodos del árbol
                            alert.showAndWait();
                            txtBuscar.setText("");
                        } else {    // En caso de no ser encontrado el valor mandará un mensaje de inexistencia de valor
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);   // Mensaje de información tipo alert
                            alert.setTitle("Búsqueda de Elemento");
                            alert.setHeaderText("Nodos en Árbol");
                            alert.setContentText("El número " + txtBuscar.getText() + " es inexistente en árbol");
                            alert.showAndWait();
                            txtBuscar.setText("");
                        }
                    }
                } catch (Exception e) { // En caso de que el valor eb campo txtBuscar no sea de tipo entero mandará un mensaje de error
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Búsqueda de Elemento");
                    alert.setHeaderText("Nodos en Árbol");
                    alert.setContentText("Sólo se pueden ingresar números enteros");
                    alert.showAndWait();
                    txtBuscar.setText("");
                    txtBuscar.requestFocus();
                }
            }
        });

        // Acción clic del botón btnTotalNodos
        this.btnTotalNodos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { // Mandará un mensaje con la información de la invocación del método para encontrar el total de nodos en el árbol
                Alert alert = new Alert(Alert.AlertType.INFORMATION);   // Mensaje de información tipo alert
                alert.setTitle("Administración de Árbol");
                alert.setHeaderText("Total de Nodos");
                alert.setContentText("Nodos en el árbol:  " + arbol.getSize()); // Llamada al método
                alert.showAndWait();
            }
        });

        //Mètodo para mandar en pantalla el valor màximo en los nodos
        this.btnMaximo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);   // Mensaje de información tipo alert
                alert.setTitle("Administración de Árbol");
                alert.setHeaderText("Control de Nodos");
                alert.setContentText("El valor màximo en los nodos es:  " + arbol.valorMaximo());   // Llamada al método
                alert.showAndWait();
            }
        });

        //Mètodo para mandar en pantalla el valor mìnimo en los nodos
        this.btnMinimo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);   // Mensaje de información tipo alert
                alert.setTitle("Administración de Árbol");
                alert.setHeaderText("Control de Nodos");
                alert.setContentText("El valor mìnimo en los nodos es:  " + arbol.valorMinimo());   // Llamada al método
                alert.showAndWait();
            }
        });

        //  Acción clic del método btnAgregar... Aún no se ha implementado esta opción
        this.btnAgregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.WARNING);   // Mensaje de información tipo alert
                alert.setTitle("Agregar Número");
                alert.setHeaderText("Control de Nodos");
                alert.setContentText("Por el momento no se puede ingresar un valor al árbol");
                alert.showAndWait();
                txtAgregar.setText("");
                txtAgregar.requestFocus();
            }
        });

    }
}
