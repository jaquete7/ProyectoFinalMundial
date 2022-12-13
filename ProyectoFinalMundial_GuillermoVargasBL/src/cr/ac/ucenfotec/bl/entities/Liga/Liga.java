package cr.ac.ucenfotec.bl.entities.Liga;

import cr.ac.ucenfotec.bl.entities.Equipo.Equipo;
import cr.ac.ucenfotec.bl.entities.Usuario.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * @author Guillermo Vargas
 * @version 1
 * @since 09-07-2022
 *
 * Esta clase se encarga de crear los objetos de tipo Liga
 * y gestionar las propiedades en el sistema
 */

public class Liga {

    /**
     * Esta es la sección de atributos privados de la clase Liga.
     */

    private String nombre;
    private static ArrayList<Usuario> listaParticipantes;
    private String fechaCreacion;
    private int mundialPerteneciente;
    private String estado;


    /**
     * Este es el contructor por defecto, no recibe parametros
     */

    public Liga() {
    }

    /**
     * Constructor que recibe parametros
     * @param nombre es de tipo String y almacena el nombre de la liga
     * @param fechaCreacion es de tipo String y almacena la fecha de creacion de la liga
     * @param mundialPerteneciente es de tipo int y almacena el mundial al que pertenece la liga
     * @param estado es de tipo String y almacena el estado de la liga, ya sea activa o inactiva
     */

    public Liga(String nombre, String fechaCreacion, int mundialPerteneciente, String estado) {
        listaParticipantes = new ArrayList<Usuario>();
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.mundialPerteneciente = mundialPerteneciente;
        this.estado = estado;
    }

    /**
     * Esta es la sección de métodos de acceso
     * Aquí estan todos los get y set
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static ArrayList<Usuario> getListaParticipantes() {
        return listaParticipantes;
    }

    public static void setListaParticipantes(ArrayList<Usuario> listaParticipantes) {
        Liga.listaParticipantes = listaParticipantes;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getMundialPerteneciente() {
        return mundialPerteneciente;
    }

    public void setMundialPerteneciente(int mundialPerteneciente) {
        this.mundialPerteneciente = mundialPerteneciente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }



    /**
     * Este método agrega el Usuario a Liga
     */
    public void agregarUsuario(Usuario usuario) {
        listaParticipantes.add(usuario);
    }


    /**
     * Este método devuelve el estado de objeto en un momento especifico del tiempo
     * @return el estado del cliente en formato String
     */

    public String toString() {
        return "Liga{" +
                "nombre='" + nombre + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", mundialPerteneciente='" + mundialPerteneciente + '\'' +
                ", estado='" + estado + '\'' +
                ", ListaParticipantes='" + listaParticipantes.toString() + '\'' +
                '}';
    }

    /**
     * Este método valida si dos objetos son iguales de acuerdo a un parametro o varios.
     * @return True or False.
     */

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Liga liga = (Liga) o;
        return Objects.equals(nombre, liga.nombre);
    }



}
