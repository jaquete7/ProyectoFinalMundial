package cr.ac.ucenfotec.bl.logic;
import cr.ac.ucenfotec.bl.entities.Mundial.Mundial;
import cr.ac.ucenfotec.bl.entities.Mundial.IMundialDAO;
import cr.ac.ucenfotec.bl.entities.Grupo.Grupo;
import cr.ac.ucenfotec.bl.entities.Grupo.IGrupoDAO;
import cr.ac.ucenfotec.bl.entities.Liga.Liga;
import cr.ac.ucenfotec.bl.entities.Equipo.Equipo;



import cr.ac.ucenfotec.dao.DAOFactory;

import java.net.URL;
import java.util.ArrayList;

public class GrupoGestor {
    private DAOFactory factory;
    private IGrupoDAO datos;


    public GrupoGestor(){
        factory = DAOFactory.getDAOFactory();
        datos = factory.getIGrupoDao();
    }





    public String agregarEquipoAGrupo(int anio, int codigoGrupo, String codigoEquipo) throws Exception{

        datos.agregarEquipoAGrupo(anio,codigoGrupo,codigoEquipo);
        return "El equipo fue agregado exitosamente!";

    }







}
