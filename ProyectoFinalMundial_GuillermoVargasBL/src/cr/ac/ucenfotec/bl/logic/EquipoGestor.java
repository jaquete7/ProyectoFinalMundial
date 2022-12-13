package cr.ac.ucenfotec.bl.logic;
import cr.ac.ucenfotec.bl.entities.Equipo.Equipo;
import cr.ac.ucenfotec.bl.entities.Equipo.IEquipoDAO;

import cr.ac.ucenfotec.dao.DAOFactory;

import java.net.URL;
import java.util.ArrayList;

public class EquipoGestor {
    private DAOFactory factory;
    private IEquipoDAO datos;



    public EquipoGestor(){
        factory = DAOFactory.getDAOFactory();
        datos = factory.getIEquipoDao();
    }

    public String registrarEquipo(String codigo, String nombrePais, int ranking, String bandera) throws Exception{
        Equipo equipo = new Equipo(codigo, nombrePais, ranking, bandera);
        return datos.registrarEquipo(equipo);
    }

    public ArrayList<String> listarEquipos() throws Exception{
        ArrayList<String> listaEquipos = new ArrayList<>();

        for (Equipo equipoTemp:datos.listarEquipos()) {
            listaEquipos.add(equipoTemp.toString());
        }
        return listaEquipos;
    }

    public ArrayList<Equipo> listarEquiposObjeto() throws Exception{
        ArrayList<Equipo> listaEquipos = new ArrayList<>();

        for (Equipo equipoTemp:datos.listarEquipos()) {
            listaEquipos.add(equipoTemp);
        }
        return listaEquipos;
    }
}
