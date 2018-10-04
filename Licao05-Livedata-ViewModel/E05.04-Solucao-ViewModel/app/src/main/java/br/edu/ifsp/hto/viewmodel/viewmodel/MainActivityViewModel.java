package br.edu.ifsp.hto.viewmodel.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import br.edu.ifsp.hto.viewmodel.entities.ListaEspera;
import br.edu.ifsp.hto.viewmodel.repositories.ListaEsperaRepository;

//TODO(1) Fazer a classe estender de ViewModel
public class MainActivityViewModel extends ViewModel {
    //TODO(2) Declarar um atributo para o ListaEsperaRepository
    ListaEsperaRepository listaEsperaRepository;

    //TODO(3) Declarar um construtor que recebe um Application
        //Dentro do construtor
    public MainActivityViewModel(Application application) {
        //TODO(4) Instanciar um ListaEsperaRepository e atribuí-lo ao atributo de classe
        this.listaEsperaRepository = new ListaEsperaRepository(application);
    }

    //TODO(5) Criar um método chamado getListaEspera que retorno um LiveData de List<ListaEspera>
        //Dentro de getListaEspera
    public LiveData<List<ListaEspera>> getListaEspera(){
        //TODO(6) Retornar um LiveData de List<ListaEspera> do ListaEsperaRepository
        return listaEsperaRepository.getAllListaEspera();
    }

    //TODO(26) Criar um método chamado addListaEspera que recebe um ListaEspera
    public void addListaEspera(ListaEspera listaEspera){
        //TODO(27) Utilizar o repository para inserir na lista de espera
        listaEsperaRepository.addListaEspera(listaEspera);
    }

    //TODO(28) Criar um método chamado removeListaEspera recebe um ListaEspera
    public void removeListaEspera(ListaEspera listaEspera){
        //TODO(29) Utilizar o repositoy para remover da lista de espera
        listaEsperaRepository.removeListaEspera(listaEspera);
    }

}
