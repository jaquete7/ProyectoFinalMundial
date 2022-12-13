package cr.ac.ucenfotec.bl.entities.Equipo;

import java.net.URL;
import java.util.Objects;


/**
 * @author Guillermo Vargas
 * @version 1
 * @since 09-07-2022
 *
 * Esta clase se encarga de crear los objetos de tipo Equipo
 * y gestionar las propiedades en el sistema
 */
public class Equipo {

    /**
     * Esta es la sección de atributos privados de la clase Liga.
     */
    private String codigo;
    private String nombrePais;
    private int ranking;
    private String bandera;


    /**
     * Este es el contructor por defecto, no recibe parametros
     */
    public Equipo() {
    }

    /**
     * Constructor que recibe parametros
     * @param codigo es de tipo String y almacena el codigo del Equipo
     * @param nombrePais es de tipo String y almacena el nombre del Equipo
     * @param ranking es de tipo Int y almacena el ranking del Equipo
     * @param bandera es de tipo URL y almacena la bandera del Equipo
     */
    public Equipo(String codigo, String nombrePais, int ranking, String bandera) {
        this.codigo = codigo;
        this.nombrePais = nombrePais;
        this.ranking = ranking;
        this.bandera = bandera;
    }


    /**
     * Esta es la sección de métodos de acceso
     * Aquí estan todos los get y set
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    /**
     * Este método devuelve el estado de objeto en un momento especifico del tiempo
     * @return el estado del cliente en formato String
     */


    public String toString() {
        return
                "codigo='" + codigo + '\'' +
                ", nombrePais='" + nombrePais + '\'' +
                ", ranking=" + ranking +
                ", bandera=" + bandera +
                '}';
    }

    /**
     * Este método valida si dos objetos son iguales de acuerdo a un parametro o varios.
     * @return True or False.
     */


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return Objects.equals(codigo, equipo.codigo);
    }


}
