package dad;

import dad.Controllers.RootController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Cargar el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
            Scene scene = new Scene(loader.load());

            primaryStage.setTitle("Cliente de correo");
            primaryStage.setScene(scene);
            primaryStage.setMinWidth(400); // Establecer un ancho mínimo
            primaryStage.setMinHeight(300); // Establecer una altura mínima
            primaryStage.setOnCloseRequest(event -> {
                System.out.println("Cerrando la aplicación...");
            });
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace(); // Manejo de excepciones
        }
    }

    public static void main(String[] args) {
        launch(args); // Lanzar la aplicación
    }
}

