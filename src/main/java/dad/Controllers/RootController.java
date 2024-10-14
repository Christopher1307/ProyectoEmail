package dad.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    @FXML
    private Label Asunto;

    @FXML
    private TextField AsuntoTextField;

    @FXML
    private Button CerrarButton;

    @FXML
    private PasswordField ContraseñaPasswordField;

    @FXML
    private Label Destinatario;

    @FXML
    private TextField DestinatarioTiextField;

    @FXML
    private TextArea Email;

    @FXML
    private Button EnviarButton;

    @FXML
    private TextField PuertoTextField;

    @FXML
    private Label Remitente;

    @FXML
    private TextField RemitenteTextField;

    @FXML
    private Label SMPT;

    @FXML
    private Label SSL;

    @FXML
    private TextField SmptTextField;

    @FXML
    private Button VaciarButton;

    @FXML
    private CheckBox SSLCheckBox;

    @FXML
    private GridPane root = new GridPane();  // El contenedor raíz

    public RootController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Acción del botón Enviar
        EnviarButton.setOnAction(event -> {
            enviarCorreo();

        });

        // Acción del botón Vaciar
        VaciarButton.setOnAction(event -> vaciarCampos());

        // Acción del botón Cerrar
        CerrarButton.setOnAction(event -> cerrarAplicacion());
    }

    // Método para obtener el GridPane root
    public GridPane getRoot() {
        return root;
    }

    // Método para enviar el correo electrónico
    private void enviarCorreo() {
        try {
            // Configuramos el correo
            HtmlEmail email = new HtmlEmail();
            email.setHostName(SmptTextField.getText()); // Servidor SMTP
            email.setSmtpPort(Integer.parseInt(PuertoTextField.getText())); // Puerto SMTP
            email.setAuthentication(RemitenteTextField.getText(), ContraseñaPasswordField.getText()); // Autenticación
            email.setFrom(RemitenteTextField.getText()); // Remitente
            email.addTo(DestinatarioTiextField.getText()); // Destinatario
            email.setSubject(AsuntoTextField.getText()); // Asunto
            email.setHtmlMsg(Email.getText()); // Mensaje en HTML

            // Configuración de SSL
            if (SSLCheckBox.isSelected()) {
                email.setSSLOnConnect(true); // SSL activado
            }

            // Depuración
            System.out.println("Enviando correo a: " + DestinatarioTiextField.getText());
            System.out.println("Servidor SMTP: " + SmptTextField.getText());
            System.out.println("Puerto SMTP: " + PuertoTextField.getText());

            // Enviar correo
            email.send();

            // Mostrar alerta de éxito
            mostrarAlertaExito(DestinatarioTiextField.getText());

        } catch (EmailException e) {
            // Mostrar alerta de error
            mostrarAlertaError("Error al enviar el correo: " + e.getMessage());
        }
    }

    // Método para mostrar una alerta de éxito (mensaje enviado)
    private void mostrarAlertaExito(String destinatario) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Mensaje Enviado");
        alert.setHeaderText("Correo enviado con éxito");
        alert.setContentText("El mensaje ha sido enviado a: " + destinatario);
        alert.showAndWait();
    }

    // Método para mostrar una alerta de error (fallo en el envío)
    private void mostrarAlertaError(String mensajeError) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error al enviar el correo");
        alert.setHeaderText("No se pudo enviar el correo");
        alert.setContentText("Error: " + mensajeError + "\nPor favor verifica tu configuración.");
        alert.showAndWait();
    }

    // Método para vaciar los campos de texto
    private void vaciarCampos() {
        SmptTextField.clear();
        PuertoTextField.clear();
        RemitenteTextField.clear();
        ContraseñaPasswordField.clear();
        DestinatarioTiextField.clear();
        AsuntoTextField.clear();
        Email.clear();
        SSLCheckBox.setSelected(false);
    }

    // Método para cerrar la aplicación
    private void cerrarAplicacion() {
        System.exit(0);
    }
    // Método para manejar errores específicos de EmailException
    private void manejarErrorEmailException(String mensajeError) {
        mostrarAlertaError("Error al enviar el correo: " + mensajeError);
    }

}
