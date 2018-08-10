package br.edu.ifsp.hto.comidasfavoritas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //TODO(22) Definir um atributo de classe do tipo RecyclerView
    RecyclerView mRvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO(23) Utilizar findViewById para recuperaro rv_lista definido no layout
        mRvLista = findViewById(R.id.rv_lista);

        //TODO(24) Criar uma instância de LinearLayoutManager passando this no construtor
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        //TODO(25) Definir o layout manager do RecyclerView utilizando a instância criada no passo anterior
        mRvLista.setLayoutManager(linearLayoutManager);

        //TODO(26) Criar uma instância de ComidaAdapter passando no construtor a lista de comida
        ComidaAdapter comidaAdapter = new ComidaAdapter(Comidas.getComidas());

        //TODO(27) Definir o adapter do RecyclerView, que foi criado no passo anterior
        mRvLista.setAdapter(comidaAdapter);
    }
}
