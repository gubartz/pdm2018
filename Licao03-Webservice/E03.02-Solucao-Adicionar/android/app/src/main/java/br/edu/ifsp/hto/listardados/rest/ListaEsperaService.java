package br.edu.ifsp.hto.listardados.rest;


import java.util.List;

import br.edu.ifsp.hto.listardados.entities.ListaEspera;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ListaEsperaService {
    String BASE_URL =
            "http://192.168.15.15:9090/";

    @GET("lista_espera")
    Call<List<ListaEspera>> list();

    //TODO(1) Definir uma rota com o método POST para lista_espera
    @POST("lista_espera")
    //TODO(2) Definir um método chamado add que recebe um parâmetro do tipo ListaEspera e retorna um ListaEspera
        //Utilizar a anotação @Body precedendo o parâmetro
    Call<ListaEspera> add(@Body ListaEspera listaEspera);
}
