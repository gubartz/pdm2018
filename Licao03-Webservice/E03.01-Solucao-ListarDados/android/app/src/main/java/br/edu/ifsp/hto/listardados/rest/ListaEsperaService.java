package br.edu.ifsp.hto.listardados.rest;


import java.util.List;

import br.edu.ifsp.hto.listardados.entities.ListaEspera;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ListaEsperaService {
    //TODO(3) Verificar e trocar o IP para o de sua máquina
    String BASE_URL =
            "http://192.168.15.15:9090/";

    //TODO(4) Definir um método para arota lista_espera que deverá retornar um Call de uma lista de
        //objetos ListaEspera
    @GET("lista_espera")
    Call<List<ListaEspera>> list();
}
