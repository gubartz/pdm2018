package br.edu.ifsp.hto.viewmodel.repositories;

import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import br.edu.ifsp.hto.viewmodel.database.ListaEsperaDAO;
import br.edu.ifsp.hto.viewmodel.entities.ListaEspera;
import br.edu.ifsp.hto.viewmodel.rest.ListaEsperaService;
import br.edu.ifsp.hto.viewmodel.utilities.AppExecutors;
import br.edu.ifsp.hto.viewmodel.utilities.NetworkUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaEsperaRepository {
    ListaEsperaService mListaEsperaService;
    ListaEsperaDAO mListaEsperaDAO;
    NetworkUtils mNetworkUtils;

    @Inject
    public ListaEsperaRepository(ListaEsperaDAO listaEsperaDAO, ListaEsperaService listaEsperaService, NetworkUtils networkUtils) {
        mListaEsperaDAO = listaEsperaDAO;
        mListaEsperaService = listaEsperaService;
        mNetworkUtils = networkUtils;
    }

    public LiveData<List<ListaEspera>> getAllListaEspera(){
        refreshData();
        return mListaEsperaDAO.loadAllListaEspera();
    }

    public void addListaEspera(final ListaEspera listaEspera){
        add(listaEspera);
    }

    public void removeListaEspera(final ListaEspera listaEspera){
        remove(listaEspera);
    }

    public void updateListaEspera(final ListaEspera listaEspera){
        update(listaEspera);
    }

    public void refreshData(){
        if(!mNetworkUtils.isNetworkAvailable()){
            return;
        }

        mListaEsperaService.list().enqueue(new Callback<List<ListaEspera>>() {
            @Override
            public void onResponse(Call<List<ListaEspera>> call, Response<List<ListaEspera>> response) {
                final List<ListaEspera> data = response.body();

                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        mListaEsperaDAO.clearTable();
                        if(data != null)
                            mListaEsperaDAO.insertListaEspera(data);
                    }
                });

            }

            @Override
            public void onFailure(Call<List<ListaEspera>> call, Throwable t) {

            }
        });
    }

    private void add(ListaEspera listaEspera){
        mListaEsperaService.add(listaEspera).enqueue(new Callback<ListaEspera>() {
            @Override
            public void onResponse(Call<ListaEspera> call, Response<ListaEspera> response) {
                refreshData();
            }

            @Override
            public void onFailure(Call<ListaEspera> call, Throwable t) {

            }
        });
    }

    private void remove(ListaEspera listaEspera){
        mListaEsperaService.remove(listaEspera.getId()).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                refreshData();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    private void update(ListaEspera listaEspera){
        mListaEsperaService.update(listaEspera.getId(), listaEspera).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                refreshData();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
