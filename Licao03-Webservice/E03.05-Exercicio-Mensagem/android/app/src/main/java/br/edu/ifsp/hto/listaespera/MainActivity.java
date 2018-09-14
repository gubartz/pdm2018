package br.edu.ifsp.hto.listaespera;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity implements ListaEsperaAdapter.OnItemClickListener {
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

        mListaEsperaAdapter = new ListaEsperaAdapter(this);

        mListaEsperaRecyclerView.setAdapter(mListaEsperaAdapter);
        mListaEspera = new ArrayList<>();
        configurarWebservice();

        configurarRemocao();
        carregarDados();
    }

    @Override
    protected void onResume() {
        super.onResume();
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

        //TODO(6) Ajustar o código para as alterações realizadas na interface
        Call<List<ListaEsperaEntry>> list = listaEsperaService.list();

        //TODO(7) Dentro do onResponse
        list.enqueue(new Callback<List<ListaEsperaEntry>>() {
            @Override
            public void onResponse(Call<List<ListaEsperaEntry>> call, Response<List<ListaEsperaEntry>> response) {
                //TODO(8) Instanciar um MensagemDialog utilizando o método newInstance
                    //passando o response.body().message
                mListaEspera = response.body();
                mListaEsperaAdapter.setListaEspera(mListaEspera);
                mIndicadorCarregarProgressBar.setVisibility(View.INVISIBLE);
                mListaEsperaView.setVisibility(View.VISIBLE);

                //TODO(9) Utilizar o método show para mostrar o Dialog
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

    private void configurarRemocao(){
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                List<ListaEsperaEntry> listaEsperaList = mListaEsperaAdapter.getListaEspera();
                int position = viewHolder.getAdapterPosition();
                ListaEsperaEntry listaEspera = listaEsperaList.get(position);
                Call<Void> remove = mListaEsperaService.remove(listaEspera.getId());
                remove.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
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

    @Override
    public void onClickItem(ListaEsperaEntry listaEspera) {
        Intent intent = new Intent(MainActivity.this, AtualizarListaEsperaActiviy.class);

        intent.putExtra(AtualizarListaEsperaActiviy.EXTRA_LISTA_ESPERA, listaEspera);

        startActivity(intent);
    }
}
