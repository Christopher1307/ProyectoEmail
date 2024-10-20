package dad.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class RootController {

    @FXML
    private TextField SmptTextField, PuertoTextField, RemitenteTextField, DestinatarioTextField, AsuntoTextField;

    @FXML
    private PasswordField ContraseñaPasswordField;

    @FXML
    private TextArea MensajeTextArea;

    @FXML
    private CheckBox SSLCheckBox;

    @FXML
    private Button EnviarButton, VaciarButton, CerrarButton;

    @FXML
    private GridPane root;

    @FXML
    private void initialize() {
        EnviarButton.setOnAction(event -> enviarCorreo());
        VaciarButton.setOnAction(event -> vaciarCampos());
        CerrarButton.setOnAction(event -> cerrarAplicacion());
    }

    private void enviarCorreo() {
        try {
            HtmlEmail email = new HtmlEmail();
            email.setHostName(SmptTextField.getText());
            email.setSmtpPort(Integer.parseInt(PuertoTextField.getText()));

            // Autenticación del remitente
            email.setAuthentication(RemitenteTextField.getText(), ContraseñaPasswordField.getText());

            // Configuración de SSL
            email.setSSLOnConnect(SSLCheckBox.isSelected());

            // Configurar remitente, destinatario, asunto y mensaje
            email.setFrom(RemitenteTextField.getText());
            email.addTo(DestinatarioTextField.getText());
            email.setSubject(AsuntoTextField.getText());
            email.setHtmlMsg(MensajeTextArea.getText());

            // Enviar el correo
            email.send();

            // Alerta de éxito
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Correo enviado exitosamente a " + DestinatarioTextField.getText());

        } catch (EmailException | NumberFormatException e) {
            // Manejo de errores
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo enviar el correo: " + e.getMessage());
        }
    }

    private void vaciarCampos() {
        SmptTextField.clear();
        PuertoTextField.clear();
        RemitenteTextField.clear();
        ContraseñaPasswordField.clear();
        DestinatarioTextField.clear();
        AsuntoTextField.clear();
        MensajeTextArea.clear();
        SSLCheckBox.setSelected(false);
    }

    private void cerrarAplicacion() {
        System.exit(0);
    }

    private void mostrarAlerta(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public GridPane getRoot() {
        return root;
    }
}
