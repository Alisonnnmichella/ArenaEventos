package UI;

import Dominio.Evento;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import java.awt.*;

public class WindowBuscadorEventos extends SimpleWindow<BuscadorEventosViewModel>{
    public WindowBuscadorEventos(WindowOwner parent){
        super(parent,new BuscadorEventosViewModel());
        this.getModelObject().search();
    }
    @Override
    protected void createMainTemplate(Panel mainPanel) {
        this.setTitle("Buscador de Eventos");

        new Label(mainPanel).setText("Ingrese desde y hasta que fecha desea obtener los eventos disponibles")
        .setBackground(Color.PINK)
        .setForeground(Color.blue);



        
        super.createMainTemplate(mainPanel);

        this.createResultsGrid(mainPanel);
    }
    @Override
    protected void createFormPanel(Panel mainPanel) {
        Panel searchFormPanel = new Panel(mainPanel);

        searchFormPanel.setLayout(new ColumnLayout(2));
        new Label(searchFormPanel).setText("Fecha inicial").setForeground(Color.BLUE);
        new TextBox(searchFormPanel).setWidth(150)
                .bindValueToProperty("fechaInicial")
                .setTransformer(new LocalDateTransformer());
        new Label(searchFormPanel).setText("Fecha final").setForeground(Color.BLUE);

        new TextBox(searchFormPanel).setWidth(150).bindValueToProperty("fechaFinal")
                .setTransformer(new LocalDateTransformer());
    }
    @Override
    protected void addActions(Panel actionsPanel) {
        new org.uqbar.arena.widgets.Button(actionsPanel)
                .setCaption("Buscar")
                .onClick(getModelObject()::search)
                .disableOnError();

        new org.uqbar.arena.widgets.Button(actionsPanel) //
                .setCaption("Limpiar")
                .onClick(getModelObject()::clear);

    }
    protected void createResultsGrid(Panel mainPanel) {
        Table<Evento> table = new Table<Evento>(mainPanel, Evento.class);
        table.setNumberVisibleRows(10);
        table.setWidth(450);

        table.bindItemsToProperty("eventos");

        this.describeResultsGrid(table);
    }

    protected void describeResultsGrid(Table<Evento> table) {
        new Column<Evento>(table) //
                .setTitle("Fecha")
                .setFixedSize(150)
                .bindContentsToProperty("fechaSinHoraEnString");
        new Column<Evento>(table) //
                .setTitle("Horario")
                .setFixedSize(150)
                .bindContentsToProperty("horaEnString");

        new Column<Evento>(table) //
                .setTitle("Nombre del Evento")
                .setFixedSize(150)
                .alignRight()
                .bindContentsToProperty("nombreEvento");

    }



}
