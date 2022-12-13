package cr.ac.ucenfotec.bl.entities.Equipo;

import java.util.ArrayList;


public interface IEquipoDAO {
    public String registrarEquipo(Equipo equipo) throws Exception;
    public ArrayList<Equipo> listarEquipos() throws Exception;
}
