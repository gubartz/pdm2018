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
    //TODO(28) Declarar atributos para os campos de EditText definidos em activity_main.xml
    EditText mNomeReservaEditText, mTotalPessoasEditText;

    //TODO(29) Declarar atributo para o ProgressBar definido em activity_main.xml
    ProgressBar mIndicadorCarregarProgressBar;

    //TODO(30) Declarar atributo para o RecyclerView definido em activity_main.xml
    RecyclerView mListaEsperaRecyclerView;

    //TODO(31) Declarar um atributo para o ListaEsperaAdapter
    ListaEsperaAdapter mListaEsperaAdapter;

    //TODO(32) Declarar um atributo para o LinearLayout lista_espera_view definido em activity_main.xml
    LinearLayout mListaEsperaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO(33) Recuperar uma referência do XML para cada item defino nos atributos de classe
        mNomeReservaEditText = findViewById(R.id.e_nome_reserva);
        mTotalPessoasEditText = findViewById(R.id.e_total_pessoas);
        mIndicadorCarregarProgressBar = findViewById(R.id.pb_indicador_carregar);
        mListaEsperaRecyclerView = findViewById(R.id.rv_lista_espera);
        mListaEsperaView = findViewById(R.id.lista_espera_view);

        //TODO(34) Definir o LayoutManger do RecyclerView
        mListaEsperaRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //TODO(35) Criar uma instância do ListaEsperaAdapter e atribuir para o atributo de classe
        mListaEsperaAdapter = new ListaEsperaAdapter();

        //TODO(36) Definiro adapter do RecyclerView para como sendo o atributo de classe
        mListaEsperaRecyclerView.setAdapter(mListaEsperaAdapter);

        //TODO(47) Chamar o método carregarDados
        carregarDados();
    }

    //TODO(37) Criar um método chamdo carregarDados
        //Dentro de carregarDados()
    private void carregarDados(){
        //TODO(38) Utilize o atributo de classe que está com ProgressBar e o método setVisibility
            //para torná-lo visível
        mIndicadorCarregarProgressBar.setVisibility(View.VISIBLE);

        //TODO(39) Recuperar uma instância de RestClient pelo método getInstance
        RestClient restClient = RestClient.getInstance();

        //TODO(40) Recuperar um ListaEsperaService por meio do RestClient
        ListaEsperaService listaEsperaService = restClient.getListaEsperaService();

        //TODO(41) Chamaro método list e atribuir para uma variável compatível
        Call<List<ListaEspera>> list = listaEsperaService.list();

        //TODO(42) Utilizar o método enqueue passando um Callback. Implementar os métodos necessários
            //Dentro do Callback
        list.enqueue(new Callback<List<ListaEspera>>() {

            @Override
            public void onResponse(Call<List<ListaEspera>> call, Response<List<ListaEspera>> response) {
                //TODO(43) Em onResponse recupera o corpo da mensagem com response.body(). Atribuir para uma variável compatível
                List<ListaEspera> listaEspera = response.body();
                //TODO(44) Utilizar o método setListaEspera do adapter a passar a lista recuperada
                mListaEsperaAdapter.setListaEspera(listaEspera);

                //TODO(45) Esconder a barra de progresso (Verificar o passo 38)
                mIndicadorCarregarProgressBar.setVisibility(View.INVISIBLE);
                //TODO(46) Mostar o conteúdo de lista_espera_view (igual ao passo 38, mas para o lista_espera_view)
                mListaEsperaView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<List<ListaEspera>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
