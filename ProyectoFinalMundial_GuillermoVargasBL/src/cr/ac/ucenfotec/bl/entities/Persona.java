package cr.ac.ucenfotec.bl.entities;

import java.util.Objects;

/**
 * @author Guillermo Vargas
 * @version 1
 * @since 09-07-2022
 *
 * Esta clase se encarga de crear los objetos de tipo Admin
 * y gestionar las propiedades en el sistema
 */

public class Persona {

    /**
     * Esta es la sección de atributos privados de la clase Persona.
     */

    private String identificacion;
    private String nombre;
    private String apellidos;
    private String correoElectronico;

    private String nombreUsuario;
    private String contrasena;


    /**
     * Este es el contructor por defecto, no recibe parametros
     */
    public Persona() {
    }

    /**
     * Este es el constructor que recibe parametros
     * @param identificacion es de tipo String y almacena la identificacion de Persona
     * @param nombre es de tipo String y almacena el nombre de Persona
     * @param apellidos es de tipo String y almacena los apellidos de Persona
     * @param correoElectronico es de tipo String y almacena el correo Persona
     * @param nombreUsuario es de tipo String y almancena el usuario de Persona
     * @param contrasena es de tipo String y almancena la contrasena de Persona
     */

    public Persona(String identificacion, String nombre, String apellidos, String correoElectronico, String nombreUsuario, String contrasena) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    /**
     * Esta es la sección de métodos de acceso
     * Aquí estan todos los get y set
     */

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Este método devuelve el estado de objeto en un momento especifico del tiempo
     * @return el estado del cliente en formato String
     */


    public String toString() {
        return
                "identificacion='" + identificacion + '\'' +
                        ", nombre='" + nombre + '\'' +
                        ", apellidos='" + apellidos + '\'' +
                        ", correoElectronico='" + correoElectronico + '\'' +
                        ", usuario='" + nombreUsuario + '\'' +
                        ", contrasena='" + contrasena + '\'' +
                        ' ';
    }

    /**
     * Este método valida si dos objetos son iguales de acuerdo a un parametro o varios.
     * @return True or False.
     */


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return identificacion.equals(persona.identificacion);
    }

}

