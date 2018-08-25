package br.edu.ifsp.hto.listaespera.rest;


import java.util.List;

import br.edu.ifsp.hto.listaespera.entities.ListaEsperaEntry;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ListaEsperaService {
    String BASE_URL =
            "http://192.168.15.15:9090/";

    @GET("lista_espera")
    Call<List<ListaEsperaEntry>> list();

    //TODO(1) Definir uma rota com o método POST para lista_espera
    @POST("lista_espera")
    //TODO(2) Definir um método chamado add que recebe um parâmetro do tipo ListaEsperaEntry e retorna um ListaEsperaEntry
        //Utilizar a anotação @Body precedendo o parâmetro
    Call<ListaEsperaEntry> add(@Body ListaEsperaEntry listaEspera);
}
