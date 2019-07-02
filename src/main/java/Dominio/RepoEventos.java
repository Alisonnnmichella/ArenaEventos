package Dominio;

import UI.FixtureEventos;
import org.apache.commons.collections15.Predicate;
import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.uqbar.commons.model.CollectionBasedRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepoEventos extends CollectionBasedRepo<Evento> {

    private static RepoEventos instance = null;
    private List<Evento> eventos;
    private FixtureEventos fixtureEventos;
    private DateTime fechaMasTempranaDeUnEvento;
    private DateTime fechaMasTardiaDeUnEvento;
    private DateTime diezDeMayo2019;
    private DateTime veinteDeJulio2019;
    private DateTime tresDeJunio2019;

    private Evento camping;
    private Evento cenaPalermo;
    private Evento reunionfamiliar;
    private Evento reunionamistades;
    private RepoEventos repoEventos;


    private RepoEventos() {
        diezDeMayo2019=new DateTime(2019, 05, 10, 12, 00);
        veinteDeJulio2019=new DateTime(2019, 07, 20, 11, 00);
        tresDeJunio2019=new DateTime(2019, 06, 3, 1, 00);
        camping=new Evento(diezDeMayo2019,"Camping","Lobos");
        cenaPalermo=new Evento(tresDeJunio2019,"Cena","Palermo");
        reunionamistades=new Evento(veinteDeJulio2019,"Cine","Puerto madero");
        reunionfamiliar=new Evento(diezDeMayo2019,"Cena","Recoleta");

        this.eventos = new ArrayList<>();
        eventos.add(camping);
        eventos.add(reunionamistades);
        eventos.add(reunionamistades);
        eventos.add(reunionfamiliar);

        //      activarNotificadorProximosEventos();
    }

    @Override
    protected Predicate<Evento> getCriterio(Evento example) {
        return null;
    }

    //Esto es porque el repo debería ser único
    public static RepoEventos getInstance(){
        if(instance == null){
            instance = new RepoEventos();
        }
        return instance;
    }
/*
    public void activarNotificadorProximosEventos(){
        //TODO: que la condicion de proximidad dependa del gestor de clima
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                generarSugerencias();
            }
        },3 * 60 * 60 * 1000);//3*60*60*1000 cada 3 horas checkea
    }
*//*
    public boolean esProximo(Evento evento){
        //TODO
        int horas = Hours.hoursBetween(DateTime.now(), evento.getFecha()).getHours();
        return horas <= 3;
    }
*/
    public List<Evento> getEventos() {
        return eventos;
    }

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void agregarEventos(List<Evento> eventos){
        eventos.addAll(eventos);
    }
    public List<Evento> search(DateTime fechaInicial,DateTime fechaFinal){
               return eventos.stream().filter(evento->
                laFechaSeEncuetraEntreElRango(evento.getFecha(),fechaInicial,fechaFinal))
                .collect(Collectors.toList());
        }

    public boolean laFechaSeEncuetraEntreElRango(DateTime fecha,DateTime fechaInicial,DateTime fechaFinal){
       if(fechaInicial==null&&fechaFinal==null)
           return true;
        if(fechaInicial==null)
            return fecha.isBefore(fechaFinal)||fecha.isEqual(fechaFinal);
        if(fechaFinal==null)
            return fecha.isAfter(fechaInicial)||fecha.isEqual(fechaInicial);
        return (fecha.isBefore(fechaFinal)&&fecha.isAfter(fechaInicial))
               || fecha.isEqual(fechaInicial) || fecha.isEqual(fechaFinal);
    }

    @Override
    public Class<Evento> getEntityType() {
        return Evento.class;
    }

    @Override
    public Evento createExample() {
        return null;
    }
}
