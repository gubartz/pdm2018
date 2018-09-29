package br.edu.ifsp.hto.viewmodel.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import br.edu.ifsp.hto.viewmodel.repositories.ListaEsperaRepository;

public class MainViewModelFactory implements ViewModelProvider.Factory{
    private ListaEsperaRepository mListaEsperaRepository;


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
