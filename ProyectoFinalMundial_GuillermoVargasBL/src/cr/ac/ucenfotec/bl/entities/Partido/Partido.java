package cr.ac.ucenfotec.bl.entities.Partido;
import cr.ac.ucenfotec.bl.entities.Grupo.Grupo;

/**
 * @author Guillermo Vargas
 * @version 1
 * @since 10-08-2022
 *
 * Esta clase se encarga de crear los objetos de tipo Partido
 * y gestionar las propiedades en el sistema
 */

public class Partido {
    /**
     * Esta es la sección de atributos privados de la clase Partido.
     */
    private String idPartido;
    private String equipoUnoNombre;
    private String equipoUnoCodigo;
    private String equipoDosNombre;
    private String equipoDosCodigo;

    private int marcadorEquipoUno;
    private int marcadorEquipoDos;


    /**
     * Este es el contructor por defecto, no recibe parametros
     */
    public Partido() {
    }


    /**
     *  Constructor que recibe parametros
     * @param idPartido es de tipo String y almacena el id unico del partido
     * @param equipoUnoNombre es de tipo String y almacena el nombre del equipo 1
     * @param equipoUnoCodigo es de tipo String y almacena el codigo del equipo 1
     * @param equipoDosNombre es de tipo String y almacena el nombre del equipo 2
     * @param equipoDosCodigo es de tipo String y almacena el codigo del equipo 2
     * @param marcadorEquipoUno es de tipo int y almacena el marcador del equipo 1
     * @param marcadorEquipoDos es de tipo int y almacena el marcador del equipo 2
     */



    public Partido(String idPartido, String equipoUnoNombre, String equipoUnoCodigo, String equipoDosNombre, String equipoDosCodigo, int marcadorEquipoUno, int marcadorEquipoDos) {
        this.idPartido = idPartido;
        this.equipoUnoNombre = equipoUnoNombre;
        this.equipoUnoCodigo = equipoUnoCodigo;
        this.equipoDosNombre = equipoDosNombre;
        this.equipoDosCodigo = equipoDosCodigo;
        this.marcadorEquipoUno = marcadorEquipoUno;
        this.marcadorEquipoDos = marcadorEquipoDos;
    }

    /**
     * Esta es la sección de métodos de acceso
     * Aquí estan todos los get y set
     */

    public String getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(String idPartido) {
        this.idPartido = idPartido;
    }

    public String getEquipoUnoNombre() {
        return equipoUnoNombre;
    }

    public void setEquipoUnoNombre(String equipoUnoNombre) {
        this.equipoUnoNombre = equipoUnoNombre;
    }

    public String getEquipoUnoCodigo() {
        return equipoUnoCodigo;
    }

    public void setEquipoUnoCodigo(String equipoUnoCodigo) {
        this.equipoUnoCodigo = equipoUnoCodigo;
    }

    public String getEquipoDosNombre() {
        return equipoDosNombre;
    }

    public void setEquipoDosNombre(String equipoDosNombre) {
        this.equipoDosNombre = equipoDosNombre;
    }

    public String getEquipoDosCodigo() {
        return equipoDosCodigo;
    }

    public void setEquipoDosCodigo(String equipoDosCodigo) {
        this.equipoDosCodigo = equipoDosCodigo;
    }

    public int getMarcadorEquipoUno() {
        return marcadorEquipoUno;
    }

    public void setMarcadorEquipoUno(int marcadorEquipoUno) {
        this.marcadorEquipoUno = marcadorEquipoUno;
    }

    public int getMarcadorEquipoDos() {
        return marcadorEquipoDos;
    }

    public void setMarcadorEquipoDos(int marcadorEquipoDos) {
        this.marcadorEquipoDos = marcadorEquipoDos;
    }

    /**
     * Este método devuelve el estado de objeto en un momento especifico del tiempo
     * @return el estado del Partido en formato String
     */


    public String toString() {
        return "Partido{" +
                "idPartido='" + idPartido + '\'' +
                ", equipoUnoNombre='" + equipoUnoNombre + '\'' +
                ", equipoUnoCodigo='" + equipoUnoCodigo + '\'' +
                ", equipoDosNombre='" + equipoDosNombre + '\'' +
                ", equipoDosCodigo='" + equipoDosCodigo + '\'' +
                ", marcadorEquipoUno=" + marcadorEquipoUno +
                ", marcadorEquipoDos=" + marcadorEquipoDos +
                '}';
    }

    /**
     * Este método valida si dos objetos son iguales de acuerdo a un parametro o varios.
     * @return True or False.
     */

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partido partido = (Partido) o;
        return idPartido.equals(partido.idPartido);
    }

}
