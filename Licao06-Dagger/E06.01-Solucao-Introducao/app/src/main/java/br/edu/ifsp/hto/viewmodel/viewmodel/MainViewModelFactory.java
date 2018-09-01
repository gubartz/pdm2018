package br.edu.ifsp.hto.viewmodel.viewmodel;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import br.edu.ifsp.hto.viewmodel.repositories.ListaEsperaRepository;

public class MainViewModelFactory implements ViewModelProvider.Factory{
    //TODO(13) Remover o atributo application
    //private Application application;

    //TODO(14) Adicionar um atributo ListaEsperaRepository
    private ListaEsperaRepository mListaEsperaRepository;

    //TODO(15) Remover o construtor
//    public MainViewModelFactory(Application application) {
//        this.application = application;
//    }

    //TODO(16) Criar um construtor que recebe um ListaEsperaRepository e o atribua para o atributo da classse
    public MainViewModelFactory(ListaEsperaRepository listaEsperaRepository) {
        mListaEsperaRepository = listaEsperaRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainActivityViewModel.class)) {
            return (T) new MainActivityViewModel(mListaEsperaRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
