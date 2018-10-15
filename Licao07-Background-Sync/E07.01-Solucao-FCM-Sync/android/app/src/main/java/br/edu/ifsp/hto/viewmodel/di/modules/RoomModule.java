package br.edu.ifsp.hto.viewmodel.di.modules;

import android.app.Application;

import javax.inject.Singleton;

import br.edu.ifsp.hto.viewmodel.database.AppDatabase;
import br.edu.ifsp.hto.viewmodel.database.ListaEsperaDAO;
import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {
    @Singleton
    @Provides
    public AppDatabase providesAppDatabase(Application application) {
        return AppDatabase.getInstance(application);
    }

    @Singleton
    @Provides
    public ListaEsperaDAO provideListaEsperaDAO(AppDatabase appDatabase){
        return appDatabase.listaEsperaDAO();
    }
}
