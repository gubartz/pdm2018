package br.edu.ifsp.hto.livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.ifsp.hto.livedata.adapter.ListaEsperaAdapter;
import br.edu.ifsp.hto.livedata.database.AppDatabase;
import br.edu.ifsp.hto.livedata.entities.ListaEspera;
import br.edu.ifsp.hto.livedata.utilities.AppExecutors;

public class MainActivity extends AppCompatActivity {
    //TODO(18) Declarar um atributo de classe para manter o AppDatabase
    private AppDatabase mDb;
    private ListaEsperaAdapter mListaEsperaAdapter;
    private RecyclerView mListaEsperaRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListaEsperaAdapter = new ListaEsperaAdapter();
        mListaEsperaRecyclerView = findViewById(R.id.rv_lista_espera);
        mListaEsperaRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mListaEsperaRecyclerView.setAdapter(mListaEsperaAdapter);


        //TODO(19) Atribuir uma instância de AppDatabase para o atributo de classe
        mDb = AppDatabase.getInstance(getApplicationContext());

        //TODO(24) Tirar o comentário do código abaixo
        loadInitialData();

        //TODO(25) Chamar o método carregarListaEspera
        carregarListaEspera();
    }

    //TODO(20) Definir um método chamado carregarListaEspera
        //Dentro de carregarListaEspera
    private void carregarListaEspera(){
        //TODO(21) Utilizar a referência ao AppDatabase para recuperar os registros de ListaEspera
            //Atribuir o retorno para uma variável de tipo compatível
        LiveData<List<ListaEspera>> listLiveData = mDb.listaEsperaDAO().loadAllListaEspera();
        //TODO(22) Utilizar o método observe e atualizar a UI (método setListaEspera do adapter)
            //Passar this como primeiro argumento e um Observer no segundo
            //Sobrescrever o método onChanged e atualizar a UI utilizando o adapter
        listLiveData.observe(this, new Observer<List<ListaEspera>>() {
            @Override
            public void onChanged(@Nullable List<ListaEspera> listaEsperas) {
                mListaEsperaAdapter.setListaEspera(listaEsperas);
            }
        });
    }

    //TODO(23) Tirar os comentários do código abaixo
        //Utilizar em mDb o atributo de classe que você definiu no passo 18
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
