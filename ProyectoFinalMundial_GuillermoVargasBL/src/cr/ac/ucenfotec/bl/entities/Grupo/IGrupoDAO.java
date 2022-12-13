package cr.ac.ucenfotec.bl.entities.Grupo;
import cr.ac.ucenfotec.bl.entities.Grupo.Grupo;
import cr.ac.ucenfotec.bl.entities.Liga.Liga;

import java.util.ArrayList;


public interface IGrupoDAO {

    public String agregarEquipoAGrupo(int anio, int codigoGrupo, String codigoEquipo) throws Exception;


}