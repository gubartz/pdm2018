package br.edu.ifsp.hto.listaespera;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.util.List;

import br.edu.ifsp.hto.listaespera.entities.ListaEspera;
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
    //TODO(14) Definir um atributo para manter um lista de ListaEspera
    List<ListaEspera> mListaEspera;

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

        carregarDados();
    }

    private void carregarDados(){
        mIndicadorCarregarProgressBar.setVisibility(View.VISIBLE);

        RestClient restClient = RestClient.getInstance();

        ListaEsperaService listaEsperaService = restClient.getListaEsperaService();

        Call<List<ListaEspera>> list = listaEsperaService.list();

        list.enqueue(new Callback<List<ListaEspera>>() {

            @Override
            public void onResponse(Call<List<ListaEspera>> call, Response<List<ListaEspera>> response) {
                //TODO(15) Trocar o listaEspera pelo atributo de classe definido no passo 15
                mListaEspera = response.body();
                mListaEsperaAdapter.setListaEspera(mListaEspera);
                mIndicadorCarregarProgressBar.setVisibility(View.INVISIBLE);
                mListaEsperaView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<List<ListaEspera>> call, Throwable t) {
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

        //TODO(7) Criar um objeto do tipo ListaEspera com o nome da reserva e o total de pessoas
        ListaEspera listaEspera = new ListaEspera(nomeReserva, totalReserva);

        //TODO(9) Chamar o método salvarListaEspera passando o objeto criado
        salvarListaEspera(listaEspera);
    }

    //TODO(8) Definir um método salvarListaEspera, que recebe um ListaEspera
        //Dentro de salvarListaEspera
    private void salvarListaEspera(ListaEspera listaEspera){
        //TODO(10) Recuperar uma instância de RestClient
        RestClient restClient = RestClient.getInstance();
        //TODO(11) Recuperar o ListaEsperaService para uma variável compatível
        ListaEsperaService listaEsperaService = restClient.getListaEsperaService();
        //TODO(12) Chamar o método add com o ListaEspera definido como parâmetro do método
            //Atribuir o retorno para uma variável compatível
        Call<ListaEspera> add = listaEsperaService.add(listaEspera);
        //TODO(13) Chamar o método enqueue passando um Callback correspondente
            //Dentro do Callback
        add.enqueue(new Callback<ListaEspera>() {
            @Override
            public void onResponse(Call<ListaEspera> call, Response<ListaEspera> response) {
                //TODO(16) Em onResponse recupere o corpo da resposta com response.body()
                    //Atribuir o retorno para uma variável compatível
                ListaEspera listaEspera = response.body();
                //TODO(17) Se a resposta for diferente de nula
                if(listaEspera != null){
                    //TODO(18) Adicionar o ListaEspera recuperado no atributo da classe que mantém a lista
                    mListaEspera.add(listaEspera);
                    //TODO(19) Utilizar o método setListaEspera do Adapter para atualizar a lista
                    mListaEsperaAdapter.setListaEspera(mListaEspera);
                }
            }

            @Override
            public void onFailure(Call<ListaEspera> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}