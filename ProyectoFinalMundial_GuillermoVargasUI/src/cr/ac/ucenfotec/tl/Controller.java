package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.logic.AdministradorGestor;
import cr.ac.ucenfotec.bl.logic.UsuarioGestor;
import cr.ac.ucenfotec.bl.logic.EquipoGestor;
import cr.ac.ucenfotec.ui.UI;

/**
* @author Guillermo Vargas
* @version 1
* @since 10-08-2022
*
* CONTROLADOR PARA USAR UI DE CONSOLA Y HACER RESPECTIVAS PRUEBAS!!

*/

public class Controller {

    private UI interaz;
    private AdministradorGestor administradorGestor;
    private UsuarioGestor usuarioGestor;
    private EquipoGestor equipoGestor;

    public Controller() {
        interaz = new UI();
        administradorGestor = new AdministradorGestor();
        usuarioGestor = new UsuarioGestor();
        equipoGestor = new EquipoGestor();
    }

    public void start() throws Exception {
        int opcion = -1;
        do {
            interaz.mostrarMenu();
            opcion = interaz.leerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 0);
    }

    public void procesarOpcion(int opcion) throws Exception {
        switch (opcion) {
            case 1:
                registrarAdministrador();
                break;
            case 2:
                registrarUsuario();
                break;
            case 3:
                listarUsuarios();
                break;
            case 4:
                registrarEquipo();
                break;
            case 5:
                listarEquipos();
                break;

            case 0:
                interaz.imprimirMensaje("Muchas gracias por su visita!");
                break;
            default:
                interaz.imprimirMensaje("Esta opción no existe!");
        }
    }

    public void registrarAdministrador() throws Exception {
        interaz.imprimirMensaje("Ingrese el numero de identificacion del Administador: ");
        String id = interaz.leerTexto();
        interaz.imprimirMensaje("Ingrese el nombre del Administador: ");
        String nombre = interaz.leerTexto();
        interaz.imprimirMensaje("Ingrese los apellidos del Administador: ");
        String apellidos = interaz.leerTexto();
        interaz.imprimirMensaje("Ingrese el correo electronico del Administador: ");
        String correo = interaz.leerTexto();
        interaz.imprimirMensaje("Ingrese el nombre de Usuario del Administador: ");
        String usuario = interaz.leerTexto();
        interaz.imprimirMensaje("Ingrese la contrasena del Administador: ");
        String contrasena = interaz.leerTexto();
        interaz.imprimirMensaje("Ingrese la direccion del Administador: ");
        String direccion = interaz.leerTexto();


        String mensaje = administradorGestor.registrarAdministrador(id, nombre, apellidos, correo, usuario, contrasena, direccion);
        interaz.imprimirMensaje(mensaje);
    }

    public void registrarUsuario() throws Exception {
        interaz.imprimirMensaje("Ingrese el numero de identificacion del Usuario: ");
        String id = interaz.leerTexto();
        interaz.imprimirMensaje("Ingrese el nombre del Usuario: ");
        String nombre = interaz.leerTexto();
        interaz.imprimirMensaje("Ingrese los apellidos del Usuario: ");
        String apellidos = interaz.leerTexto();
        interaz.imprimirMensaje("Ingrese el correo electronico del Usuario: ");
        String correo = interaz.leerTexto();
        interaz.imprimirMensaje("Ingrese el nombre de Usuario del Usuario: ");
        String usuario = interaz.leerTexto();
        interaz.imprimirMensaje("Ingrese la contrasena del Usuario: ");
        String contrasena = interaz.leerTexto();
        interaz.imprimirMensaje("Ingrese el codigo de Avatar del Usuario: ");
        String avatar = interaz.leerTexto();
        interaz.imprimirMensaje("Ingrese el equipo favorito del Usuario: ");
        String equipoFavorito = interaz.leerTexto();


        String mensaje = usuarioGestor.registrarUsuario(id, nombre, apellidos, correo, usuario, contrasena, avatar, equipoFavorito);
        interaz.imprimirMensaje(mensaje);
    }

    public void listarUsuarios() throws Exception {
        usuarioGestor.listarUsuarios().forEach(dato -> interaz.imprimirMensaje(dato));
    }

    public void registrarEquipo() throws Exception {
        interaz.imprimirMensaje("Ingrese el codigo del Equipo: ");
        String codigo = interaz.leerTexto();
        interaz.imprimirMensaje("Ingrese el nombre del Pais: ");
        String nombre = interaz.leerTexto();
        interaz.imprimirMensaje("Ingrese el numero de ranking del Equipo: ");
        int ranking = Integer.parseInt(interaz.leerTexto());
        interaz.imprimirMensaje("Ingrese el codigo de la bandera del Equipo: ");
        String bandera = interaz.leerTexto();


        String mensaje = equipoGestor.registrarEquipo(codigo, nombre, ranking, bandera);
        interaz.imprimirMensaje(mensaje);
    }

    public void listarEquipos() throws Exception {
        equipoGestor.listarEquipos().forEach(dato -> interaz.imprimirMensaje(dato));
    }

}














/**

    public void buscarMascota() throws Exception{
        listarMascotas();
        interaz.imprimirMensaje("Ingrese el id de la mascota: ");
        int id = Integer.parseInt(interaz.leerTexto());

        String mensaje = mascotaGestor.buscarMascota(id);
        interaz.imprimirMensaje(mensaje);
    }


    public void actualizarMascota() throws Exception{

    }

    public void eliminarMascota() throws Exception{
        interaz.imprimirMensaje("Por favor ingrese el nombre de la mascota: ");
        String nombre = interaz.leerTexto();

        String mensaje =  mascotaGestor.eliminarMascota(nombre);
        interaz.imprimirMensaje(mensaje);
    }

    public void listarMascotas() throws Exception{
        mascotaGestor.listarMascotas().forEach(dato -> interaz.imprimirMensaje(dato));
    }

    public void registrarDoctor() throws Exception{
        interaz.imprimirMensaje("Digite el id del doctor: ");
        int id = Integer.parseInt(interaz.leerTexto());
        interaz.imprimirMensaje("Digite el nombre del doctor: ");
        String nombre = interaz.leerTexto();
        interaz.imprimirMensaje("Digite los años de experiencia del doctor: ");
        int experiencia = Integer.parseInt(interaz.leerTexto());
        interaz.imprimirMensaje("Digite la especialidad del doctor: ");
        String especialidad = interaz.leerTexto();

        // conectamos al gestor y pasamos variables.

    }

    public void asignarMascotaADoctor() throws Exception{
        listarDoctores();
        interaz.imprimirMensaje("Digite el id del doctor: ");
        int idDoctor = Integer.parseInt(interaz.leerTexto());
        listarMascotas();
        interaz.imprimirMensaje("Digite el id de la mascota: ");
        int idMascota = Integer.parseInt(interaz.leerTexto());

        String mensaje = doctorGestor.asociarMascotaADoctor(idDoctor,idMascota);
        interaz.imprimirMensaje(mensaje);
    }

    public void listarDoctores() throws Exception{
        doctorGestor.listarDoctores().forEach(dato -> interaz.imprimirMensaje(dato));
    }

}

 */