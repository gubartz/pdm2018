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

    @POST("lista_espera")
    Call<ListaEsperaEntry> add(@Body ListaEsperaEntry listaEspera);

    //TODO(1) Definir uma rota para delete utiizando lista_espera/{id}
    //TODO(2) Definir um método remove que recebe um inteiro id e retorna void
        //Utilize a annotation @Path na frente do parâmetro. Não é necessário enviar o objeto ListaEsperaEntry inteiro
}
