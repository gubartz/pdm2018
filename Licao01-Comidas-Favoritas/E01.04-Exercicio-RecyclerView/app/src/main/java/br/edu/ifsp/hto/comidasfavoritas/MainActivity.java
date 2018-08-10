package br.edu.ifsp.hto.comidasfavoritas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //TODO(22) Definir um atributo de classe do tipo RecyclerView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO(23) Utilizar findViewById para recuperaro rv_lista definido no layout

        //TODO(24) Criar uma instância de LinearLayoutManager passando this no construtor

        //TODO(25) Definir o layout manager do RecyclerView utilizando a instância criada no passo anterior

        //TODO(26) Criar uma instância de ComidaAdapter passando no construtor a lista de comida

        //TODO(27) Definir o adapter do RecyclerView, que foi criado no passo anterior
    }
}
