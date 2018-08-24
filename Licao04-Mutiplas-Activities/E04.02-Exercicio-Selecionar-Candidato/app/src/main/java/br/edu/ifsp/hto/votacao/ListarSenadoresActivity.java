package br.edu.ifsp.hto.votacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import br.edu.ifsp.hto.votacao.entities.Candidato;

public class ListarSenadoresActivity extends AppCompatActivity implements CandidatoAdapter.OnClickItemListener{
    RecyclerView mSenadoresRecyclerView;
    static String RETURN_EXTRA_SENADOR = "return_extra_senador";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_senadores);

        mSenadoresRecyclerView = findViewById(R.id.rv_senadores);

        mSenadoresRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        CandidatoAdapter candidatoAdapter = new CandidatoAdapter(this);

        mSenadoresRecyclerView.setAdapter(candidatoAdapter);

        List<Candidato> candidatoList = Candidato.getSenador();

        candidatoAdapter.setCandidatoList(candidatoList);
    }

    @Override
    public void onClickItem(Candidato candidato) {
        Intent result = new Intent();
        result.putExtra(RETURN_EXTRA_SENADOR, candidato);
        setResult(RESULT_OK, result);
        finish();
    }
}
