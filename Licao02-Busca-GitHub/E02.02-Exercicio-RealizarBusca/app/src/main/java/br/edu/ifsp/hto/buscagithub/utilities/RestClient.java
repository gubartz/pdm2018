package br.edu.ifsp.hto.buscagithub.utilities;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Classe que representa uma cliente REST para realizar chamadas à API do GitHub
 */
public class RestClient {
    private GitHubService gitHubService;

    public RestClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GitHubService.GITHUB_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        gitHubService = retrofit.create(GitHubService.class);
    }

    /**
     * Método que retorna um GitHubService para realizar uma chamada REST
     *
     * @return Retorna um GitHubService, que representa uma chamada REST
     */
    public GitHubService getGitHubService() {
        return gitHubService;
    }
}