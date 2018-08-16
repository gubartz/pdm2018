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
    static final String EXTRA_LISTA_ESPERA = "lista_espera";
    //TODO(28) Declarar um atributo do tipo ListaEspera
    ListaEspera mListaEspera;
    //TODO(29) Declarar atributos para os EditTexts definidos no layout desta activity
    EditText mNomeReservaEditText, mTotalPessoasEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_lista_espera_activiy);

        //TODO(30) Atribuir os elementos do XML para os atributos de classe
        mNomeReservaEditText = findViewById(R.id.e_nome_reserva);
        mTotalPessoasEditText = findViewById(R.id.e_total_pessoas);

        configurarWebservice();

        //TODO(31) Recuperar o lista_espera utilizando getIntent e getExtras
        if(getIntent().hasExtra(EXTRA_LISTA_ESPERA)){
            Bundle extras = getIntent().getExtras();
            //TODO(32) Atribuir o objeto recuperado para o atributo de classe (definido no passo 26)
            mListaEspera = (ListaEspera) extras.get(EXTRA_LISTA_ESPERA);

            //TODO(33) Preencher os EditTexts com os valores recuperados
            mTotalPessoasEditText.setText(String.valueOf(mListaEspera.getTotalPessoas()));
            mNomeReservaEditText.setText(mListaEspera.getNomeReserva());
        }
    }

    private void configurarWebservice(){
        mRestClient = RestClient.getInstance();
        mListaEsperaService = mRestClient.getListaEsperaService();
    }

    //No método onClickBtAtualizar
    public void onClickBtAtualizar(View view) {
        //TODO(34) Recuperar os valores digitados pelo usuário
        String nomeReserva = mNomeReservaEditText.getText().toString();
        int totalPessoas = Integer.parseInt(mTotalPessoasEditText.getText().toString());

        //TODO(35) Atualizar os valores recuperados para o atributo de classe ListaEspera
        mListaEspera.setNomeReserva(nomeReserva);
        mListaEspera.setTotalPessoas(totalPessoas);

        //TODO(36) Utilizar o mListaEsperaService realizar a chamada de atualização
        Call<Void> update = mListaEsperaService.update(mListaEspera);

        update.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                //TODO(37) Chamar o método finish
                finish();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
