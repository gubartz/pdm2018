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
    ListaEsperaService mListaEsperaService;

    ListaEsperaDAO mListaEsperaDAO;

    @Inject
    public ListaEsperaRepository(ListaEsperaDAO listaEsperaDAO, ListaEsperaService listaEsperaService) {
        mListaEsperaDAO = listaEsperaDAO;
        mListaEsperaService = listaEsperaService;
    }

    public LiveData<List<ListaEspera>> getAllListaEspera(){
        refreshData();
        return mListaEsperaDAO.loadAllListaEspera();
    }

    public void addListaEspera(final ListaEspera listaEspera){
        //TODO(5) Remover o código abaixo
//        AppExecutors.getInstance().diskIO().execute(new Runnable() {
//            @Override
//            public void run() {
//                mListaEsperaDAO.insertListaEspera(listaEspera);
//            }
//        });
        //TODO(6) Chamar o método add passando o listaEspera
        add(listaEspera);
    }

    public void removeListaEspera(final ListaEspera listaEspera){
        //TODO(10) Remover o código abaixo
//        AppExecutors.getInstance().diskIO().execute(new Runnable() {
//            @Override
//            public void run() {
//                mListaEsperaDAO.deleteListaEspera(listaEspera);
//            }
//        });
        //TODO(11) Chamar o método remove passando o listaEspera
        remove(listaEspera);
    }

    public void updateListaEspera(final ListaEspera listaEspera){
        //TODO(15) Remover o código abaixo
//        AppExecutors.getInstance().diskIO().execute(new Runnable() {
//            @Override
//            public void run() {
//                mListaEsperaDAO.updateListaEspera(listaEspera);
//            }
//        });
        //TODO(16) Chamar o método update passando o listaEspera
        update(listaEspera);
    }

    private void refreshData(){
        mListaEsperaService.list().enqueue(new Callback<List<ListaEspera>>() {
            @Override
            public void onResponse(Call<List<ListaEspera>> call, Response<List<ListaEspera>> response) {
                final List<ListaEspera> data = response.body();

                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        mListaEsperaDAO.clearTable();
                        mListaEsperaDAO.insertListaEspera(data);
                    }
                });

            }

            @Override
            public void onFailure(Call<List<ListaEspera>> call, Throwable t) {

            }
        });
    }

    //TODO(2) Criar um método chamado add que recebe um ListaEspera como parâmetro
        //Dentro de add
    private void add(ListaEspera listaEspera){
        //TODO(3) Utilizar o atributo ListaEsperaService para enviar o registro utilizando o webservice
        mListaEsperaService.add(listaEspera).enqueue(new Callback<ListaEspera>() {
            @Override
            public void onResponse(Call<ListaEspera> call, Response<ListaEspera> response) {
                //TODO(4) Em onResponse chamar o método refreshData
                refreshData();
            }

            @Override
            public void onFailure(Call<ListaEspera> call, Throwable t) {

            }
        });
    }

    //TODO(7) Criar um método remove que recebe um ListaEspera
        //Dentro de remove
    private void remove(ListaEspera listaEspera){
        //TODO(8) Utilizar o atributo ListaEsperaService para remover o registro utilizando o webservice
        mListaEsperaService.remove(listaEspera.getId()).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                //TODO(9) Em onResponse chamar o método refreshData
                refreshData();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    //TODO(12) Criar um método chamado update que recebe um ListaEspera
        //Dentro de update
    private void update(ListaEspera listaEspera){
        //TODO(13) Utilizar o atributo ListaEsperaService para atualizar o registro utilizando o webservice
        mListaEsperaService.update(listaEspera.getId(), listaEspera).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                //TODO(14) Em onResponse chamar o método refreshData
                refreshData();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
