package br.edu.ifsp.hto.livedata;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import br.edu.ifsp.hto.livedata.adapter.ListaEsperaAdapter;
import br.edu.ifsp.hto.livedata.database.AppDatabase;
import br.edu.ifsp.hto.livedata.entities.ListaEspera;
import br.edu.ifsp.hto.livedata.repositories.ListaEsperaRepository;
import br.edu.ifsp.hto.livedata.utilities.AppExecutors;

public class MainActivity extends AppCompatActivity implements ListaEsperaAdapter.OnItemClickListener{
    private ListaEsperaAdapter mListaEsperaAdapter;
    private RecyclerView mListaEsperaRecyclerView;
    //TODO(12) Definir atributos para os EditTexts do XML
    private EditText mNomeReservaEditText, mTotalPessoasEditText;

    //TODO(9) Definir um atributo para o ListaEsperaRepository
    private ListaEsperaRepository mListaEsperaRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListaEsperaAdapter = new ListaEsperaAdapter(this);
        mListaEsperaRecyclerView = findViewById(R.id.rv_lista_espera);
        mListaEsperaRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mListaEsperaRecyclerView.setAdapter(mListaEsperaAdapter);

        //TODO(13) Recuperar as referências do XML para os atributos de classe (EditTexts)
        mNomeReservaEditText = findViewById(R.id.e_nome_reserva);
        mTotalPessoasEditText = findViewById(R.id.e_total_pessoas);

        //TODO(7) O método loadInitialData não é mais necessário
        //loadInitialData();

        //TODO(10) Instanciar um ListaEsperaRepository e atribuí-lo ao atributo de classe correspondente
        mListaEsperaRepository = new ListaEsperaRepository(getApplication());

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
                //TODO(24) Utilizar o repository para remoção do item deslizado
                int position = viewHolder.getAdapterPosition();
                List<ListaEspera> listaEsperaList = mListaEsperaAdapter.getListaEspera();
                ListaEspera listaEspera = listaEsperaList.get(position);
                mListaEsperaRepository.removeListaEspera(listaEspera);

            }
        }).attachToRecyclerView(mListaEsperaRecyclerView);

        carregarListaEspera();
    }

    private void carregarListaEspera(){
        //TODO(11) Ajustar o código abaixo para usar o atributo de classe ListaEsperaRepository
            //LiveData<List<ListaEspera>> listLiveData = new ListaEsperaRepository(getApplication()).getAllListaEspera();
        LiveData<List<ListaEspera>> listLiveData = mListaEsperaRepository.getAllListaEspera();

        listLiveData.observe(this, new Observer<List<ListaEspera>>() {
            @Override
            public void onChanged(@Nullable List<ListaEspera> listaEsperas) {
                mListaEsperaAdapter.setListaEspera(listaEsperas);
            }
        });
    }

    //TODO(15) Adicionar o método referente ao definido no onClick do botão definido no XML
        //Dentro do método
    public void onClickBtAdicionar(View view) {
        //TODO(16) Recuperar os valores digitados pelo usuário
        String nomeReserva = mNomeReservaEditText.getText().toString();
        String totalPessoas = mTotalPessoasEditText.getText().toString();

        //TODO(17) Caso algum campo esteja vazio encerre a execução da função
        if(TextUtils.isEmpty(nomeReserva) || TextUtils.isEmpty(totalPessoas)){
            return;
        }

        //TODO(18) Utilize o repositório para inserir os valores no BD
            //TODO(19) Teste o aplicativo para verificar a inserção de dados
        ListaEspera listaEspera = new ListaEspera(nomeReserva, Integer.parseInt(totalPessoas));
        mListaEsperaRepository.addListaEspera(listaEspera);
    }

    @Override
    public void onClickItem(ListaEspera listaEspera) {
        Intent intent = new Intent(this, AtualizarListaEsperaActiviy.class);
        intent.putExtra(AtualizarListaEsperaActiviy.EXTRA_LISTA_ESPERA, listaEspera);

        startActivity(intent);
    }

    //TODO(8) O método loadInitialData não é mais necessário
//    private void loadInitialData(){
//        AppExecutors.getInstance().diskIO().execute(new Runnable() {
//            @Override
//            public void run() {
//                mDb.listaEsperaDAO().clearTable();
//                mDb.listaEsperaDAO().insertListaEspera(ListaEspera.populateData());
//            }
//        });
//    }

}
