package br.edu.ifsp.hto.listaespera;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import br.edu.ifsp.hto.listaespera.entities.ListaEsperaEntry;
import br.edu.ifsp.hto.listaespera.rest.ListaEsperaService;
import br.edu.ifsp.hto.listaespera.rest.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AtualizarListaEsperaActiviy extends AppCompatActivity {
    RestClient mRestClient;
    ListaEsperaService mListaEsperaService;
    static final String EXTRA_LISTA_ESPERA = "lista_espera";
    ListaEsperaEntry mListaEspera;
    EditText mNomeReservaEditText, mTotalPessoasEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_lista_espera_activiy);

        mNomeReservaEditText = findViewById(R.id.e_nome_reserva);
        mTotalPessoasEditText = findViewById(R.id.e_total_pessoas);

        configurarWebservice();

        if(getIntent().hasExtra(EXTRA_LISTA_ESPERA)){
            Bundle extras = getIntent().getExtras();
            mListaEspera = (ListaEsperaEntry) extras.get(EXTRA_LISTA_ESPERA);
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
        String nomeReserva = mNomeReservaEditText.getText().toString();
        int totalPessoas = Integer.parseInt(mTotalPessoasEditText.getText().toString());

        mListaEspera.setNomeReserva(nomeReserva);
        mListaEspera.setTotalPessoas(totalPessoas);

        Call<Void> update = mListaEsperaService.update(mListaEspera);

        update.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                finish();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
