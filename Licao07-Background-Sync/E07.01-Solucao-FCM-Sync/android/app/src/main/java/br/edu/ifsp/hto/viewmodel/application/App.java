package br.edu.ifsp.hto.viewmodel.application;

import android.app.Activity;
import android.app.Application;
import android.app.Service;

import javax.inject.Inject;

import br.edu.ifsp.hto.viewmodel.di.components.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasServiceInjector;

public class App extends Application implements HasActivityInjector, HasServiceInjector, LifecycleDelegate {
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Inject
    DispatchingAndroidInjector<Service> dispatchingServiceInjector;

    private AppLifecycleHandler mLifecycleHandler;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent.builder().create(this).inject(this);
        mLifecycleHandler = new AppLifecycleHandler(this);
        registerLifecycleHandler(mLifecycleHandler);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }

    @Override
    public AndroidInjector<Service> serviceInjector() {
        return dispatchingServiceInjector;
    }

    @Override
    public void onAppBackgrounded() {

    }

    @Override
    public void onAppForegrounded() {

    }

    public boolean isAppInForeground(){
        return mLifecycleHandler.isAppInForeground();
    }

    private void registerLifecycleHandler(AppLifecycleHandler appLifecycleHandler){
        registerActivityLifecycleCallbacks(appLifecycleHandler);
        registerComponentCallbacks(appLifecycleHandler);
    }
}
