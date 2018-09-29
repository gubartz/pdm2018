package br.edu.ifsp.hto.viewmodel.di.modules;

import javax.inject.Singleton;

import br.edu.ifsp.hto.viewmodel.database.ListaEsperaDAO;
import br.edu.ifsp.hto.viewmodel.repositories.ListaEsperaRepository;
import br.edu.ifsp.hto.viewmodel.rest.ListaEsperaService;
import dagger.Module;
import dagger.Provides;

//TODO(13) Adicionar a annotation Module
@Module
public class RepositoriesModule {
    //TODO(14) Criar um método provideListaEsperaRepository
        //O retorno do método deverá ser um ListaEsperaRepository
        //O método deverá receber um ListaEsperaDAO e um ListaEsperaService
    //TODO(15) Utilizar as annotations Singleton e Provides
    @Singleton
    @Provides
    public ListaEsperaRepository provideListaEsperaRepository(ListaEsperaDAO listaEsperaDAO, ListaEsperaService listaEsperaService){
        //TODO(16) Instanciar e retornar um ListaEsperaRepository
        return new ListaEsperaRepository(listaEsperaDAO, listaEsperaService);
    }
}
