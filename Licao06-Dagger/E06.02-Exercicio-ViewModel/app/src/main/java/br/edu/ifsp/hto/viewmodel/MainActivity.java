package br.edu.ifsp.hto.viewmodel;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import javax.inject.Inject;

import br.edu.ifsp.hto.viewmodel.adapter.ListaEsperaAdapter;
import br.edu.ifsp.hto.viewmodel.entities.ListaEspera;
import br.edu.ifsp.hto.viewmodel.repositories.ListaEsperaRepository;
import br.edu.ifsp.hto.viewmodel.viewmodel.MainActivityViewModel;
import br.edu.ifsp.hto.viewmodel.viewmodel.MainViewModelFactory;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements ListaEsperaAdapter.OnItemClickListener{
    private ListaEsperaAdapter mListaEsperaAdapter;
    private RecyclerView mListaEsperaRecyclerView;
    private EditText mNomeReservaEditText, mTotalPessoasEditText;

    //TODO(7) Declarar um atributo MainActivityViewModel e utilizar a annotation Inject

    @Inject
    ListaEsperaRepository mListaEsperaRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidInjection.inject(this);

        mListaEsperaAdapter = new ListaEsperaAdapter(this);
        mListaEsperaRecyclerView = findViewById(R.id.rv_lista_espera);
        mListaEsperaRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mListaEsperaRecyclerView.setAdapter(mListaEsperaAdapter);

        mNomeReservaEditText = findViewById(R.id.e_nome_reserva);
        mTotalPessoasEditText = findViewById(R.id.e_total_pessoas);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
                int position = viewHolder.getAdapterPosition();
                List<ListaEspera> listaEsperaList = mListaEsperaAdapter.getListaEspera();
                ListaEspera listaEspera = listaEsperaList.get(position);
                mListaEsperaRepository.removeListaEspera(listaEspera);
            }
        }).attachToRecyclerView(mListaEsperaRecyclerView);

        setupViewModel();
    }

    void setupViewModel(){
        //TODO(8) Remover o código da linha abaixo
        MainViewModelFactory modelFactory = new MainViewModelFactory(mListaEsperaRepository);

        //TODO(9) Remover o código da linha abaixo
        //declarado no passo 7 (DaggerViewModelFactory)
        MainActivityViewModel viewModel = ViewModelProviders.of(this, modelFactory).get(MainActivityViewModel.class);

        //TODO(10) Utilizar o atributo de classe do passo 7 (MainActivityViewModel)
        viewModel.getListaEspera().observe(this, new Observer<List<ListaEspera>>() {
            @Override
            public void onChanged(@Nullable List<ListaEspera> listaEsperas) {
                mListaEsperaAdapter.setListaEspera(listaEsperas);
            }
        });
    }

    public void onClickBtAdicionar(View view) {
        String nomeReserva = mNomeReservaEditText.getText().toString();
        String totalPessoas = mTotalPessoasEditText.getText().toString();

        if(TextUtils.isEmpty(nomeReserva) || TextUtils.isEmpty(totalPessoas)){
            return;
        }

        ListaEspera listaEspera = new ListaEspera(nomeReserva, Integer.parseInt(totalPessoas));
        mListaEsperaRepository.addListaEspera(listaEspera);
    }

    @Override
    public void onClickItem(ListaEspera listaEspera) {
        Intent intent = new Intent(this, AtualizarListaEsperaActiviy.class);
        intent.putExtra(AtualizarListaEsperaActiviy.EXTRA_LISTA_ESPERA, listaEspera);

        startActivity(intent);
    }

}