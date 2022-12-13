package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.Administrador.Administrador;
import cr.ac.ucenfotec.bl.entities.Administrador.IAdministradorDAO;
import cr.ac.ucenfotec.bl.entities.Administrador.MySqlAdministradorImpl;
//import cr.ac.ucenfotec.bl.entities.Administrador.TxtAdministradorImpl;

import cr.ac.ucenfotec.bl.entities.Persona;
import cr.ac.ucenfotec.dao.DAOFactory;

import java.util.ArrayList;


public class AdministradorGestor {

    private DAOFactory factory;
    private IAdministradorDAO datos;

    public AdministradorGestor(){
        factory = DAOFactory.getDAOFactory();
        datos = factory.getIAdministradorDAO();
    }

    public String registrarAdministrador(String identificacion, String  nombre, String apellidos, String correoElectronico, String usuario, String contrasena, String direccion) throws Exception{
        Administrador administrador = new Administrador(identificacion,nombre,apellidos,correoElectronico,usuario,contrasena,direccion);
        return datos.registrarAdministrador(administrador);
    }

    public Administrador buscarAdministrador(String correo, String password) throws Exception{
        Administrador administrador = new Administrador();
        administrador.setNombreUsuario(correo);
        administrador.setContrasena(password);
        return datos.buscarAdministrador(administrador);
    }

    public boolean validarAdminRegistrado() throws Exception{

        return datos.validarAdminRegistrado();
    }


/**
    public ArrayList<String> listarAdministradores() throws Exception{
        ArrayList<String> listaAdministradores = new ArrayList<>();
        for (Administrador administradortemp:datos.listaAdministradores()) {
            listaAdministradores.add(administradortemp.toString());
        }
        return listaAdministradores;
    }

 */

}
