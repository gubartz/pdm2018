package br.edu.ifsp.hto.viewmodel.viewmodel;

import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import br.edu.ifsp.hto.viewmodel.entities.ListaEspera;
import br.edu.ifsp.hto.viewmodel.repositories.ListaEsperaRepository;

public class AtualizarListaEsperaViewModel extends ViewModel {
    ListaEsperaRepository mListaEsperaRepository;

    @Inject
    public AtualizarListaEsperaViewModel(ListaEsperaRepository listaEsperaRepository) {
        mListaEsperaRepository = listaEsperaRepository;
    }

    public void updateListaEspera(ListaEspera listaEspera){
        mListaEsperaRepository.updateListaEspera(listaEspera);
    }
}
