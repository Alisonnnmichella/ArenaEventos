package UI;

import Dominio.Evento;
import Dominio.RepoEventos;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class FixtureEventos {
    private DateTime diezDeMayo2019;
    private DateTime veinteDeJulio2019;
    private DateTime tresDeJunio2019;

    private Evento camping;
    private Evento cenaPalermo;
    private Evento reunionfamiliar;
    private Evento reunionamistades;
    private RepoEventos repoEventos;
    public void iniciar(){
        diezDeMayo2019=new DateTime(2019, 05, 10, 12, 00);
        veinteDeJulio2019=new DateTime(2019, 07, 20, 12, 00);
        tresDeJunio2019=new DateTime(2019, 06, 3, 12, 00);
        camping=new Evento(diezDeMayo2019,"Camping","Lobos");
        cenaPalermo=new Evento(tresDeJunio2019,"Cena","Palermo");
        reunionamistades=new Evento(veinteDeJulio2019,"Cine","Puerto madero");
        reunionfamiliar=new Evento(diezDeMayo2019,"Cena","Recoleta");

          }
    public void cargarRepo(){
        iniciar();
        repoEventos. getInstance().agregarEvento(camping);
        repoEventos. getInstance().agregarEvento(cenaPalermo);
        repoEventos. getInstance().agregarEvento(reunionamistades);
        repoEventos. getInstance().agregarEvento(reunionfamiliar);


    }
    public List<Evento> eventos(){
        this.iniciar();
        List <Evento> eventos=new ArrayList<Evento>();
        eventos.add(camping);
        eventos.add(cenaPalermo);
        eventos.add(reunionamistades);
        eventos.add(reunionfamiliar);

        return eventos;
    }
}
