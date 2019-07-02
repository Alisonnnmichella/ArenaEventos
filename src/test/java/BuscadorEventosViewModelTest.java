import Dominio.Evento;
import Dominio.RepoEventos;
import UI.BuscadorEventosViewModel;
import UI.EventoApplication;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;


public class BuscadorEventosViewModelTest {
    private BuscadorEventosViewModel buscador;
    private RepoEventos repoEventos;
    private DateTime diezDeMayo2019;
    private DateTime veinteDeJulio2019;
    private DateTime doceEnero2019;
    private DateTime quinceDeMarzo2019;
    private DateTime unoDeMarzo2018;
    private Evento camping;
    private Evento competenciaNatacion;
    private Evento hackaton;
    private Evento ensayoBanda;
    private Evento cenaFamiliar;

    private EventoApplication aplicacion ;
    @Before
    public void inicialize() {
        buscador = new BuscadorEventosViewModel();
        diezDeMayo2019=new DateTime(2019, 05, 10, 12, 00);
        veinteDeJulio2019=new DateTime(2019, 07, 20, 12, 00);
        doceEnero2019=new DateTime(2019,01,12,12,00);
        quinceDeMarzo2019= new DateTime(2019,03,15,17,05);
        unoDeMarzo2018=new DateTime(2018,03,1,03,00);
        camping=new Evento(diezDeMayo2019,"Camping","acampar");
        hackaton= new Evento(veinteDeJulio2019,"hackaton","codear");
        competenciaNatacion=new Evento(doceEnero2019,"Competencia de peces","nadar");
        ensayoBanda=new Evento(unoDeMarzo2018,"Competencia mortal","Ensayar");
        cenaFamiliar=new Evento(quinceDeMarzo2019,"Cena","cenar");
        repoEventos.getInstance().agregarEvento(camping);
        repoEventos.getInstance().agregarEvento(hackaton);
        repoEventos.getInstance().agregarEvento(competenciaNatacion);
        repoEventos.getInstance().agregarEvento(ensayoBanda);
        repoEventos.getInstance().agregarEvento(cenaFamiliar);

    }

    @Test
    public void obtieneLaMaximaFecha() {
        assert (buscador.fechaMaximaEventos().isEqual(veinteDeJulio2019));
        assert (!buscador.fechaMaximaEventos().isEqual(diezDeMayo2019));
    }
    @Test
    public void obtieneLaMinimaFecha() {
        assert (buscador.fechaMinimaEventos().isEqual(unoDeMarzo2018));
        assert (!buscador.fechaMinimaEventos().isEqual(veinteDeJulio2019));

    }
    @Test
    public void laFechaSeEncuentraEnUnRango(){
      assert (quinceDeMarzo2019.isBefore(diezDeMayo2019));
      assert (quinceDeMarzo2019.isAfter(unoDeMarzo2018));
    }
    @Test
    public void prueba(){
        aplicacion.main();
    }

}
