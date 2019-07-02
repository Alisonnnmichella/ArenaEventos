import Dominio.Evento;
import Dominio.RepoEventos;
import UI.BuscadorEventosViewModel;
import UI.FixtureEventos;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class BuscadorEventosViewModelTest {
    private BuscadorEventosViewModel buscador;
    private RepoEventos repoEventos;
    private FixtureEventos fixtureEventos;
    private DateTime diezDeMayo2019;
    private DateTime veinteDeJulio2019;
    private DateTime doceEnero2019;
    @Before
    public void inicialize() {
        buscador = new BuscadorEventosViewModel();
        fixtureEventos=new FixtureEventos();
        diezDeMayo2019=new DateTime(2019, 05, 10, 12, 00);
        veinteDeJulio2019=new DateTime(2019, 07, 20, 12, 00);
        doceEnero2019=new DateTime(2019,01,12,12,00);

    }

    @Test
    public void obtieneLaMaximaFecha() {
        assert (buscador.fechaMaximaEventos().isEqual(veinteDeJulio2019));
        assert (!buscador.fechaMaximaEventos().isEqual(diezDeMayo2019));
    }
    @Test
    public void obtieneLaMinimaFecha() {
        assert (buscador.fechaMinimaEventos().isEqual(diezDeMayo2019));
        assert (!buscador.fechaMinimaEventos().isEqual(veinteDeJulio2019));
    }
    @Test
    public void laFechaSeEncuentraEnUnRango(){
      DateTime unoDeMarzo2019= new DateTime(2019,03,1,4,5);
      DateTime doceDeMayo2019= new DateTime(2019,05,12,4,5);
      DateTime quinceDeMarzo=new DateTime(2019,03,15,4,4);
      assert (quinceDeMarzo.isBefore(doceDeMayo2019));
      assert (quinceDeMarzo.isAfter(unoDeMarzo2019));
    }
    @Test
    public void search(){
        DateTime unoDeMarzo2019= new DateTime(2019,03,1,4,5);
        DateTime doceDeMayo2019= new DateTime(2019,05,12,4,5);
        repoEventos.getInstance().search(diezDeMayo2019,veinteDeJulio2019)
                .forEach(evento -> System.out.println(evento.getFecha()+" "+evento.getActividad()+" "+evento.getNombreEvento()));
    }

}
