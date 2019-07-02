package UI;

import Dominio.Evento;
import Dominio.RepoEventos;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import org.uqbar.commons.applicationContext.ApplicationContext;

public class EventoApplication2  extends Application {

        public static void main(String[] args) {
            new EventoApplication2().start();
        }

        @Override
        protected Window<?> createMainWindow() {
            ApplicationContext.getInstance().configureSingleton(Evento.class, RepoEventos.getInstance());
            return new WindowBuscadorEventos(this);
        }

    }

