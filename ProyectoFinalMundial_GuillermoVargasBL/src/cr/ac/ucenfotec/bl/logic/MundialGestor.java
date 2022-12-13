package cr.ac.ucenfotec.bl.logic;
import cr.ac.ucenfotec.bl.entities.Mundial.Mundial;
import cr.ac.ucenfotec.bl.entities.Mundial.IMundialDAO;
import cr.ac.ucenfotec.bl.entities.Grupo.Grupo;
import cr.ac.ucenfotec.bl.entities.Liga.Liga;
import java.time.LocalDate;


import cr.ac.ucenfotec.dao.DAOFactory;

import java.net.URL;
import java.util.ArrayList;

public class MundialGestor {
    private DAOFactory factory;
    private IMundialDAO datos;



    public MundialGestor(){
        factory = DAOFactory.getDAOFactory();
        datos = factory.getIMundialDao();
    }

    public String registrarMundial(int ano, String paisOrganizador, String estado) throws Exception{
        Mundial mundial= new Mundial(ano, paisOrganizador, estado);
        return datos.registrarMundial(mundial);
    }

    public ArrayList<String> listarMundiales() throws Exception{
        ArrayList<String> listaMundiales = new ArrayList<>();

        for (Mundial mundialTemp:datos.listarMundiales()) {
            listaMundiales.add(mundialTemp.toString());
        }
        return listaMundiales;
    }

    public ArrayList<Mundial> listarMundialesObjeto() throws Exception{
        ArrayList<Mundial> listaMundiales = new ArrayList<>();

        for (Mundial mundialTemp:datos.listarMundiales()) {
            listaMundiales.add(mundialTemp);
        }
        return listaMundiales;
    }

    public String cambiarEstadoMundial(int ano) throws Exception{
        //Mundial mundial= new Mundial(ano, paisOrganizador, estado);
        return datos.cambiarEstadoMundial(ano);
    }

    public String agregarGrupoAMundial(int codigo, String nombre, int anioMundial) throws Exception{
        Grupo grupo = new Grupo(codigo,nombre);
        datos.agregarGrupoAMundial(grupo,anioMundial);
        return "El grupo fue creado y agregado exitosamente!";

    }

    public String listarGrupos(int anioMundial) throws Exception{

        datos.listarGrupos(anioMundial);
        return "Lista de grupos actualizada";

    }

    public ArrayList<Grupo> listarGruposObjeto(int anioMundial) throws Exception{
        ArrayList<Grupo> listaGrupos = new ArrayList<>();

        for (Grupo grupoTemp:datos.listarGrupos(anioMundial)) {
            listaGrupos.add(grupoTemp);
        }
        return listaGrupos;
    }


    public String agregarLigaAMundial(String nombre, String fechaCreacion, int mundialPerteneciente, String estado) throws Exception{
        Liga liga = new Liga(nombre, fechaCreacion, mundialPerteneciente, estado);
        datos.agregarLigaAMundial(liga);

        //System.out.print(liga.toString());
        return "La liga fue creada y agregada exitosamente!";

    }

    public String listarLigas(int anioMundial) throws Exception{

        datos.listarLigas(anioMundial);
        return "Lista de ligas actualizada";

    }

    public ArrayList<Liga> listarLigasObjeto(int anioMundial) throws Exception{
        ArrayList<Liga> listaLigas = new ArrayList<>();

        for (Liga ligaTemp:datos.listarLigas(anioMundial)) {
            listaLigas.add(ligaTemp);
        }
        return listaLigas;
    }

    public String cambiarEstadoLiga(String nombre) throws Exception{
        //Mundial mundial= new Mundial(ano, paisOrganizador, estado);
        return datos.cambiarEstadoLiga(nombre);
    }

}
