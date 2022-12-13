package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.entities.Administrador.Administrador;
import cr.ac.ucenfotec.bl.entities.Persona;
import cr.ac.ucenfotec.bl.entities.Usuario.Usuario;
import cr.ac.ucenfotec.bl.logic.AdministradorGestor;
import cr.ac.ucenfotec.bl.logic.AdministradorGestor;
import cr.ac.ucenfotec.bl.logic.UsuarioGestor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.PrintStream;

public class LoginController implements Initializable {

    private AdministradorGestor adminGestor = new AdministradorGestor();
    private UsuarioGestor usuarioGestor = new UsuarioGestor();

    private String cambio_Escena;

    @FXML
    private TextField txtCorreo;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void validarDatos(ActionEvent event) {
        String correo = txtCorreo.getText();
        String contrasena = txtPassword.getText();
        Administrador admin;
        Usuario usuario;
        boolean error = false;

        error = validarCampos(correo, contrasena);

        if (error) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            admin = buscarUsuarioAdmin(correo, contrasena);
            //System.out.println(admin);
            if (admin != null) {
                cambio_Escena = "admin";
                cambiarEscena(admin,cambio_Escena, event);

            }
            else if (admin ==null) {
                usuario = buscarUsuarioJugador(correo, contrasena);
                if (usuario != null) {
                    cambio_Escena = "jugador";
                    cambiarEscena(usuario,cambio_Escena, event);
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Usuario o Contraseña incorrecta");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }

            }

            else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "El usuario no se encuentra registrado");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
        }
    }

    private boolean validarCampos(String correo, String contrasena) {
        boolean error = false;

        if (correo.equals("")) {
            error = true;
        }
        if (contrasena.equals("")) {
            error = true;
        }
        return error;
    }

    private Administrador buscarUsuarioAdmin(String correo, String password) {
        try {
            Administrador usuario = adminGestor.buscarAdministrador(correo,password);
            if(usuario != null) {
                return usuario;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Usuario buscarUsuarioJugador(String correo, String password) {
        try {
            Usuario usuario = usuarioGestor.buscarUsuario(correo,password);
            if(usuario != null) {
                return usuario;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void cambiarEscena(Persona usuario, String cambio_Escena, ActionEvent event){
        try {
            switch (cambio_Escena) {
                case "admin":
                    Administrador admin = new Administrador();
                    admin =(Administrador) usuario;
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/AdminInicio.fxml"));
                    Parent parentScene = loader.load();
                    AdministradorController controller = loader.getController();
                    controller.setUsuarioSesion(admin);

                    Scene newScene = new Scene(parentScene);
                    Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
                    window.setScene(newScene);
                    window.show();
                    break;

                case "jugador":
                    Usuario usuario2 = new Usuario();
                    usuario2 =(Usuario) usuario;
                    FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../ui/UsuarioInicio.fxml"));
                    Parent parentScene2 = loader2.load();
                    UsuarioController controller2 = loader2.getController();
                    controller2.setUsuarioSesion(usuario2);

                    Scene newScene2 = new Scene(parentScene2);
                    Stage window2 = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
                    window2.setScene(newScene2);
                    window2.show();
                    break;
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al cambiar de ventana. Intente de nuevo: " + e.getMessage());
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
