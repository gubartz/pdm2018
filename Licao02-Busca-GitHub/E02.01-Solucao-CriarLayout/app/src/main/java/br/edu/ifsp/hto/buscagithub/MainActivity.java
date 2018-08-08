package br.edu.ifsp.hto.buscagithub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //TODO(14) Criar um atributo EditText mBuscaEditText
    EditText mBuscaEditText;
    //TODO(15) Criar um atributo TextView mResultadoTextView
    TextView mResultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO(16) Usar findViewById e recuperar um referência para mBuscaEditText
        mBuscaEditText = findViewById(R.id.e_busca);

        //TODO(17) Usar findViewById e recuperar um referência para mResultadoTextView
        mResultadoTextView = findViewById(R.id.t_resultado);
    }
}
