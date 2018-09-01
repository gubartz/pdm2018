package br.edu.ifsp.hto.viewmodel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import br.edu.ifsp.hto.viewmodel.entities.ListaEspera;
import br.edu.ifsp.hto.viewmodel.repositories.ListaEsperaRepository;

public class AtualizarListaEsperaActiviy extends AppCompatActivity {
    static final String EXTRA_LISTA_ESPERA = "lista_espera";
    ListaEspera mListaEspera;
    EditText mNomeReservaEditText, mTotalPessoasEditText;
    ListaEsperaRepository mListaEsperaRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_lista_espera_activiy);

        mNomeReservaEditText = findViewById(R.id.e_nome_reserva);
        mTotalPessoasEditText = findViewById(R.id.e_total_pessoas);

        mListaEsperaRepository = new ListaEsperaRepository(getApplication());

        if(getIntent().hasExtra(EXTRA_LISTA_ESPERA)){
            Bundle extras = getIntent().getExtras();
            mListaEspera = (ListaEspera) extras.get(EXTRA_LISTA_ESPERA);

            mTotalPessoasEditText.setText(String.valueOf(mListaEspera.getTotalPessoas()));
            mNomeReservaEditText.setText(mListaEspera.getNomeReserva());
        }
    }

    public void onClickBtAtualizar(View view) {
        String nomeReserva = mNomeReservaEditText.getText().toString();
        String totalPessoas = mTotalPessoasEditText.getText().toString();

        if(TextUtils.isEmpty(nomeReserva) || TextUtils.isEmpty(totalPessoas)){
            return;
        }

        ListaEspera listaEspera = new ListaEspera(mListaEspera.getId(),
                nomeReserva,
                Integer.parseInt(totalPessoas),
                mListaEspera.getDataCadastro());
        mListaEsperaRepository.updateListaEspera(listaEspera);

        finish();
    }
}
