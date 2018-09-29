package br.edu.ifsp.hto.viewmodel.repositories;

import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import br.edu.ifsp.hto.viewmodel.database.ListaEsperaDAO;
import br.edu.ifsp.hto.viewmodel.entities.ListaEspera;
import br.edu.ifsp.hto.viewmodel.rest.ListaEsperaService;
import br.edu.ifsp.hto.viewmodel.utilities.AppExecutors;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaEsperaRepository {
    //TODO(3) Declarar um atributo ListaEsperaService
    ListaEsperaService mListaEsperaService;

    ListaEsperaDAO mListaEsperaDAO;

    //TODO(4) Adicionar como parâmetro do construtor um ListaEsperaService
    @Inject
    public ListaEsperaRepository(ListaEsperaDAO listaEsperaDAO, ListaEsperaService listaEsperaService) {
        mListaEsperaDAO = listaEsperaDAO;
        //TODO(5) Atribuir o parâmetro ListaEsperaService para o atributo de classe definido no passo 3
        mListaEsperaService = listaEsperaService;
    }

    public LiveData<List<ListaEspera>> getAllListaEspera(){
        //TODO(18) Chamar o método refreshData
        refreshData();
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

    //TODO(6) Definir um método privado chamado refreshData
        //Dentro de refreshData
    private void refreshData(){
        //TODO(7) Chamar o método list e enqueue de ListaEsperaService
        mListaEsperaService.list().enqueue(new Callback<List<ListaEspera>>() {
            @Override
            public void onResponse(Call<List<ListaEspera>> call, Response<List<ListaEspera>> response) {
                //TODO(8) Declarar uma variável final para armazenar o retorno da resposta
                final List<ListaEspera> data = response.body();

                //TODO(9) Realizar os passos 10 e 11 em um thread separada
                //utilizando o diskIO do AppExecutors
                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        //TODO(10) Remover os dados da tabela local com o método clearTable
                        //de ListaEsperaDAO
                        mListaEsperaDAO.clearTable();
                        //TODO(11) Inserir os dados retornados pelo webservice na tabela local
                        mListaEsperaDAO.insertListaEspera(data);
                    }
                });

            }

            @Override
            public void onFailure(Call<List<ListaEspera>> call, Throwable t) {

            }
        });

    }
}
