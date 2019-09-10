package br.edu.ifsp.hto.listaespera;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.hto.listaespera.entities.ListaEsperaEntry;
import br.edu.ifsp.hto.listaespera.rest.ListaEsperaService;
import br.edu.ifsp.hto.listaespera.rest.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText mNomeReservaEditText, mTotalPessoasEditText;
    ProgressBar mIndicadorCarregarProgressBar;
    RecyclerView mListaEsperaRecyclerView;
    ListaEsperaAdapter mListaEsperaAdapter;
    LinearLayout mListaEsperaView;
    //TODO(14) Definir um atributo para manter um lista de ListaEsperaEntry
    List<ListaEsperaEntry> mListaEspera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNomeReservaEditText = findViewById(R.id.e_nome_reserva);
        mTotalPessoasEditText = findViewById(R.id.e_total_pessoas);
        mIndicadorCarregarProgressBar = findViewById(R.id.pb_indicador_carregar);
        mListaEsperaRecyclerView = findViewById(R.id.rv_lista_espera);
        mListaEsperaView = findViewById(R.id.lista_espera_view);

        mListaEsperaRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mListaEsperaAdapter = new ListaEsperaAdapter();

        mListaEsperaRecyclerView.setAdapter(mListaEsperaAdapter);

        //TODO(15) Inicializar o atributo de classe definido no passo 14 com um ArrayList
        mListaEspera = new ArrayList<>();

        carregarDados();
    }

    private void carregarDados(){
        mIndicadorCarregarProgressBar.setVisibility(View.VISIBLE);

        RestClient restClient = RestClient.getInstance();

        ListaEsperaService listaEsperaService = restClient.getListaEsperaService();

        Call<List<ListaEsperaEntry>> list = listaEsperaService.list();

        list.enqueue(new Callback<List<ListaEsperaEntry>>() {

            @Override
            public void onResponse(Call<List<ListaEsperaEntry>> call, Response<List<ListaEsperaEntry>> response) {
                //TODO(16) Trocar o listaEspera pelo atributo de classe definido no passo 15
                mListaEspera = response.body();
                mListaEsperaAdapter.setListaEspera(mListaEspera);
                mIndicadorCarregarProgressBar.setVisibility(View.INVISIBLE);
                mListaEsperaView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<List<ListaEsperaEntry>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    //TODO(3) Definir um método onClickBtAdicionar(View view)
        //Dentro do método onClickBtAdicionar
    public void onClickBtAdicionar(View view) {
        //TODO(5) Recuperar o nome da reserva do TextView em activity_main.xml
        String nomeReserva = mNomeReservaEditText.getText().toString();

        //TODO(6) Recuperar o total de pessoas na reserva do TextView em activity_main.xml
        int totalReserva = Integer.parseInt(mTotalPessoasEditText.getText().toString());

        //TODO(7) Criar um objeto do tipo ListaEsperaEntry com o nome da reserva e o total de pessoas
        ListaEsperaEntry listaEspera = new ListaEsperaEntry(nomeReserva, totalReserva);

        //TODO(9) Chamar o método salvarListaEspera passando o objeto criado
        salvarListaEspera(listaEspera);
    }

    //TODO(8) Definir um método salvarListaEspera, que recebe um ListaEsperaEntry
        //Dentro de salvarListaEspera
    private void salvarListaEspera(ListaEsperaEntry listaEspera){
        //TODO(10) Recuperar uma instância de RestClient
        RestClient restClient = RestClient.getInstance();
        //TODO(11) Recuperar o ListaEsperaService para uma variável compatível
        ListaEsperaService listaEsperaService = restClient.getListaEsperaService();
        //TODO(12) Chamar o método add com o ListaEsperaEntry definido como parâmetro do método
            //Atribuir o retorno para uma variável compatível
        Call<ListaEsperaEntry> add = listaEsperaService.add(listaEspera);
        //TODO(13) Chamar o método enqueue passando um Callback correspondente
            //Dentro do Callback
        add.enqueue(new Callback<ListaEsperaEntry>() {
            @Override
            public void onResponse(Call<ListaEsperaEntry> call, Response<ListaEsperaEntry> response) {
                //TODO(17) Em onResponse recupere o corpo da resposta com response.body()
                    //Atribuir o retorno para uma variável compatível
                ListaEsperaEntry listaEspera = response.body();
                //TODO(18) Se a resposta for diferente de nula
                if(listaEspera != null){
                    //TODO(19) Adicionar o ListaEsperaEntry recuperado no atributo da classe que mantém a lista
                    mListaEspera.add(listaEspera);
                    //TODO(20) Utilizar o método setListaEspera do Adapter para atualizar a lista
                    mListaEsperaAdapter.setListaEspera(mListaEspera);
                }
            }

            @Override
            public void onFailure(Call<ListaEsperaEntry> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
