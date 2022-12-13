package cr.ac.ucenfotec.bl.entities.Usuario;

import cr.ac.ucenfotec.bl.entities.Equipo.Equipo;
import cr.ac.ucenfotec.bl.entities.Persona;
import cr.ac.ucenfotec.bl.entities.Prediccion.Prediccion;

import java.util.ArrayList;
import java.net.URL;

/**
 * @author Guillermo Vargas
 * @version 1
 * @since 11-08-2022
 *
 * Esta clase se encarga de crear los objetos de tipo Usuario
 * y gestionar las propiedades en el sistema
 */

public class Usuario extends Persona {
    /**
     * Esta es la sección de atributos privados de la clase Usuario.
     */
    private String avatar;
    private String equipoFavorito;

    ArrayList<Usuario> listaUsuarios = new ArrayList<>();


    /**
     * Este es el contructor por defecto, no recibe parametros
     */

    public Usuario() {
    }

    /**
     * Constructor que recibe parametros
     * @param identificacion es de tipo String y almacena la identificacion del Usuario
     * @param nombre es de tipo String y almacena el nombre del Usuario
     * @param apellidos es de tipo String y almacena los apellidos del Usuario
     * @param correoElectronico es de tipo String y almacena el correo Usuario
     * @param avatar es de tipo URL y almacena el avatar del Usuario
     * @param nombreUsuario es de tipo String y almancena el usuario del Usuario
     * @param contrasena es de tipo String y almancena la contrasena del Usuario
     * @param equipoFavorito es de tipo String y almancena el equipo favorito del Usuario
     */


    public Usuario(String identificacion, String nombre, String apellidos, String correoElectronico, String nombreUsuario, String contrasena, String avatar, String equipoFavorito) {
        super(identificacion, nombre, apellidos, correoElectronico, nombreUsuario, contrasena);
        this.avatar = avatar;
        this.equipoFavorito = equipoFavorito;
    }

    /**
     * Esta es la sección de métodos de acceso
     * Aquí estan todos los get y set
     */



    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public String getEquipoFavorito() {
        return equipoFavorito;
    }

    public void setEquipoFavorito(String equipoFavorito) {
        this.equipoFavorito = equipoFavorito;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    /**
     * Este método devuelve el estado de objeto en un momento especifico del tiempo
     * @return el estado del cliente en formato String
     */


    @Override
    public String toString() {
        return "Usuario: " +
                super.toString() +
                "avatar=" + avatar +
                ", equipoFavorito=" + equipoFavorito;
    }



}
