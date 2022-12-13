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

public class AdministradorController implements Initializable {


    private Administrador usuarioSesion;
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
    private TableView tblUsuarios;
    @FXML
    private TableView tblEquipos;

    @FXML
    private TableView tblMundiales;
    @FXML
    private TableView tblGrupos;

    @FXML
    private TableView tblLigas;


    @FXML
    private TableColumn colUno;

    @FXML
    private TableColumn colDos;

    @FXML
    private TableColumn colTres;

    @FXML
    private TableColumn colCuatro;
    @FXML
    private TableColumn colCinco;
    @FXML
    private TableColumn colSeis;
    @FXML
    private TableColumn colSiete;
    @FXML
    private TableColumn colOcho;

    @FXML
    private TableColumn codigo;

    @FXML
    private TableColumn nombrePais;

    @FXML
    private TableColumn ranking;

    @FXML
    private TableColumn bandera;

    @FXML
    private TableColumn añoTabla;

    @FXML
    private TableColumn paisOrganizadorTabla;

    @FXML
    private TableColumn estadoTabla;

    @FXML
    private TableColumn codigoTablaGrupo;

    @FXML
    private TableColumn nombreTablaGrupo;

    @FXML
    private TableColumn mundialTablaGrupo;

    @FXML
    private TableColumn nombreTablaLiga;

    @FXML
    private TableColumn fechaTablaLiga;

    @FXML
    private TableColumn mundialTablaLiga;

    @FXML
    private TableColumn estadoTablaLiga;


    @FXML
    private Label lblTitulo;

    @FXML
    private TextField txtCodigoEquipo;

    @FXML
    private TextField txtNombrePais;

    @FXML
    private TextField txtRanking;
    @FXML
    private TextField txtBandera;

    @FXML
    private TextField txtAñoMundial;
    @FXML
    private TextField txtPaisOrganizador;
    @FXML
    private TextField txtEstadoMundial;

    @FXML
    private TextField txtAñoMundialActivar;

    @FXML
    private TextField txtCodigoGrupo;

    @FXML
    private TextField txtNombreGrupo;

    @FXML
    private TextField txtAñoMundialGrupo;
    @FXML
    private TextField txtAñoMundialListar;

    @FXML
    private TextField txtNombreLiga;

    @FXML
    private TextField txtAñoMundialLiga;

    @FXML
    private TextField txtFechaLiga;

    @FXML
    private TextField txtEstadoLiga;
    @FXML
    private TextField txtAñoLigaListar;

    @FXML
    private TextField txtNombreLigaActivar;

    @FXML
    public TextField txtAñoEquipoGrupo;
    @FXML
    public TextField txtCodigoGrupoEquipo;
    @FXML
    public TextField txtCodigoEquipoGrupo;






    public Administrador getUsuarioSesion() {
        return usuarioSesion;
    }

    public void setUsuarioSesion(Administrador usuarioSesion) {
        this.usuarioSesion = usuarioSesion;
        setTitulo();
    }

    private void setTitulo(){
        lblTitulo.setText("Bienvenido " + usuarioSesion.getNombreUsuario());
    }

    @FXML
    public void salir(ActionEvent event) throws IOException{
        Parent parentScene = FXMLLoader.load(getClass().getResource("../ui/Login.fxml"));
        Scene newScene = new Scene(parentScene);
        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            //cargarListaUsuarios();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    private void cargarListaUsuarios(ActionEvent event) throws Exception{
        seleccion = "Listar Usuarios";
        seleccionBoton(seleccion,event);


    }

    @FXML
    private void cargarListaEquipos(ActionEvent event) throws Exception {
        seleccion = "Listar Equipos";
        seleccionBoton(seleccion,event);

    }

