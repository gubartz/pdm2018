package br.edu.ifsp.hto.livedata.repositories;

import android.app.Application;
import androidx.lifecycle.LiveData;

import java.util.List;

import br.edu.ifsp.hto.livedata.database.AppDatabase;
import br.edu.ifsp.hto.livedata.entities.ListaEspera;

public class ListaEsperaRepository {
    //TODO(1) Declarar um atributo do tipo AppDatabase
    private AppDatabase mDb;

    //TODO(2) Declarar um construtor que recebe um Application
        //Dentro do construtor
    public ListaEsperaRepository(Application application) {
        //TODO(3) Inicializar o atributo do passo 1 recuperando uma instância de AppDatabase
        mDb = AppDatabase.getInstance(application);
    }

    //TODO(4) Definir um metódo getAllListaEspera que retorna um LiveData de uma lista de objetos ListaEspera
        //Dentro de getAllListaEspera
    public LiveData<List<ListaEspera>> getAllListaEspera(){
        //TODO(5) Retonar o resultado da busca utilizando o DAO
        return mDb.listaEsperaDAO().loadAllListaEspera();
    }
}
