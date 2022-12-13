package cr.ac.ucenfotec.bl.entities.Mundial;

import cr.ac.ucenfotec.bl.entities.Equipo.Equipo;
import cr.ac.ucenfotec.bl.entities.Grupo.Grupo;
import cr.ac.ucenfotec.bl.entities.Liga.Liga;
import cr.ac.ucenfotec.dl.bd.Conector;
import cr.ac.ucenfotec.util.Utils;
import java.sql.ResultSet;
import java.util.ArrayList;



public class MySqlMundialImpl implements IMundialDAO {
    private String sqlQuery;
    @Override
    public String registrarMundial(Mundial mundial) throws Exception {
        sqlQuery="INSERT INTO mundial VALUES('"+mundial.getAno()+"', '"+mundial.getPaisOrganizador()+"', '"+mundial.getEstado()+"')";
        Conector.getConnector().ejecutarSQL(sqlQuery);
        return "El Mundial fue registrado exitosamente!";
    }

    @Override
    public ArrayList<Mundial> listarMundiales() throws Exception {
        sqlQuery = "SELECT * FROM mundial";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sqlQuery);
        ArrayList<Mundial> lista = new ArrayList<>();

        while(rs.next()){
            Mundial mundial = new Mundial();
            mundial.setAno(rs.getInt("Año"));
            mundial.setPaisOrganizador(rs.getString("Pais Organizador"));
            mundial.setEstado(rs.getString("Estado"));

            lista.add(mundial);
        }
        return lista;
    }

    @Override
    public String cambiarEstadoMundial(int ano) throws Exception {
        sqlQuery="UPDATE mundial SET\n" +
                "Estado = IF(Estado='Activo', 'Inactivo', IF(Estado='Inactivo', 'Activo', Estado))\n" +
                "WHERE Año = '"+ano+"'";
        Conector.getConnector().ejecutarSQL(sqlQuery);
        return "El Estado del Mundial fue  actualizado exitosamente!";
    }

    @Override
    public String agregarGrupoAMundial(Grupo grupo, int anioMundial) throws Exception {
        try {
            sqlQuery = "INSERT INTO grupo VALUES("+grupo.getCodigo()+",'"+grupo.getNombre()+"','"+anioMundial+"')";
            Conector.getConnector().ejecutarSQL(sqlQuery);

            return "El grupo fue creado y agregado de manera exitosa!";

        }catch(Exception e){
            Utils.getLogger().severe("Error grave al crear Grupo: " + e.getMessage());
            return "Error al tratar de crear el grupo";
        }

    }

    public ArrayList<Grupo> listarGrupos(int anioMundial) {
        try {
            sqlQuery="SELECT * FROM grupo WHERE Mundial = '"+anioMundial+"'";
            ResultSet rs = Conector.getConnector().ejecutarQuery(sqlQuery);
            ArrayList<Grupo> listaGrupos = new ArrayList<>();
            while(rs.next()){
                Grupo grupo = new Grupo(rs.getInt("Codigo"),rs.getString("Nombre"));
                listaGrupos.add(grupo);
            }
            return listaGrupos;

        }catch(Exception e){
            Utils.getLogger().severe("Error grave: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public String agregarLigaAMundial(Liga liga) throws Exception {
        try {
            sqlQuery = "INSERT INTO liga VALUES('"+liga.getNombre()+"','"+liga.getFechaCreacion()+"',"+liga.getMundialPerteneciente()+",'"+liga.getEstado()+"')";
            Conector.getConnector().ejecutarSQL(sqlQuery);

            return "La liga fue creada y agregada de manera exitosa!";

        }catch(Exception e){
            Utils.getLogger().severe("Error grave al crear Liga: " + e.getMessage());
            return "Error al tratar de crear la Liga";
        }
    }

    public ArrayList<Liga> listarLigas(int anioMundial) {
        try {
            sqlQuery="SELECT * FROM liga WHERE Mundial = "+anioMundial+"";
            ResultSet rs = Conector.getConnector().ejecutarQuery(sqlQuery);
            ArrayList<Liga> listaLigas = new ArrayList<>();
            while(rs.next()){
                Liga liga = new Liga(rs.getString("Nombre"),rs.getString("Fecha Creacion"), rs.getInt("Mundial"), rs.getString("Estado"));
                System.out.print(liga.toString());
                listaLigas.add(liga);
            }
            return listaLigas;

        }catch(Exception e){
            Utils.getLogger().severe("Error grave: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public String cambiarEstadoLiga(String nombre) throws Exception {
        sqlQuery="UPDATE liga SET\n" +
                "Estado = IF(Estado='Activo', 'Inactivo', IF(Estado='Inactivo', 'Activo', Estado))\n" +
                "WHERE Nombre = '"+nombre+"'";
        Conector.getConnector().ejecutarSQL(sqlQuery);
        return "El Estado de la liga fue  actualizado exitosamente!";
    }


}
