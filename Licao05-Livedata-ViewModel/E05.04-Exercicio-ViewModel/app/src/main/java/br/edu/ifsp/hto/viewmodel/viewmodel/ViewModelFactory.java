package br.edu.ifsp.hto.viewmodel.viewmodel;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

public class ViewModelFactory implements ViewModelProvider.Factory{
    private Application application;

    public ViewModelFactory(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainActivityViewModel.class)) {
            return (T) new MainActivityViewModel(this.application);
        }else if (modelClass.isAssignableFrom(AtualizarListaEsperaViewModel.class)) {
            return (T) new AtualizarListaEsperaViewModel(this.application);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}