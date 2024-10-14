package dad;


import dad.Controllers.RootController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    // Instanciamos el controlador root
    private final RootController rootController = new RootController();

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Creamos la escena con el root del controlador
        Scene scene = new Scene(rootController.getRoot());

        // Configuramos la ventana principal (Stage)
        primaryStage.setTitle("Cliente de correo");
        primaryStage.setScene(scene); // Asignamos la escena
        primaryStage.show(); // Mostramos la ventana
    }


}


