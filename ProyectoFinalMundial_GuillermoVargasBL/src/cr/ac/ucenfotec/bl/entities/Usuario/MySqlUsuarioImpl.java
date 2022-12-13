package cr.ac.ucenfotec.bl.entities.Usuario;


import cr.ac.ucenfotec.bl.entities.Administrador.Administrador;
import cr.ac.ucenfotec.bl.entities.Liga.Liga;
import cr.ac.ucenfotec.dl.bd.Conector;
import cr.ac.ucenfotec.util.Utils;

import java.sql.ResultSet;
import java.util.ArrayList;


public class MySqlUsuarioImpl implements IUsuarioDAO {
    private String sqlQuery;

    public String registrarUsuario(Usuario usuario) throws Exception {
        sqlQuery="INSERT INTO usuario VALUES('"+usuario.getIdentificacion()+"', '"+usuario.getNombre()+"', '"+usuario.getApellidos()+"'," +
                " '"+usuario.getCorreoElectronico()+"','"+usuario.getNombreUsuario()+"','"+usuario.getContrasena()+"'," +
                " '"+usuario.getAvatar()+"', '"+usuario.getEquipoFavorito()+"', "+100+")";
        Conector.getConnector().ejecutarSQL(sqlQuery);
        return "El Usuario fue registrado exitosamente!";
    }

    public Usuario buscarUsuario(Usuario usuario) throws Exception {
        sqlQuery = "SELECT nombreUsuario, contrasena  FROM usuario;";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sqlQuery);
        ArrayList<Usuario> lista = new ArrayList<>();

        while (rs.next()) {
            Usuario usuariotemp = new Usuario();
            usuariotemp.setNombreUsuario(rs.getString("nombreUsuario"));
            usuariotemp.setContrasena(rs.getString("contrasena"));

            lista.add(usuariotemp);
        }

        for (Usuario usuariotemp : lista) {
            if( usuariotemp.getNombreUsuario().equals(usuario.getNombreUsuario()) &&
                    usuariotemp.getContrasena().equals(usuario.getContrasena())){
                return usuariotemp;
            }
        }
        return null;

    }


    public ArrayList<Usuario> listarUsuarios() throws Exception {
        sqlQuery = "SELECT * FROM usuario;";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sqlQuery);
        ArrayList<Usuario> lista = new ArrayList<>();


        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setIdentificacion(rs.getString("IDENTIFICACION"));
            usuario.setNombre(rs.getString("NOMBRE"));
            usuario.setApellidos(rs.getString("APELLIDOS"));
            usuario.setCorreoElectronico(rs.getString("CORREOELECTRONICO"));
            usuario.setNombreUsuario(rs.getString("NOMBREUSUARIO"));
            usuario.setContrasena(rs.getString("CONTRASENA"));
            usuario.setAvatar(rs.getString("AVATAR"));
            usuario.setEquipoFavorito(rs.getString("EQUIPOFAVORITO"));
            lista.add(usuario);
        }


        return lista;
    }

    public boolean validarLiga(String nombreLiga) throws Exception {
        sqlQuery = "SELECT * FROM liga WHERE Nombre = '"+nombreLiga+"';";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sqlQuery);

        while (rs.next()) {

            Liga ligatemp = new Liga();
            ligatemp.setEstado(rs.getString("Estado"));

            if( ligatemp.getEstado().equals("Activo")){

                return true;
            } else{

                return false;
            }
        }

        return false;
    }

    public String registrarUsuarioALiga(String nombreLiga, String idUsuario) throws Exception {
        try {

            sqlQuery = "INSERT INTO usuarioxliga VALUES('"+nombreLiga+"', '"+idUsuario+"')";
            Conector.getConnector().ejecutarSQL(sqlQuery);

            return "El jugador fue agregado de manera exitosa!";

        }catch(Exception e){
            Utils.getLogger().severe("Error grave al agregar Jugador: " + e.getMessage());
            return "Error al tratar de agregar Jugador a liga";
        }
    }

    @Override
    public int buscarPuntaje(String idJugador) throws Exception {
        int puntaje = 0;

        try {
            sqlQuery = "SELECT puntos FROM usuario WHERE nombreUsuario = '"+idJugador+"';";
            ResultSet rs = Conector.getConnector().ejecutarQuery(sqlQuery);

            while (rs.next()) {

                puntaje = rs.getInt("puntos");
                return puntaje;

            }


        }catch(Exception e){
            Utils.getLogger().severe("Error grave al obtener puntos: " + e.getMessage());

        }
        return puntaje;

    }
}