    @FXML
    void validarDatosEquipo(ActionEvent event) {
        String codigo = txtCodigoEquipo.getText();
        String nombrePais = txtNombrePais.getText();
        String ranking = txtRanking.getText();
        String bandera = txtBandera.getText();
        Equipo equipo;
        boolean error = false;

        error = validarCampos(codigo, nombrePais, ranking, bandera);

        if (error) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            int rankingInt = Integer.parseInt(ranking);
            String mensaje = registrarEquipo(codigo, nombrePais, rankingInt, bandera);
            mostrarMensajeConfirmacion(mensaje);
            txtCodigoEquipo.clear();
            txtNombrePais.clear();
            txtRanking.clear();
            txtBandera.clear();

        }
    }

    private boolean validarCampos(String codigo, String nombrePais, String ranking, String bandera) {
        boolean error = false;

        if (codigo.equals("")) {
            error = true;
        }
        if (nombrePais.equals("")) {
            error = true;
        }
        if (ranking.equals("")) {
            error = true;
        }
        if (bandera.equals("")) {
            error = true;
        }
        return error;
    }


    @FXML
    private void seleccionBoton(String seleccion, ActionEvent event){
        try {
            switch (seleccion) {
                case "Listar Usuarios":

                    tblUsuarios.getItems().clear();
                    usuarioGestor.listarUsuariosObjeto().forEach(persona -> datos.addAll(persona));

                    colUno.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
                    colDos.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                    colTres.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
                    colCuatro.setCellValueFactory(new PropertyValueFactory<>("correoElectronico"));
                    colCinco.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));
                    colSeis.setCellValueFactory(new PropertyValueFactory<>("contrasena"));
                    colSiete.setCellValueFactory(new PropertyValueFactory<>("avatar"));
                    colOcho.setCellValueFactory(new PropertyValueFactory<>("equipoFavorito"));

                    tblUsuarios.setItems(datos);
                    break;

                case "Listar Equipos":
                    tblEquipos.getItems().clear();
                    equipoGestor.listarEquiposObjeto().forEach(equipo -> datosEquipo.addAll(equipo));

                    codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
                    nombrePais.setCellValueFactory(new PropertyValueFactory<>("nombrePais"));
                    ranking.setCellValueFactory(new PropertyValueFactory<>("ranking"));
                    bandera.setCellValueFactory(new PropertyValueFactory<>("bandera"));

                    tblEquipos.setItems(datosEquipo);

                    break;

                case "registroJugador":

                    break;
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error en el boton. Intente de nuevo: " + e.getMessage());
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }

    @FXML
    private String registrarEquipo(String codigo, String nombrePais, int ranking, String bandera){
        try {
            String mensaje = equipoGestor.registrarEquipo(codigo, nombrePais, ranking, bandera);
            return  mensaje;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @FXML
    private String registrarMundial(ActionEvent event){

        int año = Integer.parseInt(txtAñoMundial.getText());
        String paisOrganizador = txtPaisOrganizador.getText();
        String estado = txtEstadoMundial.getText();
        try {
            String mensaje = mundialGestor.registrarMundial(año, paisOrganizador, estado);
            mostrarMensajeConfirmacion(mensaje);
            txtAñoMundial.clear();
            txtPaisOrganizador.clear();
            txtEstadoMundial.clear();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @FXML
    String listarMundiales (ActionEvent event) throws Exception {
        tblMundiales.getItems().clear();

        mundialGestor.listarMundialesObjeto().forEach(mundial -> datosMundial.addAll(mundial));

        añoTabla.setCellValueFactory(new PropertyValueFactory<>("Ano"));
        paisOrganizadorTabla.setCellValueFactory(new PropertyValueFactory<>("paisOrganizador"));
        estadoTabla.setCellValueFactory(new PropertyValueFactory<>("Estado"));

        tblMundiales.setItems(datosMundial);
        return null;
    }

    @FXML
    String cambiarEstadoMundial(ActionEvent event) throws Exception {
        int año = Integer.parseInt(txtAñoMundialActivar.getText());
        try {
            String mensaje = mundialGestor.cambiarEstadoMundial(año);
            mostrarMensajeConfirmacion(mensaje);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }



    @FXML
    private String registrarGrupo(ActionEvent event){

        int codigo = Integer.parseInt(txtCodigoGrupo.getText());
        String nombre = txtNombreGrupo.getText();
        int mundial = Integer.parseInt(txtAñoMundialGrupo.getText());
        try {
            String mensaje = mundialGestor.agregarGrupoAMundial(codigo, nombre, mundial);
            mostrarMensajeConfirmacion(mensaje);
            txtCodigoGrupo.clear();
            txtNombreGrupo.clear();
            txtAñoMundialGrupo.clear();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


    @FXML
    String listarGrupos (ActionEvent event) throws Exception {

        int mundial = Integer.parseInt(txtAñoMundialListar.getText());
        String mundialRetorno = txtAñoMundialListar.getText();
        tblGrupos.getItems().clear();

        mundialGestor.listarGruposObjeto(mundial).forEach(grupo -> datosGrupo.addAll(grupo));

        codigoTablaGrupo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        nombreTablaGrupo.setCellValueFactory(new PropertyValueFactory<>("nombre"));


        tblGrupos.setItems(datosGrupo);
        return null;
    }

    @FXML
    private String registrarLiga(ActionEvent event){

        String nombre = txtNombreLiga.getText();
        String fecha = txtFechaLiga.getText();
        int mundial = Integer.parseInt(txtAñoMundialLiga.getText());
        String estado = txtEstadoLiga.getText();
        try {
            String mensaje = mundialGestor.agregarLigaAMundial(nombre, fecha, mundial, estado);
            mostrarMensajeConfirmacion(mensaje);

            txtNombreLiga.clear();
            txtFechaLiga.clear();
            txtAñoMundialLiga.clear();
            txtEstadoLiga.clear();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @FXML
    String listarLigas (ActionEvent event) throws Exception {

        int aniomundial = Integer.parseInt(txtAñoLigaListar.getText());

        tblLigas.getItems().clear();

        mundialGestor.listarLigasObjeto(aniomundial).forEach(liga -> datosLiga.addAll(liga));

        nombreTablaLiga.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        fechaTablaLiga.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion"));
        mundialTablaLiga.setCellValueFactory(new PropertyValueFactory<>("mundialPerteneciente"));
        estadoTablaLiga.setCellValueFactory(new PropertyValueFactory<>("estado"));


        tblLigas.setItems(datosLiga);
        return null;
    }

    @FXML
    String cambiarEstadoLiga(ActionEvent event) throws Exception {
        String nombre = txtNombreLigaActivar.getText();
        try {
            String mensaje = mundialGestor.cambiarEstadoLiga(nombre);
            mostrarMensajeConfirmacion(mensaje);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @FXML
    private String agregarEquipoAGrupo(ActionEvent event){

        int anio = Integer.parseInt(txtAñoEquipoGrupo.getText());
        int codigoGrupo = Integer.parseInt(txtCodigoGrupoEquipo.getText());
        String codigoEquipo = txtCodigoEquipoGrupo.getText();

        try {
            String mensaje = grupoGestor.agregarEquipoAGrupo(anio, codigoGrupo,codigoEquipo);
            mostrarMensajeConfirmacion(mensaje);

            txtNombreLiga.clear();
            txtFechaLiga.clear();
            txtAñoMundialLiga.clear();
            txtEstadoLiga.clear();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }





    private void mostrarMensajeConfirmacion(String mensaje){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, mensaje);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    //CODIGO PARA IMPLEMENTAR ENTREGA FINAL
    /**
     public void cargarUsuario(){
     Persona usuario = (Persona)tblPersonas.getSelectionModel().getSelectedItem();
     if(usuario !=null){
     txtCedula.setText(""+usuario.getCedula()+"");
     txtNombre.setText(usuario.getNombre());
     txtCorreo.setText(usuario.getCorreo());
     txtPassword.setText(usuario.getPassword());
     }
     }

     public void registrarUsuario() throws Exception {
     mensaje = gestor.registrarPersona(Integer.parseInt(txtCedula.getText()),txtNombre.getText(),txtCorreo.getText(),txtPassword.getText());
     cargarListaUsuarios();
     mostrarMensaje(mensaje);
     }

     public void modificarUsuario() throws Exception {
     mensaje = gestor.modificarPersona(Integer.parseInt(txtCedula.getText()),txtNombre.getText(),txtCorreo.getText(),txtPassword.getText());
     cargarListaUsuarios();
     mostrarMensaje(mensaje);
     }

     public void eliminarUsuario() throws Exception {
     mensaje = gestor.eliminarPersona(Integer.parseInt(txtCedula.getText()));
     cargarListaUsuarios();
     mostrarMensaje(mensaje);
     }
     */

    /**
     @FXML
     private void registrarAdmin(ActionEvent event){
     seleccion = "registroAdmin";
     cambiarEscena(seleccion, event);
     System.out.println(seleccion);

     }
     @FXML
     private void registrarJugador(ActionEvent event){
     seleccion = "registroJugador";
     cambiarEscena(seleccion, event);
     System.out.println(seleccion);

     }


     @FXML
     private void cargarListaUsuarios() throws Exception{

     }

     */
}



