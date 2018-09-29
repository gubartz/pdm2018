package br.edu.ifsp.hto.viewmodel.di.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import br.edu.ifsp.hto.viewmodel.di.factory.DaggerViewModelFactory;
import br.edu.ifsp.hto.viewmodel.viewmodel.MainActivityViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

//TODO(1) Verifique o código deste módulo
@Module
public abstract class ViewModelModule {
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(DaggerViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel.class)
    abstract ViewModel provideMainViewModel(MainActivityViewModel MainActivityViewModel);
}
