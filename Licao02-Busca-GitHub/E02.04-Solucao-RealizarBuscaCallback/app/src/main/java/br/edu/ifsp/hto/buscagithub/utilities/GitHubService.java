package br.edu.ifsp.hto.buscagithub.utilities;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitHubService {
    String GITHUB_BASE_URL =
            "https://api.github.com/";

    /**
     * Retorna uma lista com os resultados dos repositórios encontrados com base no texto informado.
     * @param search Texto para procurar por repositórios
     * @return Texto com o resultado dos repositórios encontrados
     */
    @GET("search/repositories")
    Call<ResponseBody> listRepositories(@Query("q") String search);
}
