package cr.ac.ucenfotec.bl.entities.Administrador;

import cr.ac.ucenfotec.bl.entities.Persona;

import java.util.Objects;

/**
 * @author Guillermo Vargas
 * @version 1
 * @since 09-07-2022
 *
 * Esta clase se encarga de crear los objetos de tipo Admin
 * y gestionar las propiedades en el sistema
 */

public class Administrador extends Persona {

    /**
     * Esta es la sección de atributos privados de la clase Admin.
     */
    private String direccion;

    /**
     * Este es el contructor por defecto, no recibe parametros
     */
    public Administrador() {
    }

    /**
     * Este es el constructor que recibe parametros
     * @param identificacion es de tipo String y almacena la identificacion del Admin
     * @param nombre es de tipo String y almacena el nombre del admin
     * @param apellidos es de tipo String y almacena los apellidos del admin
     * @param correoElectronico es de tipo String y almacena el correo admin
     * @param direccion es de tipo String y almancena la direccion del admin
     * @param nombreUsuario es de tipo String y almancena el usuario del admin
     * @param contrasena es de tipo String y almancena la contrasena del admin
     */

    public Administrador(String identificacion, String nombre, String apellidos, String correoElectronico, String nombreUsuario, String contrasena, String direccion) {
        super(identificacion, nombre, apellidos, correoElectronico, nombreUsuario, contrasena);
        this.direccion = direccion;
    }

    /**
     * Esta es la sección de métodos de acceso
     * Aquí estan todos los get y set
     */



    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



    /**
     * Este método devuelve el estado de objeto en un momento especifico del tiempo
     * @return el estado del cliente en formato String
     */


    @Override
    public String toString() {
        return "Administrador{" +
                super.toString() +
                "direccion='" + direccion + '\'';
    }


}
