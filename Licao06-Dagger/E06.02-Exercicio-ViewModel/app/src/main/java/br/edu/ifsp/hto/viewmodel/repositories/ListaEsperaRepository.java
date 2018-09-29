package br.edu.ifsp.hto.viewmodel.repositories;

import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import br.edu.ifsp.hto.viewmodel.database.ListaEsperaDAO;
import br.edu.ifsp.hto.viewmodel.entities.ListaEspera;
import br.edu.ifsp.hto.viewmodel.utilities.AppExecutors;

public class ListaEsperaRepository {
    ListaEsperaDAO mListaEsperaDAO;

    @Inject
    public ListaEsperaRepository(ListaEsperaDAO listaEsperaDAO) {
        mListaEsperaDAO = listaEsperaDAO;
    }

    public LiveData<List<ListaEspera>> getAllListaEspera(){
        return mListaEsperaDAO.loadAllListaEspera();
    }

    public void addListaEspera(final ListaEspera listaEspera){
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mListaEsperaDAO.insertListaEspera(listaEspera);
            }
        });
    }

    public void removeListaEspera(final ListaEspera listaEspera){
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mListaEsperaDAO.deleteListaEspera(listaEspera);
            }
        });
    }

    public void updateListaEspera(final ListaEspera listaEspera){
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mListaEsperaDAO.updateListaEspera(listaEspera);
            }
        });
    }
}
