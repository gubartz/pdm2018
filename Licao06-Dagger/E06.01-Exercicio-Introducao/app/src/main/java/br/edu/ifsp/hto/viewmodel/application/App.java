package br.edu.ifsp.hto.viewmodel.application;

import android.app.Activity;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;

//TODO(3) Fazer a classe estender de Application
//TODO(4) Implementar a interface HasActivityInjector
public class App{
    //TODO(5) Utilizar a annotation @Inject
    //TODO(6) Declarar um atributo para DispatchingAndroidInjector<Activity>

    //TODO(7) Fazer o rebuild do projeto
    //TODO(8) Sobrescrever o método onCreate
        //Dentro de onCreate
        //TODO(9) Tirar o comentário do código abaixo
        //DaggerAppComponent.builder().application(this).build().inject(this);

    //TODO(10) Sobrescrever o método activityInjector e retornar o atributo da classe DispatchingAndroidInjector
}
