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
import br.edu.ifsp.hto.livedata.repositories.ListaEsperaRepository;
import br.edu.ifsp.hto.livedata.utilities.AppExecutors;

public class MainActivity extends AppCompatActivity {
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

        mDb = AppDatabase.getInstance(getApplicationContext());

        loadInitialData();

        carregarListaEspera();
    }

    private void carregarListaEspera(){
        //TODO(6) Trocar o código abaixo para utilizar o ListaEsperaRepository
            //LiveData<List<ListaEspera>> listLiveData = mDb.listaEsperaDAO().loadAllListaEspera();
        LiveData<List<ListaEspera>> listLiveData = new ListaEsperaRepository(getApplication()).getAllListaEspera();

        listLiveData.observe(this, new Observer<List<ListaEspera>>() {
            @Override
            public void onChanged(@Nullable List<ListaEspera> listaEsperas) {
                mListaEsperaAdapter.setListaEspera(listaEsperas);
            }
        });
    }

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
