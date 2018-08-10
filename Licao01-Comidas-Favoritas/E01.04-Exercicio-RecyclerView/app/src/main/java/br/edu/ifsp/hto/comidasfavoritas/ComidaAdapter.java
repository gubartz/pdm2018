package br.edu.ifsp.hto.comidasfavoritas;

//TODO(12) A classe ComidaAdapter deve estender RecyclerView.Adapter<ComidaViewHolder>
public class ComidaAdapter{
    //TODO(13) Implementar os métodos necessários
    //TODO(14) Criar um atributo como vetor de Strings (vai manter uma referência para a lista de comidas
    //TODO(15) Criar um construtor que recebe um vetor de Strings (lista de comidas) atribuindo o argumento para o atributo
        //criado no passo anterior

    //No método onCreateViewHolder
        //TODO(16) Recuperar uma instância de LayoutInflater utilizando LayoutInflater.from(parent.getContext())
            //atribuir para uma variável
        //TODO(17) Chamar o método inflate(int, ViewGroup, boolean), por meio da variável recuperada no passo anterior
            //Atribuir o retorno para uma variável compatível
            //Utilizar a classe R para passar o lista_item.xml
            //O ViewGroup a ser utilizado é o argumento do método onCreateViewHolder
            //Utilizar false no último parêmtro
        //TODO(18) Retornar uma instância de ComidaViewHolder passando a variável gerada no passo anterior

    //No método onBindViewHolder
        //TODO(19) Recuperar o String referente a posição utilizando o segundo parâmetro do método onBindViewHolder
        //TODO(20) Utilizar o primeiro parâmetro, que é uma referência ao ComidaViewHolder e
            //Utilizar o atributo de classe de ComidaViewHolder (TextView) para definir o String recuperado no passo anterior

    //No método getItemCount
        //TODO(21) Se o conteúdo do atributo de classe (lista de comidas) não estiver nulo retorno o tamanho do vetor

    //TODO(8) Definir uma inner class chamada ComidaViewHolder e estender de RecyclerView.ViewHolder
        //Na classe ComidaViewHolder
            //TODO(9) Definir um atributo do tipo TextView
            //TODO(10) Definir o construtor
            //TODO(11) No construtor atribuir uma referência do t_comida (definido no lista_item.xml)
                //utilizando itemView.findViewById
}
