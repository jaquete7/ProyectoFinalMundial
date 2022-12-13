package cr.ac.ucenfotec.bl.entities.Administrador;

import cr.ac.ucenfotec.dl.bd.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.io.PrintStream;

public class MySqlAdministradorImpl implements IAdministradorDAO {

    private String sqlQuery;
    private PrintStream out = System.out;

    public String registrarAdministrador(Administrador administrador) throws Exception {
        sqlQuery="INSERT INTO administrador VALUES('"+administrador.getIdentificacion()+"', '"+administrador.getNombre()+"'," +
                " '"+administrador.getApellidos()+"', '"+administrador.getCorreoElectronico()+"','"+administrador.getNombreUsuario()+"'," +
                "'"+administrador.getContrasena()+"', '"+administrador.getDireccion()+"')";
        Conector.getConnector().ejecutarSQL(sqlQuery);
        return "El Administrador fue registrado exitosamente!";
    }



    public Administrador buscarAdministrador(Administrador administrador) throws Exception {
        sqlQuery = "SELECT nombreUsuario, contrasena  FROM administrador;";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sqlQuery);
        ArrayList<Administrador> lista = new ArrayList<>();

         while (rs.next()) {
             Administrador admintemp = new Administrador();
             admintemp.setNombreUsuario(rs.getString("nombreUsuario"));
             admintemp.setContrasena(rs.getString("contrasena"));

             lista.add(admintemp);
         }
        //out.println(administrador.getNombreUsuario());
        //out.println(administrador.getContrasena());
        for (Administrador adminTemp : lista) {
            //out.println(adminTemp.getNombreUsuario());
            //out.println(adminTemp.getContrasena());

            if( adminTemp.getNombreUsuario().equals(administrador.getNombreUsuario()) &&
                    adminTemp.getContrasena().equals(administrador.getContrasena())){
                return adminTemp;
            }
        }
        return null;

    }


    public boolean validarAdminRegistrado() throws Exception {
       /** sqlQuery = "SELECT EXISTS (SELECT 1 FROM administrador) AS 'Output';";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sqlQuery);
        int respuesta = rs.getInt("Output");
        if(respuesta == 1)
            return true;
        else
            return false;
        */
        sqlQuery = "SELECT * from administrador;";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sqlQuery);
        //System.out.print(rs.next());

        if (rs.next() == true){
            return  true;
        } else{
            return  false;
        }


    }


    public ArrayList<Administrador> listaAdministradores() throws Exception {
        sqlQuery = "SELECT * FROM administrador";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sqlQuery);
        ArrayList<Administrador> lista = new ArrayList<>();

       /** while (rs.next()) {
            Administrador administrador = new Administrador();
            Administrador.setId(rs.getInt("IDAdministrador"));
            Administrador.setNombre(rs.getString("NOMBRE"));
            Administrador.setExperiencia(rs.getInt("EXPERIENCIA"));
            Administrador.setEspecialidad(rs.getString("ESPECIALIDAD"));
            lista.add(administrador);
        }
        */

        return lista;

    }
}
