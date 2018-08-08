package br.edu.ifsp.hto.buscagithub;

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

    //TODO(3) Definir um método onClickBtProcurar(View view).
        // Esse método será executado quando o usuário clicar no botão Procurar.
    public void onClickBtProcurar(View view) {
        //TODO(4) Dentro do método onClickBtProcurar
        //TODO(5) Recuperar o texto digitado pelo usuário no EditText
            //Verificar se o texto não está vazio. Utilize o TextUtils.isEmpty
            //Se o texto estiver vazio utilize return para encerrar o método
        String busca = mBuscaEditText.getText().toString();

        if(TextUtils.isEmpty(busca)){
           return;
        }

        //TODO(6) Instanciar um objeto RestClient
        RestClient restClient = new RestClient();
        //TODO(7) Chamar o método getGitHubService.
            // Atribuir seu retorno para uma variável correspondente.
        GitHubService gitHubService = restClient.getGitHubService();
        //TODO(8) Chamaro método listRepositories na variável recuperada no passo anterior.
            // Atribuir seu retorno para uma variável correspondente
        Call<ResponseBody> call = gitHubService.listRepositories(busca);
        //TODO(9) Chamar o método execute na variável recuperada no passo anterior.
        //TODO(10) Executar o programa e identificar o erro que ocorre.
        try {
            call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
