package br.edu.ifsp.hto.viewmodel.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import br.edu.ifsp.hto.viewmodel.entities.ListaEspera;
import br.edu.ifsp.hto.viewmodel.repositories.ListaEsperaRepository;

public class MainActivityViewModel extends ViewModel {
    ListaEsperaRepository listaEsperaRepository;

    //TODO(3) Utilizar a annotation Inject
    public MainActivityViewModel(ListaEsperaRepository listaEsperaRepository) {
        this.listaEsperaRepository = listaEsperaRepository;
    }

    public LiveData<List<ListaEspera>> getListaEspera(){
        return listaEsperaRepository.getAllListaEspera();
    }

    //TODO(4) Declarar um método para inserir na lista de espera (utilize o repository)

    //TODO(5) Declarar um método para atualizar a lista de espera (utilize o repository)

    //TODO(6) Declarar um método para remover um item da lista de espera
}
