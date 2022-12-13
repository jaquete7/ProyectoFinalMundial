package cr.ac.ucenfotec.bl.entities.Prediccion;
import cr.ac.ucenfotec.bl.entities.Usuario.Usuario;
import cr.ac.ucenfotec.bl.entities.Grupo.Grupo;
import cr.ac.ucenfotec.bl.entities.Liga.Liga;


/**
 * @author Guillermo Vargas
 * @version 1
 * @since 10-08-2022
 *
 * Esta clase se encarga de crear los objetos de tipo Prediccion
 * y gestionar las propiedades en el sistema
 */

public class Prediccion {
    /**
     * Esta es la sección de atributos privados de la clase Prediccion.
     */
    private String identificacionUsuario;
    private String nombreLiga;
    private int idPartido;
    private int prediccionEquipoUno;
    private int prediccionEquipoDos;
    private int puntajeObtenido;


    /**
     * Este es el contructor por defecto, no recibe parametros
     */
    public Prediccion() {
    }

    /**
     * Constructor que recibe parametros
     * @param identificacionUsuario es de tipo String  y almacena la identificacion del Usuario l que pertenece
     * @param nombreLiga es de tipo String y almacena el nombre de la Liga a la que pertenece
     * @param idPartido es de tipo String y almacena el id exclusivo del partido
     * @param prediccionEquipoUno es de tipo int y almacena la prediccion para el marcador del equipo 1
     * @param prediccionEquipoDos es de tipo int y almacena la prediccion para el marcador del equipo 2
     * @param puntajeObtenido es de tipo int y almacena el puntaje obtenido por el ususario para esta prediccion de partido.
     */

    public Prediccion(String identificacionUsuario, String nombreLiga, int idPartido, int prediccionEquipoUno, int prediccionEquipoDos, int puntajeObtenido) {
        this.identificacionUsuario = identificacionUsuario;
        this.nombreLiga = nombreLiga;
        this.idPartido = idPartido;
        this.prediccionEquipoUno = prediccionEquipoUno;
        this.prediccionEquipoDos = prediccionEquipoDos;
        this.puntajeObtenido = puntajeObtenido;
    }

    /**
     * Esta es la sección de métodos de acceso
     * Aquí estan todos los get y set
     */

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public String getNombreLiga() {
        return nombreLiga;
    }

    public void setNombreLiga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public int getPrediccionEquipoUno() {
        return prediccionEquipoUno;
    }

    public void setPrediccionEquipoUno(int prediccionEquipoUno) {
        this.prediccionEquipoUno = prediccionEquipoUno;
    }

    public int getPrediccionEquipoDos() {
        return prediccionEquipoDos;
    }

    public void setPrediccionEquipoDos(int prediccionEquipoDos) {
        this.prediccionEquipoDos = prediccionEquipoDos;
    }

    public int getPuntajeObtenido() {
        return puntajeObtenido;
    }

    public void setPuntajeObtenido(int puntajeObtenido) {
        this.puntajeObtenido = puntajeObtenido;
    }

    /**
     * Este método devuelve el estado de objeto en un momento especifico del tiempo
     * @return el estado del Prediccion en formato String
     */


    @Override
    public String toString() {
        return "Prediccion{" +
                "identificacionUsuario='" + identificacionUsuario + '\'' +
                ", nombreLiga='" + nombreLiga + '\'' +
                ", idPartido=" + idPartido +
                ", prediccionEquipoUno=" + prediccionEquipoUno +
                ", prediccionEquipoDos=" + prediccionEquipoDos +
                ", puntajeObtenido=" + puntajeObtenido +
                '}';
    }

    /**
     * Este método valida si dos objetos son iguales de acuerdo a un parametro o varios.
     * @return True or False.
     */


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prediccion that = (Prediccion) o;
        return idPartido == that.idPartido && identificacionUsuario.equals(that.identificacionUsuario);
    }

}