package cr.ac.ucenfotec.bl.entities.Grupo;
import cr.ac.ucenfotec.bl.entities.Equipo.Equipo;
import cr.ac.ucenfotec.bl.entities.Grupo.Grupo;
import cr.ac.ucenfotec.bl.entities.Liga.Liga;
import cr.ac.ucenfotec.dl.bd.Conector;
import cr.ac.ucenfotec.util.Utils;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlGrupoImpl implements IGrupoDAO{
    private String sqlQuery;
    @Override
    public String agregarEquipoAGrupo(int anio, int codigoGrupo, String codigoEquipo) throws Exception {
        try {
            String auto = "default";


            sqlQuery = "INSERT INTO equipoxgrupo VALUES("+auto+","+anio+","+codigoGrupo+",'"+codigoEquipo+"')";
            Conector.getConnector().ejecutarSQL(sqlQuery);

            return "El equipo fue agregado de manera exitosa!";

        }catch(Exception e){
            Utils.getLogger().severe("Error grave al agregar Equipo: " + e.getMessage());
            return "Error al tratar de agregar el Equipo";
        }
    }
}
