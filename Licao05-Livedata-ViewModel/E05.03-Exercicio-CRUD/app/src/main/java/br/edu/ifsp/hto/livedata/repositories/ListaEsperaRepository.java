package br.edu.ifsp.hto.livedata.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import java.util.List;

import br.edu.ifsp.hto.livedata.database.AppDatabase;
import br.edu.ifsp.hto.livedata.entities.ListaEspera;
import br.edu.ifsp.hto.livedata.utilities.AppExecutors;

public class ListaEsperaRepository {
    private AppDatabase mDb;

    public ListaEsperaRepository(Application application) {
        mDb = AppDatabase.getsInstance(application);
    }

    public LiveData<List<ListaEspera>> getAllListaEspera(){
        return mDb.listaEsperaDAO().loadAllListaEspera();
    }

    //TODO(1) Definir um método addListaEspera que recebe um objeto ListaEspera
        //Dentro de addListaEspera
        //TODO(2) Utilizar o DAO para inserir na lista de espera com base no parâmetro do método
            //Utilizar o executor para realizar a ação em uma thread separada

    //TODO(3) Definir um método removeListaEspera que recebe um objeto ListaEspera
        //Dentro de removeListaEspera
        //TODO(4) Utilizar o DAO para remover da lista de espera com base no parâmetro do método
            //Utilizar o executor para realizar a ação em uma thread separada

    //TODO(5) Definir um método updateListaEspera que recebe um objeto ListaEspera
        //Dentro de updateListaEspera
        //TODO(6) Utilizar o DAO para remover da lista de espera com base no parâmetro do método
            //Utilizar o executor para realizar a ação em uma thread separada
}
