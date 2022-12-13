package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.entities.Persona;
//import cr.ac.ucenfotec.bl.logic.PersonaGestor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class InicioController implements Initializable {

    //private PersonaGestor gestor = new PersonaGestor();
    private PrintStream out = System.out;
    @FXML
    private TextField txtCorreo;
    @FXML
    private PasswordField txtPassword;

    private String seleccion;


    @FXML
    private void inicioSesion(ActionEvent event){
        seleccion = "inicioSesion";
        cambiarEscena(seleccion, event);




    }
    @FXML
    private void registrarAdmin(ActionEvent event){
        seleccion = "registroAdmin";
        cambiarEscena(seleccion, event);


    }
    @FXML
    private void registrarJugador(ActionEvent event){
        seleccion = "registroJugador";
        cambiarEscena(seleccion, event);


    }


    @FXML
    private void cambiarEscena(String seleccion, ActionEvent event){
        try {
            switch (seleccion) {
                case "inicioSesion":

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Login.fxml"));
                    Parent parentScene = loader.load();
                    LoginController controller = loader.getController();
                    //controller.setUsuarioSesion(usuario);

                    Scene newScene = new Scene(parentScene);
                    Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
                    window.setScene(newScene);
                    window.show();
                    break;

                case "registroAdmin":
                    FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../ui/RegistroAdmin.fxml"));
                    Parent parentScene2 = loader2.load();
                    RegistroAdminController controller2 = loader2.getController();
                    //controller.setUsuarioSesion(usuario);

                    Scene newScene2 = new Scene(parentScene2);
                    Stage window2 = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
                    window2.setScene(newScene2);
                    window2.show();

                    break;

                case "registroJugador":
                    FXMLLoader loader3 = new FXMLLoader(getClass().getResource("../ui/RegistroUsuario.fxml"));
                    Parent parentScene3 = loader3.load();
                    RegistroUsuarioController controller3 = loader3.getController();
                    //controller.setUsuarioSesion(usuario);

                    Scene newScene3 = new Scene(parentScene3);
                    Stage window3 = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
                    window3.setScene(newScene3);
                    window3.show();
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


    //CODIGO PARA IMPLEMENTAR ENTREGA FINAL
    /**

     @FXML
     void validarDatos(ActionEvent event) {
     String correo = txtCorreo.getText();
     String contrasena = txtPassword.getText();
     Persona usuario;
     boolean error = false;

     error = validarCampos(correo, contrasena);

     if (error) {
     Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
     alert.setHeaderText(null);
     alert.showAndWait();
     } else {
     usuario = buscarUsuario(correo, contrasena);
     if (usuario !=null) {
     cambiarEscena(usuario,event);
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

     private Persona buscarUsuario(String correo, String password) {
     try {
     Persona usuario = gestor.buscarPersona(correo,password);
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
