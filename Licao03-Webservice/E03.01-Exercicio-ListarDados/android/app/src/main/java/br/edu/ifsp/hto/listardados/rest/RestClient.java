package br.edu.ifsp.hto.listardados.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Classe que representa um cliente REST para realizar requisições
 */
public class RestClient {
    //TODO(5) Declarar um atributo do tipo ListaEsperaService
    private static final RestClient INSTANCE = new RestClient();

    private RestClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ListaEsperaService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        //TODO(6) Atribuir uma instância de ListaEsperaService utilizando o objeto retrofit
            //definido na linha 30
    }

    public static RestClient getInstance(){
        return INSTANCE;
    }

    //TODO(7) Criar um método getListaEsperaService que retorna uma referência para o atributo de classe
}
