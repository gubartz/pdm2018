package br.edu.ifsp.hto.livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ItemTouchHelper;

import java.util.List;

import br.edu.ifsp.hto.livedata.adapter.ListaEsperaAdapter;
import br.edu.ifsp.hto.livedata.database.AppDatabase;
import br.edu.ifsp.hto.livedata.entities.ListaEspera;
import br.edu.ifsp.hto.livedata.repositories.ListaEsperaRepository;
import br.edu.ifsp.hto.livedata.utilities.AppExecutors;

public class MainActivity extends AppCompatActivity implements ListaEsperaAdapter.OnItemClickListener{
    //TODO(26) Remover o atributo mDb pois não será mais utilizado
    private AppDatabase mDb;
    private ListaEsperaAdapter mListaEsperaAdapter;
    private RecyclerView mListaEsperaRecyclerView;
    //TODO(12) Definir atributos para os EditTexts do XML

    //TODO(9) Definir um atributo para o ListaEsperaRepository

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListaEsperaAdapter = new ListaEsperaAdapter(this);
        mListaEsperaRecyclerView = findViewById(R.id.rv_lista_espera);
        mListaEsperaRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mListaEsperaRecyclerView.setAdapter(mListaEsperaAdapter);

        //TODO(25) Remover o código abaixo
        mDb = AppDatabase.getInstance(getApplicationContext());

        //TODO(13) Recuperar as referências do XML para os atributos de classe (EditTexts)

        //TODO(7) O método loadInitialData não é mais necessário
        loadInitialData();

        //TODO(10) Instanciar um ListaEsperaRepository e atribuí-lo ao atributo de classe correspondente

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
                //TODO(24) Utilizar o repository para remoção do item deslizado
            }
        }).attachToRecyclerView(mListaEsperaRecyclerView);

        carregarListaEspera();
    }

    private void carregarListaEspera(){
        //TODO(11) Ajustar o código abaixo para usar o atributo de classe ListaEsperaRepository
        LiveData<List<ListaEspera>> listLiveData = new ListaEsperaRepository(getApplication()).getAllListaEspera();


        listLiveData.observe(this, new Observer<List<ListaEspera>>() {
            @Override
            public void onChanged(@Nullable List<ListaEspera> listaEsperas) {
                mListaEsperaAdapter.setListaEspera(listaEsperas);
            }
        });
    }

    //TODO(15) Adicionar o método referente ao definido no onClick do botão definido no XML
        //Dentro do método
        //TODO(16) Recuperar os valores digitados pelo usuário

        //TODO(17) Caso algum campo esteja vazio encerre a execução da função

        //TODO(18) Utilize o repositório para inserir os valores no BD
            //TODO(19) Teste o aplicativo para verificar a inserção de dados

    @Override
    public void onClickItem(ListaEspera listaEspera) {
        Intent intent = new Intent(this, AtualizarListaEsperaActiviy.class);
        intent.putExtra(AtualizarListaEsperaActiviy.EXTRA_LISTA_ESPERA, listaEspera);

        startActivity(intent);
    }

    //TODO(8) O método loadInitialData não é mais necessário
    private void loadInitialData(){
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mDb.listaEsperaDAO().clearTable();
                mDb.listaEsperaDAO().insertListaEspera(ListaEspera.populateData());
            }
        });
    }
}