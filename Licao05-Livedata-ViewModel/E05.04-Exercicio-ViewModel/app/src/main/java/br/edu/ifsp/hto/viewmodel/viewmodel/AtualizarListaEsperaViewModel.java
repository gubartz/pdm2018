package br.edu.ifsp.hto.viewmodel.viewmodel;

import android.app.Application;
import androidx.lifecycle.ViewModel;

import br.edu.ifsp.hto.viewmodel.repositories.ListaEsperaRepository;

public class AtualizarListaEsperaViewModel extends ViewModel {
    ListaEsperaRepository listaEsperaRepository;

    public AtualizarListaEsperaViewModel(Application application) {
        this.listaEsperaRepository = new ListaEsperaRepository(application);
    }

    //TODO(15) Criar um método que recebe um ListaEspera chamado updateListaEspera
    //TODO(16) Utilizar o repository para realizar a atualização
}
