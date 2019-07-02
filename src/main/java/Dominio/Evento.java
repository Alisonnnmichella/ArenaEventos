package Dominio;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.annotations.Observable;
@Observable
public class Evento extends Entity implements Comparable<Evento> {
    private DateTime fecha;
    private String fechaSinHoraEnString;
    private String horaEnString;
    private String nombreEvento;
    private String actividad;

    public Evento(DateTime fecha, String nombreEvento, String actividad) {
        this.fecha = fecha;
        this.nombreEvento = nombreEvento;
        this.actividad = actividad;
        this.fechaSinHoraEnString=getFechaSinHoraComoString(fecha);
        this.horaEnString=getHoraComoString(fecha);
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getActividad() {
        return actividad;
    }


    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getFechaSinHoraComoString(DateTime fecha) {
        return fecha.toString(DateTimeFormat.forPattern("dd-MM-yyyy"));
    }
    public String getHoraComoString(DateTime fecha){
        return fecha.toString(DateTimeFormat.forPattern("HH:mm"));
    }
    public DateTime getFecha(){
        return fecha;
    }

    public String getFechaSinHoraEnString() {
        return fechaSinHoraEnString;
    }

    public void setFechaSinHoraEnString(String fechaSinHoraEnString) {
        this.fechaSinHoraEnString = fechaSinHoraEnString;
    }

    public String getHoraEnString() {
        return horaEnString;
    }

    public void setHoraEnString(String horaEnString) {
        this.horaEnString = horaEnString;
    }

    @Override
    public int compareTo(Evento otherEvento){
        return getFecha().compareTo(otherEvento.getFecha());
    }
}




