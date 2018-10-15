package br.edu.ifsp.hto.viewmodel.di.modules;

import android.app.Application;

import com.google.gson.annotations.Since;

import javax.inject.Singleton;

import br.edu.ifsp.hto.viewmodel.utilities.NetworkUtils;
import br.edu.ifsp.hto.viewmodel.utilities.NotificationUtils;
import dagger.Module;
import dagger.Provides;

@Module
public class UtilsModule {
    @Provides
    @Singleton
    public NetworkUtils providesNetworkUtils(Application application){
        return new NetworkUtils(application);
    }

    @Provides
    @Singleton
    public NotificationUtils providesNotificationUtils(Application application){
        return new NotificationUtils(application);
    }
}
