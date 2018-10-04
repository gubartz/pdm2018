package br.edu.ifsp.hto.viewmodel;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import br.edu.ifsp.hto.viewmodel.entities.ListaEspera;
import br.edu.ifsp.hto.viewmodel.viewmodel.AtualizarListaEsperaViewModel;
import br.edu.ifsp.hto.viewmodel.viewmodel.ViewModelFactory;

public class AtualizarListaEsperaActiviy extends AppCompatActivity {
    static final String EXTRA_LISTA_ESPERA = "lista_espera";
    ListaEspera mListaEspera;
    EditText mNomeReservaEditText, mTotalPessoasEditText;
    //TODO(17) Remover o atributo abaixo
    //ListaEsperaRepository mListaEsperaRepository;
    //TODO(18) Declarar um atributo para um AtualizarListaEsperaViewModel
    AtualizarListaEsperaViewModel mAtualizarListaEsperaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_lista_espera_activiy);

        mNomeReservaEditText = findViewById(R.id.e_nome_reserva);
        mTotalPessoasEditText = findViewById(R.id.e_total_pessoas);

        //TODO(19) Remover o código abaixo
        //mListaEsperaRepository = new ListaEsperaRepository(getApplication());

        if(getIntent().hasExtra(EXTRA_LISTA_ESPERA)){
            Bundle extras = getIntent().getExtras();
            mListaEspera = (ListaEspera) extras.get(EXTRA_LISTA_ESPERA);

            mTotalPessoasEditText.setText(String.valueOf(mListaEspera.getTotalPessoas()));
            mNomeReservaEditText.setText(mListaEspera.getNomeReserva());
        }
        //TODO(25) Chamar o método setupViewModel
        setupViewModel();
    }

    //TODO(20) Criar um método chamado setupViewModel
        //Dentro de setupViewModel
    private void setupViewModel(){
        //TODO(21) Instanciar um objeto ViewModelFactory
        ViewModelFactory modelFactory = new ViewModelFactory(getApplication());

        //TODO(22) Utilizar ViewModelProviders.of(activity, factory) para instanciar um AtualizarListaEsperaViewModel
        //e atribuir a referência para o atributo de classe do passo 19
        mAtualizarListaEsperaViewModel= ViewModelProviders.of(this, modelFactory).get(AtualizarListaEsperaViewModel.class);
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
        //TODO(23) Remover o código abaixo
        //mListaEsperaRepository.updateListaEspera(listaEspera);
        //TODO(24) Utilizar o viewModel para atualizar a lista de espera
        mAtualizarListaEsperaViewModel.updateListaEspera(listaEspera);

        finish();
    }
}
