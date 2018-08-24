package br.edu.ifsp.hto.votacao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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

    //TODO(7) No método para onClickBtPresidente abrir a activity ListarPresidentesActivity

    //TODO(8) No método para onClickBtSenador abrir a activity ListarSenadoresActivity

}