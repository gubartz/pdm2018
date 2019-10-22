package br.edu.ifsp.hto.livedata;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;

import br.edu.ifsp.hto.livedata.entities.ListaEspera;

public class AtualizarListaEsperaActiviy extends AppCompatActivity {
    static final String EXTRA_LISTA_ESPERA = "lista_espera";
    ListaEspera mListaEspera;
    EditText mNomeReservaEditText, mTotalPessoasEditText;
    //TODO(20) Definir um atributo para um ListaEsperaRepository

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_lista_espera_activiy);

        mNomeReservaEditText = findViewById(R.id.e_nome_reserva);
        mTotalPessoasEditText = findViewById(R.id.e_total_pessoas);

        //TODO(21) Atribuir uma instância de um ListaEsperaRepository para o atributo de classe

        if(getIntent().hasExtra(EXTRA_LISTA_ESPERA)){
            Bundle extras = getIntent().getExtras();
            mListaEspera = (ListaEspera) extras.get(EXTRA_LISTA_ESPERA);

            mTotalPessoasEditText.setText(String.valueOf(mListaEspera.getTotalPessoas()));
            mNomeReservaEditText.setText(mListaEspera.getNomeReserva());
        }
    }

    //TODO(22) Utilizar o repository para atualizar o ListaEspera
    public void onClickBtAtualizar(View view) {
        //TODO(23) Chamar o método finish na última linha do método para encerrar a Activity
    }
}
