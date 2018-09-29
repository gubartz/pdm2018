package br.edu.ifsp.hto.viewmodel.di.components;

import android.app.Application;

import javax.inject.Singleton;

import br.edu.ifsp.hto.viewmodel.application.App;
import br.edu.ifsp.hto.viewmodel.di.modules.AppModule;
import br.edu.ifsp.hto.viewmodel.di.modules.RepositoriesModule;
import br.edu.ifsp.hto.viewmodel.di.modules.RetrofitModule;
import br.edu.ifsp.hto.viewmodel.di.modules.RoomModule;
import br.edu.ifsp.hto.viewmodel.di.modules.ViewModelModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        RoomModule.class,
        ViewModelModule.class,
        RetrofitModule.class,
        RepositoriesModule.class})
public interface AppComponent extends AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        AppComponent build();
        @BindsInstance
        Builder application(Application application);
    }

    void inject(App app);
}
