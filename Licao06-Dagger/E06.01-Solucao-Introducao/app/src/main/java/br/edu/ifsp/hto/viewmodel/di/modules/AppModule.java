package br.edu.ifsp.hto.viewmodel.di.modules;

import android.app.Application;
import android.content.Context;

import br.edu.ifsp.hto.viewmodel.AtualizarListaEsperaActiviy;
import br.edu.ifsp.hto.viewmodel.MainActivity;
import br.edu.ifsp.hto.viewmodel.application.App;
import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AppModule {
    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivityInjector();

    @ContributesAndroidInjector
    abstract AtualizarListaEsperaActiviy contributeAtualizarListaEsperaActiviyInjector();
}
