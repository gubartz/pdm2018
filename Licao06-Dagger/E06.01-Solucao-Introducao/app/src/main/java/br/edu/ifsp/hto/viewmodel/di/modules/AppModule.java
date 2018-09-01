package br.edu.ifsp.hto.viewmodel.di.modules;

import br.edu.ifsp.hto.viewmodel.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AppModule {
    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivityInjector();
}
