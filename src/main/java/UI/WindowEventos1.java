package UI;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.MainWindow;

public class WindowEventos1 extends MainWindow<EventosViewModel1> {

    public WindowEventos1() {
        super( new EventosViewModel1());


    }

    public void createContents(Panel mainPanel) {
        this.setTitle("¿Que me pongo?- Eventos:");

        Table<EventoViewModel1> tableEventos = new Table<EventoViewModel1>(mainPanel, EventoViewModel1.class);
        tableEventos.setNumberVisibleRows(30).bindItemsToProperty("eventos");
        Column<EventoViewModel1> columnaLugar = new Column<EventoViewModel1>(tableEventos);
        columnaLugar.setTitle("Actividad").setFixedSize(300).bindContentsToProperty("actividad");
        Column<EventoViewModel1> columnaActividades = new Column<EventoViewModel1>(tableEventos);
        columnaActividades.setTitle("Nombre de evento").setFixedSize(300).bindContentsToProperty("nombreEvento");
        Column<EventoViewModel1>columnaFechas=new Column<EventoViewModel1>(tableEventos);
        columnaFechas.setTitle("Fecha").setFixedSize(300).bindContentsToProperty("fecha");

        }



}
