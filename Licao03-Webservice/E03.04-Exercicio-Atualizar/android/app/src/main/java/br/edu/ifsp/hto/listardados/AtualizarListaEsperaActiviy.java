package br.edu.ifsp.hto.listardados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.edu.ifsp.hto.listardados.entities.ListaEspera;
import br.edu.ifsp.hto.listardados.rest.ListaEsperaService;
import br.edu.ifsp.hto.listardados.rest.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AtualizarListaEsperaActiviy extends AppCompatActivity {
    RestClient mRestClient;
    ListaEsperaService mListaEsperaService;
    //TODO(23) Declarar um atributo String final e static chamado EXTRA_LISTA_ESPERA
        //Definir o conteúdo como lista_espera
    //TODO(28) Declarar um atributo do tipo ListaEspera
    //TODO(29) Declarar atributos para os EditTexts definidos no layout desta activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_lista_espera_activiy);

        //TODO(30) Atribuir os elementos do XML para os atributos de classe
        configurarWebservice();

        //TODO(31) Recuperar o lista_espera utilizando getIntent e getExtras
            //TODO(32) Atribuir o objeto recuperado para o atributo de classe (definido no passo 26)
            //TODO(33) Preencher os EditTexts com os valores recuperados
    }

    private void configurarWebservice(){
        mRestClient = RestClient.getInstance();
        mListaEsperaService = mRestClient.getListaEsperaService();
    }

    //No método onClickBtAtualizar
    //TODO(34) Recuperar os valores digitados pelo usuário
    //TODO(35) Atualizar os valores recuperados para o atributo de classe ListaEspera
    //TODO(36) Utilizar o mListaEsperaService realizar a chamada de atualização

}
