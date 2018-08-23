package br.edu.ifsp.hto.listaespera;

import java.util.List;

import br.edu.ifsp.hto.listaespera.entities.ListaEspera;

//TODO(14) Estender a classe de RecyclerView.Adapter. Utilize o ListaEsperaViewHolder no generics.
//TODO(15) Implementar os métodos necessários
public class ListaEsperaAdapter{
    //TODO(16) Declarar um atributo de classe para manter uma lista de objetos ListaEspera
    private List<ListaEspera> mListaEspera;

    //TODO(17) Implementar onCreateViewHolder
        //Dentro de onCreateViewHolder
        //TODO(18) Recuperar um LayoutInflater e inflar o lista_espera_item.xml
        //TODO(19) Retornar um objeto ListaEsperaViewHolder

    //TODO(20) Implementar onBindViewHolder
        //Dentro de onBindViewHolder
        //TODO(21) Recuperar o objeto ListaEspera correspondente da lista utilizando o parâmetro position
        //TODO(22) Chamar o método binddo objeto ListaEsperaViewHolder e passar a ListaEspera recuperada no passo 21

    //TODO(23) Implementar getItemCount
        //Dentro de getItemCount
        //TODO(24) Retornar o total de elementos da lista, utilizando a referência no atributo da classe.

    //TODO(25) Criar um método chamado setListaEspera, que recebe um lista de objetos ListaEspera
        //Dentro de setListaEspera
        //TODO(26) Atribuir o argumento do método ao atributo de classe
        //TODO(27) Chamar o método this.notifyDataSetChanged()

    //TODO(8) Criar uma classe ListaEsperaViewHolder. A classe deve estender de RecyclerView.ViewHolder
        //Dentro da classe ListaEsperaViewHolder
        //TODO(9) Definir dois atributos para os TextViews definidos em lista_espera_item.xml
        //TODO(10) Definir um construtor
            //Dentro do construtor
            //TODO(11) Atribur aos atributos de classe os TextViews definidos no xml
        //TODO(12) Criar um método chamado bind, que recebe uma objeto ListaEspera
            //Dentro do método bind
            //TODO(13) Utilizar os atributos de classe com o método setText para
                //atributos os conteúdos correspondentes que estão no objeto ListaEspera de declaro
                //como parâmetro do método bind (passo 12)

}
