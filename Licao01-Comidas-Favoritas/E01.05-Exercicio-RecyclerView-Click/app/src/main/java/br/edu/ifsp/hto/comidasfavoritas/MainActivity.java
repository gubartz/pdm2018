package br.edu.ifsp.hto.comidasfavoritas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

//TODO(11) Implementar a interface OnClickItemListener definida no adapter
public class MainActivity extends AppCompatActivity{
    RecyclerView mRvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRvLista = findViewById(R.id.rv_lista);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        mRvLista.setLayoutManager(linearLayoutManager);
        //TODO(12) Passar como segundo argumento do construtor this
        ComidaAdapter comidaAdapter = new ComidaAdapter(Comidas.getComidas());

        mRvLista.setAdapter(comidaAdapter);
    }

    //TODO(13) Sobrescrever o método onClickItem
        //Dentro de onClickItem
        //TODO(14) Utilizar um Toast para mostrar o nome da comida clicada
}
