package cr.ac.ucenfotec.bl.entities.Mundial;

import cr.ac.ucenfotec.bl.entities.Grupo.Grupo;
import cr.ac.ucenfotec.bl.entities.Liga.Liga;

import java.util.ArrayList;

/**
 * @author Guillermo Vargas
 * @version 1
 * @since 09-07-2022
 *
 * Esta clase se encarga de crear los objetos de tipo Mundial
 * y gestionar las propiedades en el sistema
 */

public class Mundial {


    /**
     * Esta es la sección de atributos privados de la clase Mundial.
     */
    private int ano;
    private static ArrayList<Grupo> listaGrupos;
    private static ArrayList<Liga> listaLigas;
    private String paisOrganizador;
    private String estado;


    /**
     * Este es el contructor por defecto, no recibe parametros
     */
    public Mundial() {
    }


    /**
     * Constructor que recibe parametros
     * @param ano es de tipo Int y almacena el anio del Mundial
     * @param paisOrganizador es de tipo String y almacena el pais organizador del Mundial
     * @param estado es de tipo String y almacena el estado del Mundial, ya sea activo o inactivo
     */
    public Mundial(int ano, String paisOrganizador, String estado) {
        listaGrupos = new ArrayList<Grupo>(8);
        listaLigas = new ArrayList<Liga>();
        this.ano = ano;
        this.paisOrganizador = paisOrganizador;
        this.estado = estado;
    }


    /**
     * Esta es la sección de métodos de acceso
     * Aquí estan todos los get y set
     */
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public static ArrayList<Grupo> getListaGrupos() {
        return listaGrupos;
    }

    public static void setListaGrupos(ArrayList<Grupo> listaGrupos) {
        Mundial.listaGrupos = listaGrupos;
    }

    public static ArrayList<Liga> getListaLigas() {
        return listaLigas;
    }

    public static void setListaLigas(ArrayList<Liga> listaLigas) {
        Mundial.listaLigas = listaLigas;
    }

    public String getPaisOrganizador() {
        return paisOrganizador;
    }

    public void setPaisOrganizador(String paisOrganizador) {
        this.paisOrganizador = paisOrganizador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado)  {
        this.estado = estado;
    }


    /**
     * Este método agrega la liga al Mundial
     */


    public void agregarLiga(Liga liga) {
        listaLigas.add(liga);
    }

    /**
     * Este método agrega el Grupo al Mundial
     */
    public void agregarGrupo(Grupo grupo) {
        listaGrupos.add(grupo);
    }



    /**
     * Este método devuelve el estado de objeto en un momento especifico del tiempo
     * @return el estado del cliente en formato String */


    public String toString() {
        return
                "ano=" + ano +
                ", paisOrganizador='" + paisOrganizador + '\'' +
                ", estado='" + estado + '\'' +
                ", Lista de Grupos ='" + listaGrupos.toString() + '\'' +
                ", Lista de Ligas ='" + listaLigas.toString() + '\'' +
                '}';
    }

    /**
     * Este método valida si dos objetos son iguales de acuerdo a un parametro o varios.
     * @return True or False.
     */

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mundial mundial = (Mundial) o;
        return ano == mundial.ano;
    }


}
