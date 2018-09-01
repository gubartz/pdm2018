package br.edu.ifsp.hto.viewmodel.di.components;

import android.app.Application;

import javax.inject.Singleton;

import br.edu.ifsp.hto.viewmodel.application.App;
import br.edu.ifsp.hto.viewmodel.di.modules.AppModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

//TODO(2) Verifique o código deste componente
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class})
public interface AppComponent extends AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        AppComponent build();
        @BindsInstance
        Builder application(Application application);
    }

    void inject(App app);
}
