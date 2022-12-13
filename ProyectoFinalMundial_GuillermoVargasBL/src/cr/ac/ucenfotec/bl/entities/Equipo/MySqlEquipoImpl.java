package cr.ac.ucenfotec.bl.entities.Equipo;

import cr.ac.ucenfotec.dl.bd.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;


public class MySqlEquipoImpl implements IEquipoDAO {

    private String sqlQuery;

    public String registrarEquipo(Equipo equipo) throws Exception {
        sqlQuery="INSERT INTO equipo VALUES('"+equipo.getCodigo()+"', '"+equipo.getNombrePais()+"', "+equipo.getRanking()+", '"+equipo.getBandera()+"')";
        Conector.getConnector().ejecutarSQL(sqlQuery);
        return "El Equipo fue registrado exitosamente!";
    }


    public ArrayList<Equipo> listarEquipos() throws Exception {
        sqlQuery = "SELECT * FROM equipo";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sqlQuery);
        ArrayList<Equipo> lista = new ArrayList<>();

        while(rs.next()){
            Equipo equipo = new Equipo();
            equipo.setCodigo(rs.getString("codigoEquipo"));
            equipo.setNombrePais(rs.getString("nombrePais"));
            equipo.setRanking(rs.getInt("ranking"));
            equipo.setBandera(rs.getString("bandera"));
            lista.add(equipo);
        }
        return lista;
    }
}
