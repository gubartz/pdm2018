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
    private ListaEsperaService listaEsperaService;
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

        listaEsperaService = retrofit.create(ListaEsperaService.class);
    }

    public static RestClient getInstance(){
        return INSTANCE;
    }

    public ListaEsperaService getListaEsperaService() {
        return listaEsperaService;
    }
}
