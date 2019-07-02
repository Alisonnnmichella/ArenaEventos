package UI;

import Dominio.Evento;
import Dominio.RepoEventos;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.uqbar.commons.model.annotations.Observable;
import org.uqbar.commons.model.annotations.Transactional;
import org.uqbar.commons.model.exceptions.UserException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Transactional
@Observable
public class BuscadorEventosViewModel {
    private List<Evento> eventos;
    private DateTime fechaInicial;
    private DateTime fechaFinal;
    public BuscadorEventosViewModel(){

    }
    public void search() {
        this.eventos = getRepositorioEventos().search(this.fechaInicial, this.fechaFinal);

    }

    public void clear() {
        eventos = new ArrayList<Evento>();
        fechaInicial = null;
        fechaFinal = null;
    }


    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public RepoEventos getRepositorioEventos() {
        return RepoEventos.getInstance();
    }

    public DateTime getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial=validarFecha(fechaInicial);
    }
    public DateTime getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal=validarFecha(fechaFinal);
    }
    public DateTime validarFecha(String fecha){
            try {
                String pattern = "yyyy-MM-dd";
                DateTime date = DateTime.parse(fecha, DateTimeFormat.forPattern(pattern));
                return date;
            }catch (Exception e) {
                throw new UserException("No se pudo parsear ");
            }
        }

    public List<DateTime> fechasDeEventosOrdenadas(){
        List<DateTime> fechas=new ArrayList<>();
        getRepositorioEventos().getEventos().forEach(evento -> fechas.add(evento.getFecha()));
        Collections.sort(fechas);
        return fechas;
    }
    public DateTime fechaMinimaEventos(){
        return fechasDeEventosOrdenadas().get(0);
    }
    public DateTime fechaMaximaEventos(){
        int indiceDeLaFechaMaxima=fechasDeEventosOrdenadas().size()-1;
        return fechasDeEventosOrdenadas().get(indiceDeLaFechaMaxima);
    }




}




