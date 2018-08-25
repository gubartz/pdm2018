package br.edu.ifsp.hto.listaespera.rest;


import java.util.List;

import br.edu.ifsp.hto.listaespera.entities.ListaEsperaEntry;
import br.edu.ifsp.hto.listaespera.entities.Resource;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface ListaEsperaService {
    String BASE_URL =
            "http://10.122.13.220:9090/";

    //TODO(5) Tocar o retorno do método lista para Call<Resource<List<ListaEsperaEntry>>>
    @GET("lista_espera")
    Call<Resource<List<ListaEsperaEntry>>> list();

    @POST("lista_espera")
    Call<ListaEsperaEntry> add(@Body ListaEsperaEntry listaEspera);

    @DELETE("lista_espera/{id}")
    Call<Void> remove(@Path("id") int id);

    @PUT("lista_espera")
    Call<Void> update(@Body ListaEsperaEntry listaEspera);
}
