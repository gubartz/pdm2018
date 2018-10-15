package br.edu.ifsp.hto.viewmodel.di.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import br.edu.ifsp.hto.viewmodel.di.factory.DaggerViewModelFactory;
import br.edu.ifsp.hto.viewmodel.viewmodel.AtualizarListaEsperaViewModel;
import br.edu.ifsp.hto.viewmodel.viewmodel.MainActivityViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(DaggerViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel.class)
    abstract ViewModel provideMainViewModel(MainActivityViewModel mainActivityViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(AtualizarListaEsperaViewModel.class)
    abstract ViewModel provideAtualizarListaEsperaViewModel(AtualizarListaEsperaViewModel atualizarListaEsperaViewModel);
}
