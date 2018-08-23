package br.edu.ifsp.hto.listaespera.rest;


import java.util.List;

import br.edu.ifsp.hto.listaespera.entities.ListaEspera;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface ListaEsperaService {
    String BASE_URL =
            "http://192.168.15.15:9090/";

    @GET("lista_espera")
    Call<List<ListaEspera>> list();

    @POST("lista_espera")
    Call<ListaEspera> add(@Body ListaEspera listaEspera);

    @DELETE("lista_espera/{id}")
    Call<Void> remove(@Path("id") int id);

    //TODO(8) Definir uma rota para PUT
    //TODO(9) Definir um método update que recebe um ListaEspera e retorna void. Utilizar a annotation Body no parâmetro
    @PUT("lista_espera")
    Call<Void> update(@Body ListaEspera listaEspera);
}
