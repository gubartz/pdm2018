package br.edu.ifsp.hto.comidasfavoritas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //TODO(1) Declarar um atributo de classe TextView chamado mComidasTextView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO(3) Utilizar findViewById para recuperar uma referência do TextView definido no layout
        //TODO(4) Utilizar o método Comidas.getComidas() e armazenar o retorno em um vetor de Strings
        //TODO(5) Utilizar um loop para mostrar os valores no TextView. Utilize o método append e \n para quebra de linhas

    }
}
