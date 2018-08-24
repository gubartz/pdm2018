package br.edu.ifsp.hto.votacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import br.edu.ifsp.hto.votacao.entities.Candidato;

//TODO(1) Implementar a interface OnClickItemListener definida em CandidatoAdapter
    //Implementar o método definido na interface onClickItem(Candidato candidato)
public class ListarPresidentesActivity extends AppCompatActivity{
    //TODO(2) Definir um atributo para o RecyclerView

    //TODO(13) Definir um atributo String estático chamado RETURN_EXTRA_PRESIDENTE
    //o conteúdo deve ser return_extra_presidente

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_presidentes);

        //TODO(3) Recuperar o RecyclerView do layout para o atributo de classe

        //TODO(4) Definir um LinearLayoutManager para o RecyclerView

        //TODO(5) Instanciar o CandidatoAdapter

        //TODO(6) Definir o adapter do RecyclerView

        //TODO(7) Retornar a lista de candidatos à presidência (getPresidentes da classe Candidato)

        //TODO(8) Definir a lista de candidatos no Adapter
    }

    //Implementar o método definido na interface onClickItem(Candidato candidato)
        //TODO(14) Criar uma Intent
        //TODO(15) Utilizar o  método putExtra e colocar o candidato clicado (parâmetro do método onClickItem)
        //A chave deve ser RETURN_EXTRA_PRESIDENTE
        //TODO(16) Chamar o método setResult com a constante RESULT_OK e a intent criada
        //TODO(17) Chamar o método finish
}
