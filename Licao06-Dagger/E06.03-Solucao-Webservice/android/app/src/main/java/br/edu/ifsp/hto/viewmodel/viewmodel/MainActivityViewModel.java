package br.edu.ifsp.hto.viewmodel.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import br.edu.ifsp.hto.viewmodel.entities.ListaEspera;
import br.edu.ifsp.hto.viewmodel.repositories.ListaEsperaRepository;

public class MainActivityViewModel extends ViewModel {
    ListaEsperaRepository listaEsperaRepository;

    @Inject
    public MainActivityViewModel(ListaEsperaRepository listaEsperaRepository) {
        this.listaEsperaRepository = listaEsperaRepository;
    }

    public LiveData<List<ListaEspera>> getListaEspera(){
        return listaEsperaRepository.getAllListaEspera();
    }

    public void addListaEspera(ListaEspera listaEsperaEntry){
        listaEsperaRepository.addListaEspera(listaEsperaEntry);
    }

    public void updateListaEspera(ListaEspera listaEsperaEntry){
        listaEsperaRepository.updateListaEspera(listaEsperaEntry);
    }

    public void removeListaEspera(ListaEspera listaEsperaEntry){
        listaEsperaRepository.removeListaEspera(listaEsperaEntry);
    }
}
