package br.edu.ifsp.hto.listaespera;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //TODO(28) Declarar atributos para os campos de EditText definidos em activity_main.xml

    //TODO(29) Declarar atributo para o ProgressBar definido em activity_main.xml

    //TODO(30) Declarar atributo para o RecyclerView definido em activity_main.xml

    //TODO(31) Declarar um atributo para o ListaEsperaAdapter

    //TODO(32) Declarar um atributo para o LinearLayout lista_espera_view definido em activity_main.xml

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO(33) Recuperar uma referência do XML para cada item defino nos atributos de classe

        //TODO(34) Definir o LayoutManger do RecyclerView

        //TODO(35) Criar uma instância do ListaEsperaAdapter e atribuir para o atributo de classe

        //TODO(36) Definiro adapter do RecyclerView para como sendo o atributo de classe

        //TODO(47) Chamar o método carregarDados
    }

    //TODO(37) Criar um método chamdo carregarDados
        //Dentro de carregarDados()
        //TODO(38) Utilize o atributo de classe que está com ProgressBar e o método setVisibility
            //para torná-lo visível
        //TODO(39) Recuperar uma instância de RestClient pelo método getInstance
        //TODO(40) Recuperar um ListaEsperaService por meio do RestClient
        //TODO(41) Chamaro método list e atribuir para uma variável compatível

        //TODO(42) Utilizar o método enqueue passando um Callback. Implementar os métodos necessários
        //Dentro do Callback
            //TODO(43) Em onResponse recupera o corpo da mensagem com response.body(). Atribuir para uma variável compatível
            //TODO(44) Utilizar o método setListaEspera do adapter a passar a lista recuperada
            //TODO(45) Esconder a barra de progresso (Verificar o passo 38)
            //TODO(46) Mostar o conteúdo de lista_espera_view (igual ao passo 38, mas para o lista_espera_view)
}