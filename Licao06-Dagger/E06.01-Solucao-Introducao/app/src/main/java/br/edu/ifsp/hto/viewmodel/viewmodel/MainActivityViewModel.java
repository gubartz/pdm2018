package br.edu.ifsp.hto.viewmodel.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import br.edu.ifsp.hto.viewmodel.entities.ListaEspera;
import br.edu.ifsp.hto.viewmodel.repositories.ListaEsperaRepository;

public class MainActivityViewModel extends ViewModel {
    ListaEsperaRepository listaEsperaRepository;

    //TODO(17) Remover o construtor
//    public MainActivityViewModel(Application application) {
//        this.listaEsperaRepository = new ListaEsperaRepository(application);
//    }

    //TODO(18) Criar um construtor que recebe um ListaEsperaRepository e atribua para o atributo de classe
    public MainActivityViewModel(ListaEsperaRepository listaEsperaRepository) {
        this.listaEsperaRepository = listaEsperaRepository;
    }

    public LiveData<List<ListaEspera>> getListaEspera(){
        return listaEsperaRepository.getAllListaEspera();
    }
}
