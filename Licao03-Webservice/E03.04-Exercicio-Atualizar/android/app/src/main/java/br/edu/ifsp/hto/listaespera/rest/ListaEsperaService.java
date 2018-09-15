package br.edu.ifsp.hto.listaespera.rest;


import java.util.List;

import br.edu.ifsp.hto.listaespera.entities.ListaEsperaEntry;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface ListaEsperaService {
    String BASE_URL =
            "http://192.168.15.15:9090/";

    @GET("lista_espera")
    Call<List<ListaEsperaEntry>> list();

    @POST("lista_espera")
    Call<ListaEsperaEntry> add(@Body ListaEsperaEntry listaEspera);

    @DELETE("lista_espera/{id}")
    Call<Void> remove(@Path("id") int id);

    //TODO(8) Definir uma rota para PUT
    //TODO(9) Definir um método update que recebe um ListaEsperaEntry e retorna void. Utilizar a annotation Body no parâmetro
    //e um Path para o id
}
