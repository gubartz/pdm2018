package br.edu.ifsp.hto.viewmodel.di.modules;

import javax.inject.Singleton;

import br.edu.ifsp.hto.viewmodel.database.ListaEsperaDAO;
import br.edu.ifsp.hto.viewmodel.repositories.ListaEsperaRepository;
import br.edu.ifsp.hto.viewmodel.rest.ListaEsperaService;
import br.edu.ifsp.hto.viewmodel.utilities.NetworkUtils;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {

    @Singleton
    @Provides
    public ListaEsperaRepository provideListaEsperaRepository(ListaEsperaDAO listaEsperaDAO, ListaEsperaService listaEsperaService, NetworkUtils networkUtils){
        return new ListaEsperaRepository(listaEsperaDAO, listaEsperaService, networkUtils);
    }
}
