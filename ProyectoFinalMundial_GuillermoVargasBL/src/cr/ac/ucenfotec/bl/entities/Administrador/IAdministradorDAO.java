package cr.ac.ucenfotec.bl.entities.Administrador;

import java.util.ArrayList;

public interface IAdministradorDAO {
    public String registrarAdministrador(Administrador administrador) throws Exception;
    public Administrador buscarAdministrador(Administrador administrador) throws Exception;
    public boolean validarAdminRegistrado() throws Exception;
    public ArrayList<Administrador> listaAdministradores() throws Exception;
}
