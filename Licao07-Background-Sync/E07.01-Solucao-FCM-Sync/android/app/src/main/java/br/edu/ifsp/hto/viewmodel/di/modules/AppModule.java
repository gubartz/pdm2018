package br.edu.ifsp.hto.viewmodel.di.modules;

import android.app.Application;

import javax.inject.Singleton;

import br.edu.ifsp.hto.viewmodel.AtualizarListaEsperaActiviy;
import br.edu.ifsp.hto.viewmodel.MainActivity;
import br.edu.ifsp.hto.viewmodel.application.App;
import br.edu.ifsp.hto.viewmodel.firebase_fcm.MyFirebaseMessagingService;
import br.edu.ifsp.hto.viewmodel.utilities.NetworkUtils;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AppModule {
    @Binds
    abstract Application application(App app);

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivityInjector();

    @ContributesAndroidInjector
    abstract AtualizarListaEsperaActiviy contributeAtualizarListaEsperaActiviyInjector();

    @ContributesAndroidInjector
    abstract MyFirebaseMessagingService contributeMyFirebaseMessagingService();
}
