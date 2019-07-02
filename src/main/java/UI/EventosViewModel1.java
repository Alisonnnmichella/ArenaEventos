package UI;

import Dominio.Evento;
import Dominio.RepoEventos;
import org.uqbar.commons.model.annotations.Observable;
import org.uqbar.commons.model.annotations.Transactional;

import java.util.List;

@Transactional
@Observable
public class EventosViewModel1 {
    private static List<Evento> eventos;

    public EventosViewModel1(){
        FixtureEventos fixtureEventos=new FixtureEventos();
        eventos=fixtureEventos.eventos();
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    }
