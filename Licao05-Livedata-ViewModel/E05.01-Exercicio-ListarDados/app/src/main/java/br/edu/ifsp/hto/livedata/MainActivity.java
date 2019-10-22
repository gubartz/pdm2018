package br.edu.ifsp.hto.livedata;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.edu.ifsp.hto.livedata.adapter.ListaEsperaAdapter;

public class MainActivity extends AppCompatActivity {
    //TODO(18) Declarar um atributo de classe para manter o AppDatabase
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

        //TODO(24) Tirar o comentário do código abaixo
        //loadInitialData();

        //TODO(25) Chamar o método carregarListaEspera
    }

    //TODO(20) Definir um método chamado carregarListaEspera
        //Dentro de carregarListaEspera
        //TODO(21) Utilizar a referência ao AppDatabase para recuperar os registros de ListaEspera
            //Atribuir o retorno para uma variável de tipo compatível
        //TODO(22) Utilizar o método observe e atualizar a UI (método setListaEspera do adapter)
            //Passar this como primeiro argumento e um Observer no segundo
            //Sobrescrever o método onChanged e atualizar a UI utilizando o adapter


    //TODO(23) Tirar os comentários do código abaixo
        //Utilizar em mDb o atributo de classe que você definiu no passo 18
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
