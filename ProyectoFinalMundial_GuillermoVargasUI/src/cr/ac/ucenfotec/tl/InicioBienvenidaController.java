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

public class InicioBienvenidaController implements Initializable {

    private AdministradorGestor adminGestor = new AdministradorGestor();

    private String cambio_Escena;

    @FXML
    private TextField txtCorreo;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void validarInfo(ActionEvent event) {

        boolean validacion;

        validacion = validarAdminRegistrado();

        if (validacion) {
            cambio_Escena = "InicioSesion";
            cambiarEscena(cambio_Escena, event);
        } else {
            cambio_Escena = "RegistroAdmin";
            cambiarEscena(cambio_Escena, event);
        }
    }

    private boolean validarAdminRegistrado() {
        boolean validacion = false;

        try {
            Boolean mensaje = adminGestor.validarAdminRegistrado();
            if(mensaje) {
                validacion = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validacion;
    }



    private void cambiarEscena(String cambio_Escena, ActionEvent event){
        try {
            switch (cambio_Escena) {
                case "InicioSesion":

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Inicio.fxml"));
                    Parent parentScene = loader.load();
                    //LoginController controller = loader.getController();


                    Scene newScene = new Scene(parentScene);
                    Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
                    window.setScene(newScene);
                    window.show();

                    break;

                case "RegistroAdmin":
                    FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../ui/RegistroAdmin.fxml"));
                    Parent parentScene2 = loader2.load();
                    RegistroAdminController controller2 = loader2.getController();


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
