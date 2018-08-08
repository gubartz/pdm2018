package br.edu.ifsp.hto.buscagithub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

        //TODO(10) Instanciar um objeto GitHubAsyncTask
        //TODO(11) Chamar o método execute passando o texto digitado pelo usuário no mBuscaEditText
    }

    //TODO(1) Definir uma classe chamada GitHubAsyncTask
    //TODO(2) Esteder a classe de AsyncTask<String, Void, String>

        //TODO(3) Definir o método doInBackground
            //TODO(4) Dentro de doInBackground
            //TODO(5) Recuperar do parâmetro do método o primeiro elemento do string varargs
                //Esse String representa o texto da busca
            //TODO(6) Passar a lógica de chamada ao RestClient, que está em onClickBtProcurar, para o método doInBackground
                //Utilizar o valor recuperado no passo 5 e utilizá-lo como argumento para o método listRepositories
                //Utilizar body().string() para recuperar a resposta

        //TODO(7) Sobrescrever o método onPostExecute
            //TODO(8) Dentro do método onPostExecute
            //TODO(9) Utilizar o parâmetro do método, que é o retorno do service, para atribuir o conteúdo a mResultadoTextView
}
