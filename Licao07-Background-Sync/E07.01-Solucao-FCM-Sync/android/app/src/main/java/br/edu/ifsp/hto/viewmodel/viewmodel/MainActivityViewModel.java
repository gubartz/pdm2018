package br.edu.ifsp.hto.viewmodel.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import br.edu.ifsp.hto.viewmodel.entities.ListaEspera;
import br.edu.ifsp.hto.viewmodel.repositories.ListaEsperaRepository;

public class MainActivityViewModel extends ViewModel {
    ListaEsperaRepository mListaEsperaRepository;

    @Inject
    public MainActivityViewModel(ListaEsperaRepository listaEsperaRepository) {
        this.mListaEsperaRepository = listaEsperaRepository;
    }

    public LiveData<List<ListaEspera>> getListaEspera(){
        return mListaEsperaRepository.getAllListaEspera();
    }

    public void addListaEspera(ListaEspera listaEsperaEntry){
        mListaEsperaRepository.addListaEspera(listaEsperaEntry);
    }

    public void updateListaEspera(ListaEspera listaEsperaEntry){
        mListaEsperaRepository.updateListaEspera(listaEsperaEntry);
    }

    public void removeListaEspera(ListaEspera listaEsperaEntry){
        mListaEsperaRepository.removeListaEspera(listaEsperaEntry);
    }
}
