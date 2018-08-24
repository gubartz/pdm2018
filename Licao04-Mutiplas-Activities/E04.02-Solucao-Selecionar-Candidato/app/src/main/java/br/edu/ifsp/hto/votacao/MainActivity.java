package br.edu.ifsp.hto.votacao;

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import br.edu.ifsp.hto.votacao.entities.Candidato;
import br.edu.ifsp.hto.votacao.entities.TiposCandidatosEnum;

public class MainActivity extends AppCompatActivity {
    //TODO(9) Criar um atributo estático inteiro chamado REQUEST_PRESIDENTE. O valor pode ser 1.
    static final int REQUEST_PRESIDENTE = 1;

    //TODO(10) Criar um atributo estático inteiro chamado REQUEST_SENADOR. O valor pode ser 2.
    static final int REQUEST_SENADOR = 2;

    //TODO(18) Criar atributos para os TextViews do Presidente e Senador
    TextView mPresidenteTextView, mSenadorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO(19) Recuperar os TextViews do Presidente e Senador para os atributos de classe
        mPresidenteTextView = findViewById(R.id.t_presidente);
        mSenadorTextView = findViewById(R.id.t_senador);
    }

    public void onClickBtPresidente(View view) {
        Intent intent = new Intent(this, ListarPresidentesActivity.class);

        //TODO(11) Trocar o startActivity por startActivityForResult
            //Passar o atributo estático correspondente
        //startActivity(intent);
        startActivityForResult(intent, REQUEST_PRESIDENTE);
    }

    public void onClickBtSenador(View view) {
        Intent intent = new Intent(this, ListarSenadoresActivity.class);
        //TODO(12) Trocar o startActivity por startActivityForResult
            //Passar o atributo estático correspondente
        //startActivity(intent);
        startActivityForResult(intent, REQUEST_SENADOR);
    }

    //TODO(20) Sobrescrever o método onActivityResult
        //Dentro de onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //TODO(21) Comparar o requestCode com o atributo estático definido nesta classe
            //Verificar também se o result code é igual a RESULT_OK
        if(requestCode == REQUEST_PRESIDENTE && resultCode == RESULT_OK){
            //TODO(22) Se a condição for verdadeira utilize o Intent (parâmetro deste método) para atribuir o nome do candidato
            //para o TextView definido no layout
            Candidato candidato = data.getParcelableExtra(ListarPresidentesActivity.RETURN_EXTRA_PRESIDENTE);
            mPresidenteTextView.setText(candidato.getNome());
        }else if(requestCode == REQUEST_SENADOR && resultCode == RESULT_OK){
            //para o TextView definido no layout
            Candidato candidato = data.getParcelableExtra(ListarSenadoresActivity.RETURN_EXTRA_SENADOR);
            mSenadorTextView.setText(candidato.getNome());
        }
    }

    //TODO(23) Repita os passos para também mostrar o senador selecionado
        //Lembre-se que você deve utilizar o método onActivityResult testando o requestCode
        //para verificar se a resposta retornada é de um senador
}