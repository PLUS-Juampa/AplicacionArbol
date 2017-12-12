package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Control de Árboles");
        primaryStage.setScene(new Scene(root, 725, 520));
        primaryStage.show();
    }
    //  Clase Main para la ejecución del programa utilizando la interfaz sample.fxml

    public static void main(String[] args) {
        launch(args);
    }
}
