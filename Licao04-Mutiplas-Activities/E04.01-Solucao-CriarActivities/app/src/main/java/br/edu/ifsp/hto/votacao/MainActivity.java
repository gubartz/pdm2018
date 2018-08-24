package br.edu.ifsp.hto.votacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.edu.ifsp.hto.votacao.entities.Candidato;
import br.edu.ifsp.hto.votacao.entities.TiposCandidatosEnum;

public class MainActivity extends AppCompatActivity {
    //TODO(5) Criar uma Activity chamada ListarPresidentesActivity
        //No Layout
            //Definir o layout container raíz como LinearLayout com orientação vertical
            //Definir um RecyclerView com o id rv_presidentes
    //TODO(6) Criar uma Activity chamada ListarSenadoresActivity
        //No Layout
            //Definir o layout container raíz como LinearLayout com orientação vertical
            //Definir um RecyclerView com o id rv_senadores

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtPresidente(View view) {
        //TODO(7) No método para onClickBtPresidente abrir a activity ListarPresidentesActivity
        Intent intent = new Intent(this, ListarPresidentesActivity.class);
        startActivity(intent);
    }


    public void onClickBtSenador(View view) {
        //TODO(8) No método para onClickBtSenador abrir a activity ListarSenadoresActivity
        Intent intent = new Intent(this, ListarSenadoresActivity.class);
        startActivity(intent);
    }
}