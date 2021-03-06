package br.edu.ifsp.hto.viewmodel.repositories;

import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import br.edu.ifsp.hto.viewmodel.database.ListaEsperaDAO;
import br.edu.ifsp.hto.viewmodel.entities.ListaEspera;
import br.edu.ifsp.hto.viewmodel.utilities.AppExecutors;

public class ListaEsperaRepository {
    //TODO(20) Trocar o atributo de classe de AppDatabase para um ListaEsperaDAO
//    private AppDatabase mDb;
    ListaEsperaDAO mListaEsperaDAO;

    //TODO(21) Trocar o construtor para receber um ListaEsperaDAO
    //TODO(22) Utilizar a annotation Inject no construtor
    @Inject
    public ListaEsperaRepository(ListaEsperaDAO listaEsperaDAO) {
        //TODO(23) Atribuir o parâmetro do construtor para o atributo de classe
        mListaEsperaDAO = listaEsperaDAO;
    }

    //TODO(24) Trocar todos os métodos para usar o atributo de classe ListaEsperaDAO
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
