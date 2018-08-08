package br.edu.ifsp.hto.comidasfavoritas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //TODO(1) Declarar um atributo de classe TextView chamado mComidasTextView
    TextView mComidasTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO(3) Utilizar findViewById para recuperar uma referência do TextView definido no layout
        mComidasTextView = findViewById(R.id.tv_comidas);

        //TODO(4) Utilizar o método Comidas.getComidas() e armazenar o retorno em um vetor de Strings
        String[] comidas = Comidas.getComidas();

        //TODO(5) Utilizar um loop para mostrar os valores no TextView. Utilize o método append e \n para quebra de linhas
        for(String comida : comidas){
            mComidasTextView.append(comida + "\n\n\n");
        }

    }
}
