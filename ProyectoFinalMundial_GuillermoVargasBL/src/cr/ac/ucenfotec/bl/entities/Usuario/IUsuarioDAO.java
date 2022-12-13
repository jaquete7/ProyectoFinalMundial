package cr.ac.ucenfotec.bl.entities.Usuario;

import cr.ac.ucenfotec.bl.entities.Administrador.Administrador;

import java.util.ArrayList;


public interface IUsuarioDAO {
    public String registrarUsuario(Usuario usuario) throws Exception;
    public Usuario buscarUsuario(Usuario usuario) throws Exception;
    public ArrayList<Usuario> listarUsuarios() throws Exception;
    public boolean validarLiga(String nombreLiga) throws Exception;

    public String registrarUsuarioALiga(String nombreLiga, String idJugador) throws Exception;

    int buscarPuntaje(String idJugador) throws Exception;;
}