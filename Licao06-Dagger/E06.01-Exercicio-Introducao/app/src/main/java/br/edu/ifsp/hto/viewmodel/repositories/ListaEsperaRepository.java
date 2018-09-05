package br.edu.ifsp.hto.viewmodel.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import java.util.List;

import br.edu.ifsp.hto.viewmodel.database.AppDatabase;
import br.edu.ifsp.hto.viewmodel.entities.ListaEspera;
import br.edu.ifsp.hto.viewmodel.utilities.AppExecutors;

public class ListaEsperaRepository {
    //TODO(20) Trocar o atributo de classe de AppDatabase para um ListaEsperaDAO
    private AppDatabase mDb;

    //TODO(21) Trocar o construtor para receber um ListaEsperaDAO
    //TODO(22) Utilizar a annotation Inject no construtor
    //TODO(23) Atribuir o parâmetro do construtor para o atributo de classe
    public ListaEsperaRepository(Application application) {
        mDb = AppDatabase.getsInstance(application);
    }

    //TODO(24) Trocar todos os métodos para usar o atributo de classe ListaEsperaDAO
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
