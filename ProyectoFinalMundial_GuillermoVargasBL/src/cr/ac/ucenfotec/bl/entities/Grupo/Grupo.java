package cr.ac.ucenfotec.bl.entities.Grupo;

import cr.ac.ucenfotec.bl.entities.Equipo.Equipo;
import cr.ac.ucenfotec.bl.entities.Liga.Liga;

import java.util.ArrayList;

/**
 * @author Guillermo Vargas
 * @version 1
 * @since 09-07-2022
 *
 * Esta clase se encarga de crear los objetos de tipo Grupo
 * y gestionar las propiedades en el sistema
 */
public class Grupo {
    /**
     * Esta es la sección de atributos privados de la clase Grupo.
     */
    private int codigo;
    private String nombre;
    private static ArrayList<Equipo> listaEquipos;

    /**
     * Este es el contructor por defecto, no recibe parametros
     */
    public Grupo() {
    }

    /**
     * Constructor que recibe parametros
     * @param codigo es de tipo Int y almacena el codigo del Grupo
     * @param nombre es de tipo String y almacena el nombre del Grupo
     */

    public Grupo(int codigo, String nombre) {
        listaEquipos = new ArrayList<Equipo>(4);
        this.codigo = codigo;
        this.nombre = nombre;
    }

    /**
     * Esta es la sección de métodos de acceso
     * Aquí estan todos los get y set
     */
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static ArrayList<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public static void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        Grupo.listaEquipos = listaEquipos;
    }

    /**
     * Este método agrega el Equipo al Grupo
     */
    public void agregarEquipo(Equipo equipo) {
        listaEquipos.add(equipo);
    }




    /**
     * Este método devuelve el estado de objeto en un momento especifico del tiempo
     * @return el estado del cliente en formato String
     */


    public String toString() {
        return
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", lista de quipos='" + listaEquipos.toString() + '\'' +
                '}';
    }


    /**
     * Este método valida si dos objetos son iguales de acuerdo a un parametro o varios.
     * @return True or False.
     */


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grupo grupo = (Grupo) o;
        return codigo == grupo.codigo;
    }


}
