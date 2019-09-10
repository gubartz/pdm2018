package br.edu.ifsp.hto.listaespera;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

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
                List<ListaEsperaEntry> listaEspera = response.body();
                mListaEsperaAdapter.setListaEspera(listaEspera);
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
            //TODO(5) Recuperar o nome da reserva do TextView em activity_main.xml
            //TODO(6) Recuperar o total de pessoas na reserva do TextView em activity_main.xml
            //TODO(7) Criar um objeto do tipo ListaEsperaEntry com o nome da reserva e o total de pessoas
            //TODO(9) Chamar o método salvarListaEspera passando o objeto criado
    //TODO(8) Definir um método salvarListaEspera, que recebe um ListaEsperaEntry
        //Dentro de salvarListaEspera
            //TODO(10) Recuperar uma instância de RestClient
            //TODO(11) Recuperar o ListaEsperaService para uma variável compatível
            //TODO(12) Chamar o método add com o ListaEsperaEntry definido como parâmetro do método
                //Atribuir o retorno para uma variável compatível
        //TODO(13) Chamar o método enqueue passando um Callback correspondente
            //Dentro do Callback
                //TODO(17) Em onResponse recupere o corpo da resposta com response.body()
                    //Atribuir o retorno para uma variável compatível
                //TODO(18) Se a resposta for diferente de nula
                    //TODO(19) Adicionar o ListaEsperaEntry recuperado no atributo da classe que mantém a lista
                    //TODO(20) Utilizar o método setListaEspera do Adapter para atualizar a lista
}
