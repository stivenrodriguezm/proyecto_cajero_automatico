package cajeroautomatico;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InterfazGrafica extends Application {
    private Banco banco = new Banco();

    public static void main(String[] args) {
        launch(args);
    }

    public static int leerOpcion() {

        return 0;
    }

    public static String leerUsuario() {
        return null;
    }

    public static String leerContraseña() {
        return null;
    }

    public static double leerCantidad() {
        return 0;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cajero Automático Bankzuco");

        VBox layout = new VBox(10);

        Button iniciarSesionBtn = new Button("Iniciar Sesión");
        Button crearCuentaBtn = new Button("Crear Cuenta");
        Button salirBtn = new Button("Salir");

        iniciarSesionBtn.setOnAction(e -> mostrarVentanaIniciarSesion());
        crearCuentaBtn.setOnAction(e -> mostrarVentanaCrearCuenta());
        salirBtn.setOnAction(e -> primaryStage.close());

        layout.getChildren().addAll(iniciarSesionBtn, crearCuentaBtn, salirBtn);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);

        primaryStage.show();
        new Thread(this::mostrarMenuPrincipal).start();
    }

    private void mostrarMenuPrincipal() {
    }

    private void mostrarVentanaIniciarSesion() {
        Stage ventanaIniciarSesion = new Stage();
        ventanaIniciarSesion.setTitle("Iniciar Sesión");

        VBox layout = new VBox(10);

        Label usuarioLabel = new Label("Usuario:");
        TextField usuarioInput = new TextField();

        Label contraseñaLabel = new Label("Contraseña:");
        PasswordField contraseñaInput = new PasswordField();

        Button iniciarSesionBtn = new Button("Iniciar Sesión");
        iniciarSesionBtn.setOnAction(e -> {
            String usuario = usuarioInput.getText();
            String contraseña = contraseñaInput.getText();
            banco.iniciarSesion(usuario, contraseña);
            ventanaIniciarSesion.close();
        });

        layout.getChildren().addAll(usuarioLabel, usuarioInput, contraseñaLabel, contraseñaInput, iniciarSesionBtn);

        Scene scene = new Scene(layout, 300, 200);
        ventanaIniciarSesion.setScene(scene);

        ventanaIniciarSesion.show();
    }

    private void mostrarVentanaCrearCuenta() {
        Stage ventanaCrearCuenta = new Stage();
        ventanaCrearCuenta.setTitle("Crear Cuenta");

        VBox layout = new VBox(10);

        Label usuarioLabel = new Label("Usuario:");
        TextField usuarioInput = new TextField();

        Label contraseñaLabel = new Label("Contraseña:");
        PasswordField contraseñaInput = new PasswordField();

        Button crearCuentaBtn = new Button("Crear Cuenta");
        crearCuentaBtn.setOnAction(e -> {
            String usuario = usuarioInput.getText();
            String contraseña = contraseñaInput.getText();
            banco.crearCuenta(usuario, contraseña);
            ventanaCrearCuenta.close();
        });

        layout.getChildren().addAll(usuarioLabel, usuarioInput, contraseñaLabel, contraseñaInput, crearCuentaBtn);

        Scene scene = new Scene(layout, 300, 200);
        ventanaCrearCuenta.setScene(scene);

        ventanaCrearCuenta.show();
    }
}
