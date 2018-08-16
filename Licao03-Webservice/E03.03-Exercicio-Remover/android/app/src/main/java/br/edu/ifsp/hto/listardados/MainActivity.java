package br.edu.ifsp.hto.listardados;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.util.List;

import br.edu.ifsp.hto.listardados.entities.ListaEspera;
import br.edu.ifsp.hto.listardados.rest.ListaEsperaService;
import br.edu.ifsp.hto.listardados.rest.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText mNomeReservaEditText, mTotalPessoasEditText;
    ProgressBar mIndicadorCarregarProgressBar;
    RecyclerView mListaEsperaRecyclerView;
    ListaEsperaAdapter mListaEsperaAdapter;
    LinearLayout mListaEsperaView;
    List<ListaEspera> mListaEspera;
    RestClient mRestClient;
    ListaEsperaService mListaEsperaService;

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
        configurarWebservice();

        //TODO(14) Chamar o método configurarRemocao
        carregarDados();
    }

    private void configurarWebservice(){
        mRestClient = RestClient.getInstance();
        mListaEsperaService = mRestClient.getListaEsperaService();
    }

    private void carregarDados(){
        mIndicadorCarregarProgressBar.setVisibility(View.VISIBLE);

        RestClient restClient = RestClient.getInstance();

        ListaEsperaService listaEsperaService = restClient.getListaEsperaService();

        Call<List<ListaEspera>> list = listaEsperaService.list();

        list.enqueue(new Callback<List<ListaEspera>>() {

            @Override
            public void onResponse(Call<List<ListaEspera>> call, Response<List<ListaEspera>> response) {
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

    public void onClickBtAdicionar(View view) {
        String nomeReserva = mNomeReservaEditText.getText().toString();
        int totalReserva = Integer.parseInt(mTotalPessoasEditText.getText().toString());
        ListaEspera listaEspera = new ListaEspera(nomeReserva, totalReserva);
        salvarListaEspera(listaEspera);
    }

    private void salvarListaEspera(ListaEspera listaEspera){
        Call<ListaEspera> add = mListaEsperaService.add(listaEspera);
        add.enqueue(new Callback<ListaEspera>() {
            @Override
            public void onResponse(Call<ListaEspera> call, Response<ListaEspera> response) {
                ListaEspera listaEspera = response.body();
                if(listaEspera != null){
                    mListaEspera.add(listaEspera);
                    mListaEsperaAdapter.setListaEspera(mListaEspera);
                }
            }

            @Override
            public void onFailure(Call<ListaEspera> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    //TODO(4) Definir um método chamado configurarRemocao
        //Dentro de configurarRemocao
        //TODO(5) Instanciar um ItemTouchHelper (não é necessário atribuir para uma variável)
            //Passar um ItemTouchHelper.SimpleCallback no construtor
            //Utilizar attachToRecyclerView passando o RecyclerView
        //TODO(6) No construtor de SimpleCallback passar 0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT
            //Dentro de SimpleCallback
            //TODO(7) Sobrescrever o método onSwiped
                //Dentro de onSwiped
                //TODO(8) Recuperar a lista de esperas do adapter (método getListaEspera do passo 3)
                //TODO(9) Utilizar o parâmetro ViewHolder e utilizar o getAdapterPosition
                //TODO(10) Recuperar o objeto ListaEspera correspondente baseado no getAdapterPosition do passo anterior
                    //Atribuir para uma variável compatível
                //TODO(11) Utilizar o atributo mListaEsperaService com o método remove
                    //Atribuir para uma variável compatível
                //TODO(12) Chamar o método enqueue passando um CallBack
}
