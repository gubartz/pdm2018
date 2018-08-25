package br.edu.ifsp.hto.listaespera.rest;


import java.util.List;

import br.edu.ifsp.hto.listaespera.entities.ListaEsperaEntry;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ListaEsperaService {
    //TODO(3) Verificar e trocar o IP para o de sua máquina
    String BASE_URL =
            "http://10.122.13.220:9090/";

    //TODO(4) Definir um método para arota lista_espera que deverá retornar um Call de uma lista de
        //objetos ListaEsperaEntry
    @GET("lista_espera")
    Call<List<ListaEsperaEntry>> list();
}
