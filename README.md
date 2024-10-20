
# Cliente de Correo Electrónico

Este es un cliente de correo electrónico simple desarrollado en Java utilizando JavaFX y la biblioteca Apache Commons Email. Permite enviar correos electrónicos a través de un servidor SMTP configurado por el usuario.

## Requisitos Previos

- **Java JDK 11 o superior**: Asegúrate de tener instalado el JDK en tu sistema.
- **Apache Commons Email**: Esta biblioteca es necesaria para enviar correos electrónicos. Puedes incluirla en tu proyecto utilizando Maven o descargando el JAR directamente.

## Estructura del Proyecto

El proyecto sigue la siguiente estructura de carpetas:

ProyectoEmail/ ├── src/ │ ├── main/ │ │ ├── java/ │ │ │ └── dad/ │ │ │ ├── MainApp.java # Clase principal de la aplicación │ │ │ ├── Main.java # Clase de inicio │ │ │ └── Controllers/ │ │ │ └── RootController.java # Controlador principal │ │ └── resources/ │ │ └── fxml/ │ │ └── RootView.fxml # Archivo FXML para la interfaz de usuario

bash
Copiar código

## Cómo Ejecutar el Proyecto

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/tu_usuario/ProyectoEmail.git
Navegar al directorio del proyecto:

bash
Copiar código
cd ProyectoEmail
Compilar el proyecto: Si estás utilizando Maven, puedes compilar el proyecto con:

bash
Copiar código
mvn clean install
Ejecutar la aplicación: Puedes ejecutar la aplicación desde tu IDE o desde la línea de comandos:

bash
Copiar código
java -cp target/ProyectoEmail-1.0-SNAPSHOT.jar dad.Main

Uso
Inicia la aplicación.
Ingresa los detalles de tu servidor SMTP, incluyendo:
Servidor SMTP: Nombre o dirección IP del servidor.
Puerto: Puerto del servidor (generalmente 587 para TLS).
Remitente: Dirección de correo electrónico del remitente.
Contraseña: Contraseña de la cuenta de correo del remitente.
Destinatario: Dirección de correo electrónico del destinatario.
Asunto: Asunto del correo.
Mensaje: Contenido del correo.
Haz clic en "Enviar" para enviar el correo.
Usa "Vaciar" para limpiar los campos o "Cerrar" para salir de la aplicación.
Contribuciones
Las contribuciones son bienvenidas. Si deseas contribuir, por favor crea un fork del repositorio y envía un pull request.

Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

Asegúrate de reemplazar la URL del repositorio de GitHub y otros detalles según sea necesario para que se ajuste a tu proyecto. ¡Espero que esto te ayude!
