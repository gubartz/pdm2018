package br.edu.ifsp.hto.listardados.rest;


import java.util.List;

import br.edu.ifsp.hto.listardados.entities.ListaEspera;
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
    Call<List<ListaEspera>> list();

    @POST("lista_espera")
    Call<ListaEspera> add(@Body ListaEspera listaEspera);

    //TODO(1) Definir uma rota para delete utiizando lista_espera/{id}
    //TODO(2) Definir um método remove que recebe um inteiro id e retorna void
        //Utilize a annotation @Path na frente do parâmetro. Não é necessário enviar o objeto ListaEspera inteiro
    @DELETE("lista_espera/{id}")
    Call<Void> remove(@Path("id") int id);
}
