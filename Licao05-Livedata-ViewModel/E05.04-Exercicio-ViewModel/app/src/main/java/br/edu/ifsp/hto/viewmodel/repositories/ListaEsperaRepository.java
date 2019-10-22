package br.edu.ifsp.hto.viewmodel.repositories;

import android.app.Application;
import androidx.lifecycle.LiveData;

import java.util.List;

import br.edu.ifsp.hto.viewmodel.database.AppDatabase;
import br.edu.ifsp.hto.viewmodel.entities.ListaEspera;
import br.edu.ifsp.hto.viewmodel.utilities.AppExecutors;

public class ListaEsperaRepository {
    private AppDatabase mDb;

    public ListaEsperaRepository(Application application) {
        mDb = AppDatabase.getInstance(application);
    }

    public LiveData<List<ListaEspera>> getAllListaEspera(){
        return mDb.listaEsperaDAO().loadAllListaEspera();
    }

    public void addListaEspera(final ListaEspera listaEspera){
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mDb.listaEsperaDAO().insertListaEspera(listaEspera);
            }
        });
    }

    public void removeListaEspera(final ListaEspera listaEspera){
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mDb.listaEsperaDAO().deleteListaEspera(listaEspera);
            }
        });
    }

    public void updateListaEspera(final ListaEspera listaEspera){
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mDb.listaEsperaDAO().updateListaEspera(listaEspera);
            }
        });
    }
}
