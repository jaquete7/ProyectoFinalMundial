package cr.ac.ucenfotec.bl.entities.Mundial;
import cr.ac.ucenfotec.bl.entities.Grupo.Grupo;
import cr.ac.ucenfotec.bl.entities.Liga.Liga;

import java.util.ArrayList;


public interface IMundialDAO {
    public String registrarMundial(Mundial mundial) throws Exception;
    public ArrayList<Mundial> listarMundiales() throws Exception;
    public String cambiarEstadoMundial(int ano) throws Exception;
    public String agregarGrupoAMundial(Grupo grupo, int anioMundial) throws Exception;

    public ArrayList<Grupo> listarGrupos(int anioMundial) throws Exception;;
    public String agregarLigaAMundial(Liga liga) throws Exception;

    public ArrayList<Liga> listarLigas(int anioMundial) throws Exception;;

    public String cambiarEstadoLiga(String nombre) throws Exception;
}
