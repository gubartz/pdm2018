package br.edu.ifsp.hto.buscagithub;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import br.edu.ifsp.hto.buscagithub.utilities.GitHubService;
import br.edu.ifsp.hto.buscagithub.utilities.RestClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText mBuscaEditText;
    TextView mResultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBuscaEditText = findViewById(R.id.e_busca);
        mResultadoTextView = findViewById(R.id.t_resultado);
    }

    public void onClickBtProcurar(View view) {
        String busca = mBuscaEditText.getText().toString();

        if(TextUtils.isEmpty(busca)){
           return;
        }

        //TODO(9) Chamaro método carregarDados passando o texto para busca
        carregarDados(busca);
    }

    //TODO(1) Criar um método chamado carregarDados que recebe um String de busca como parâmetro
        //Dentro do método
    private void carregarDados(String busca){
        //TODO(2) Instanciar o RestClient
        RestClient restClient = new RestClient();
        //TODO(3) Executar o método getGitHubService e atribuir o retorno para uma variável compatível
        GitHubService gitHubService = restClient.getGitHubService();
        //TODO(4) Executar o método listRepositories passando o String de busca
            //Atribuir o retorno para uma variávle compatível
        Call<ResponseBody> responseBodyCall = gitHubService.listRepositories(busca);
        //TODO(5) Executar o método enqueue com uma instância de Callback
            //TODO(6) Sobrescrever os métodos onResponse e onFailure
            //TODO(7) No método onResponse chamar o método body().string() no parâmetro response
            //TODO(8) Utilizar o retorno do método body para preencher o conteúdo no TextViewdo resultado
        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    mResultadoTextView.setText(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
