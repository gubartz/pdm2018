package br.edu.ifsp.hto.viewmodel.rest;


import java.util.List;

import br.edu.ifsp.hto.viewmodel.entities.ListaEspera;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface ListaEsperaService {

    @GET("lista_espera")
    Call<List<ListaEspera>> list();

    @POST("lista_espera")
    Call<ListaEspera> add(@Body ListaEspera listaEspera);

    @DELETE("lista_espera/{id}")
    Call<Void> remove(@Path("id") int id);

    @PUT("lista_espera/{id}")
    Call<Void> update(@Path("id")int id, @Body ListaEspera listaEspera);
}
