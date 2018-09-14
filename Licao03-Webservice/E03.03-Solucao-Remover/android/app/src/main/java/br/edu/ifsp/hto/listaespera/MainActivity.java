package br.edu.ifsp.hto.listaespera;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
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
    List<ListaEsperaEntry> mListaEspera;
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
        mListaEspera = new ArrayList<>();
        configurarWebservice();

        //TODO(14) Chamar o método configurarRemocao
        configurarRemocao();
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

        Call<List<ListaEsperaEntry>> list = listaEsperaService.list();

        list.enqueue(new Callback<List<ListaEsperaEntry>>() {

            @Override
            public void onResponse(Call<List<ListaEsperaEntry>> call, Response<List<ListaEsperaEntry>> response) {
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

    public void onClickBtAdicionar(View view) {
        String nomeReserva = mNomeReservaEditText.getText().toString();
        int totalReserva = Integer.parseInt(mTotalPessoasEditText.getText().toString());
        ListaEsperaEntry listaEspera = new ListaEsperaEntry(nomeReserva, totalReserva);
        salvarListaEspera(listaEspera);
    }

    private void salvarListaEspera(ListaEsperaEntry listaEspera){
        Call<ListaEsperaEntry> add = mListaEsperaService.add(listaEspera);
        add.enqueue(new Callback<ListaEsperaEntry>() {
            @Override
            public void onResponse(Call<ListaEsperaEntry> call, Response<ListaEsperaEntry> response) {
                ListaEsperaEntry listaEspera = response.body();
                if(listaEspera != null){
                    mListaEspera.add(listaEspera);
                    mListaEsperaAdapter.setListaEspera(mListaEspera);
                }
            }

            @Override
            public void onFailure(Call<ListaEsperaEntry> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    //TODO(4) Definir um método chamado configurarRemocao
        //Dentro de configurarRemocao
    private void configurarRemocao(){
        //TODO(5) Instanciar um ItemTouchHelper (não é necessário atribuir para uma variável)
            //Passar um ItemTouchHelper.SimpleCallback no construtor
            //Utilizar attachToRecyclerView passando o RecyclerView
        //TODO(6) No construtor de SimpleCallback passar 0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT
            //Dentro de SimpleCallback
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            //TODO(7) Sobrescrever o método onSwiped
                //Dentro de onSwiped
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                //TODO(8) Recuperar a lista de esperas do adapter (método getListaEspera do passo 3)
                List<ListaEsperaEntry> listaEsperaList = mListaEsperaAdapter.getListaEspera();
                //TODO(9) Utilizar o parâmetro ViewHolder e utilizar o getAdapterPosition
                int position = viewHolder.getAdapterPosition();
                //TODO(10) Recuperar o objeto ListaEsperaEntry correspondente baseado no getAdapterPosition do passo anterior
                    //Atribuir para uma variável compatível
                ListaEsperaEntry listaEspera = listaEsperaList.get(position);
                //TODO(11) Utilizar o atributo mListaEsperaService com o método remove
                    //Atribuir para uma variável compatível
                Call<Void> remove = mListaEsperaService.remove(listaEspera.getId());
                //TODO(12) Chamar o método enqueue passando um CallBack
                remove.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        //TODO(13) Chamar o método carregarDados
                        carregarDados();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        t.printStackTrace();
                    }
                });

            }
        }).attachToRecyclerView(mListaEsperaRecyclerView);
    }
}
