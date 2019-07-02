package UI;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.uqbar.commons.model.annotations.Observable;

@Observable

public class EventoViewModel1 {

    private DateTime fecha;
    private String nombreEvento;
    private String actividad;

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
    public void setFecha(DateTime fecha) {
        this.fecha = fecha;

    }

    public String getFecha() {
        return fecha.toString(DateTimeFormat.forPattern("yyyy-MM-dd  HH:mm:ss"));
    }



/*    public DateTime getDateTime() {
        try {
            String pattern = "yyyy-MM-dd HH:mm:ssZ";
            DateTime date = DateTime.parse(fecha, DateTimeFormat.forPattern(pattern));
            return date;
        } catch (Exception e) {
          return null;
        }
    }*/
}
