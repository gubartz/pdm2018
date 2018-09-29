package br.edu.ifsp.hto.viewmodel.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import br.edu.ifsp.hto.viewmodel.entities.ListaEspera;
import br.edu.ifsp.hto.viewmodel.repositories.ListaEsperaRepository;

public class MainActivityViewModel extends ViewModel {
    ListaEsperaRepository listaEsperaRepository;

    //TODO(3) Utilizar a annotation Inject
    @Inject
    public MainActivityViewModel(ListaEsperaRepository listaEsperaRepository) {
        this.listaEsperaRepository = listaEsperaRepository;
    }

    public LiveData<List<ListaEspera>> getListaEspera(){
        return listaEsperaRepository.getAllListaEspera();
    }

    //TODO(4) Declarar um método para inserir na lista de espera (utilize o repository)
    public void addListaEspera(ListaEspera listaEsperaEntry){
        listaEsperaRepository.addListaEspera(listaEsperaEntry);
    }

    //TODO(5) Declarar um método para atualizar a lista de espera (utilize o repository)
    public void updateListaEspera(ListaEspera listaEsperaEntry){
        listaEsperaRepository.updateListaEspera(listaEsperaEntry);
    }

    //TODO(6) Declarar um método para remover um item da lista de espera
    public void removeListaEspera(ListaEspera listaEsperaEntry){
        listaEsperaRepository.removeListaEspera(listaEsperaEntry);
    }
}
