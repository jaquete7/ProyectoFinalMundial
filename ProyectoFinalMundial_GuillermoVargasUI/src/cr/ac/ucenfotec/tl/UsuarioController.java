package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.entities.Equipo.Equipo;
import cr.ac.ucenfotec.bl.entities.Persona;
import cr.ac.ucenfotec.bl.entities.Administrador.Administrador;
import cr.ac.ucenfotec.bl.entities.Usuario.Usuario;
import cr.ac.ucenfotec.bl.logic.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UsuarioController implements Initializable {

    public TextField txtNombreLiga;
    public TextField txtIdUsuario;
    public TableView tblLigasInscritas;
    public TableColumn nombreTablaLigaIns;
    public TableColumn fechaTablaLigaIns;
    public TableColumn mundialTablaLigaIns;
    public TableColumn estadoTablaLigaIns;
    public Label lblPuntaje;
    public TableView tblLigasGeneral;
    public TableColumn nombreTablaLiga;
    public TableColumn fechaTablaLiga;
    public TableColumn mundialTablaLiga;
    public TableColumn estadoTablaLiga;
    private Usuario usuarioSesion;
    private String mensaje;
    private AdministradorGestor adminGestor = new AdministradorGestor();
    private UsuarioGestor usuarioGestor = new UsuarioGestor();

    private EquipoGestor equipoGestor = new EquipoGestor();
    private MundialGestor mundialGestor = new MundialGestor();
    private GrupoGestor grupoGestor = new GrupoGestor();
    private String seleccion;
    ObservableList<Object> datos = FXCollections.observableArrayList();
    ObservableList<Object> datosEquipo = FXCollections.observableArrayList();

    ObservableList<Object> datosMundial = FXCollections.observableArrayList();
    ObservableList<Object> datosGrupo = FXCollections.observableArrayList();
    ObservableList<Object> datosLiga = FXCollections.observableArrayList();

    @FXML
    private Label lblTitulo;


    public Usuario getUsuarioSesion() {
        return usuarioSesion;
    }

    public void setUsuarioSesion(Usuario usuarioSesion) throws Exception {
        this.usuarioSesion = usuarioSesion;
        int puntaje = buscarPuntaje(usuarioSesion.getNombreUsuario());

        setTitulo();
        setPuntaje(puntaje);
    }

    private void setTitulo(){
        lblTitulo.setText("Bienvenido " + usuarioSesion.getNombreUsuario());
    }

    private void setPuntaje(int puntaje){
        lblPuntaje.setText("Puntaje: " + puntaje);
    }

    @FXML
    public void salir(ActionEvent event) throws IOException{
        Parent parentScene = FXMLLoader.load(getClass().getResource("../ui/Login.fxml"));
        Scene newScene = new Scene(parentScene);
        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }



    public void cargarListaEquipos(ActionEvent event) {
    }

    public void listarGrupos(ActionEvent event) {
    }

    public void registrarUsuarioALiga(ActionEvent event) {

        String nombreLiga = txtNombreLiga.getText();
        String idUsuario = txtIdUsuario.getText();

        try {

            boolean validacionLiga = usuarioGestor.validarLiga(nombreLiga);

            if(validacionLiga) {
                String mensaje = usuarioGestor.registrarUsuarioALiga(nombreLiga,idUsuario);
                mostrarMensajeConfirmacion(mensaje);

            } else{
                mostrarMensajeError("Liga no está activa");

            }

            txtNombreLiga.clear();
            txtIdUsuario.clear();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private int buscarPuntaje(String idJugador) throws Exception {

        int puntaje = usuarioGestor.buscarPuntaje(idJugador);
        return puntaje;

    }

    public void listarLigasInscritas(ActionEvent event) {

        //nombreUsuario usuarioSesion.getNombreUsuario();
    }

    public void listarLigasGeneral(ActionEvent event) {
    }

    public void initialize(URL location, ResourceBundle resources) {
        try {
            //cargarListaUsuarios();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
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


}
