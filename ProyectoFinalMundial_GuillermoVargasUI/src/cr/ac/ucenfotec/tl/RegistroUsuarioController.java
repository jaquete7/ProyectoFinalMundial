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

public class RegistroUsuarioController implements Initializable {

    private AdministradorGestor adminGestor = new AdministradorGestor();
    private UsuarioGestor usuarioGestor = new UsuarioGestor();

    private String cambio_Escena;
    @FXML
    private TextField txtIdentificacion;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtNombreUsuario;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtAvatar;
    @FXML
    private TextField txtEquipoFavorito;

    @FXML
    void validarDatos(ActionEvent event) {
        String identificacion = txtIdentificacion.getText();
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String correo = txtCorreo.getText();
        String nombreUsuario = txtNombreUsuario.getText();
        String contrasena = txtPassword.getText();
        String avatar = txtAvatar.getText();
        String equipoFavorito = txtEquipoFavorito.getText();
        Administrador admin;
        Usuario usuario;
        boolean error = false;

        error = validarCampos(identificacion, nombre, apellidos, correo, nombreUsuario, contrasena, avatar, equipoFavorito);

        if (error) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();

        } else if (!((contrasena.length() >= 6)
                && (contrasena.length() <= 8))) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Contrase??a debe tener entre 6 y 8 caracteres");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else {
            String mensaje = registrarUsuario(identificacion, nombre, apellidos, correo, nombreUsuario, contrasena, avatar,equipoFavorito);
            mostrarMensajeConfirmacion(mensaje);
            cambio_Escena = "admin";
            cambiarEscena(event);
            //System.out.println(admin);
        }







    }

    private boolean validarCampos(String identificacion, String nombre, String apellidos, String correo, String nombreUsuario, String contrasena, String avatar, String eqipoFavorito) {
        boolean error = false;

        if (identificacion.equals("")) {
            error = true;
        }
        if (nombre.equals("")) {
            error = true;
        }
        if (apellidos.equals("")) {
            error = true;
        }
        if (correo.equals("")) {
            error = true;
        }
        if (nombreUsuario.equals("")) {
            error = true;
        }

        if (contrasena.equals("")) {
            error = true;
        }
        if (avatar.equals("")) {
            error = true;
        }
        if (eqipoFavorito.equals("")) {
            error = true;
        }
        return error;
    }



    private String registrarUsuario(String identificacion, String nombre, String apellidos, String correo, String nombreUsuario, String password, String avatar, String equipoFavorito) {
        try {
            String mensaje = usuarioGestor.registrarUsuario(identificacion,nombre,apellidos,correo,nombreUsuario,password,avatar,equipoFavorito);
            return  mensaje;

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

    private void cambiarEscena(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Login.fxml"));
            Parent parentScene = loader.load();
            LoginController controller = loader.getController();
            //controller.setUsuarioSesion(admin);

            Scene newScene = new Scene(parentScene);
            Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            window.setScene(newScene);
            window.show();


        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al cambiar de ventana. Intente de nuevo: " + e.getMessage());
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void mostrarMensajeConfirmacion(String mensaje){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, mensaje);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    private void mostrarMensajeError(String mensaje){
        Alert alert = new Alert(Alert.AlertType.ERROR, mensaje);
        alert.setHeaderText(null);
        alert.showAndWait();

    }





    //CODIGO PARA IMPLEMENTAR ENTREGA FINAL
    /**
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

     */
}
