package cr.ac.ucenfotec.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * @author Guillermo Vargas
 * @version 1
 * @since 10-08-2022
 *
 * UI PARA USAR LA CONSOLA Y HACER RESPECTIVAS PRUEBAS!!

 */

public class UI {

    private BufferedReader in = new BufferedReader(new InputStreamReader((System.in)));
    private PrintStream out = System.out;

    public void mostrarMenu(){
        out.println("******* Bienvenido al Mundialito *******");
        out.println("1. Registrar un Administrador.");
        out.println("2. Registrar un Usuario.");
        out.println("3. Listar Usuarios.");
        out.println("4. Registrar Equipo.");
        out.println("5. Listar Equipos.");

        out.println("0. Salir.");
        out.print("Seleccione una de las siguientes opciones: ");
    }

    public void imprimirMensaje(String mensaje){
        out.println(mensaje);
    }

    public String leerTexto() throws Exception{
        return in.readLine();
    }

    public int leerOpcion() throws Exception{
        return Integer.parseInt(in.readLine());
    }
}
