package br.edu.ifsp.hto.comidasfavoritas;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//TODO(12) A classe ComidaAdapter deve estender RecyclerView.Adapter<ComidaViewHolder>
public class ComidaAdapter extends RecyclerView.Adapter<ComidaAdapter.ComidaViewHolder>{
    //TODO(13) Implementar os métodos necessários
    //TODO(14) Criar um atributo como vetor de Strings (vai manter uma referência para a lista de comidas
    String[] mComidas;

    //TODO(15) Criar um construtor que recebe um vetor de Strings (lista de comidas) atribuindo o argumento para o atributo
        //criado no passo anterior
    public ComidaAdapter(String[] mComidas) {
        this.mComidas = mComidas;
    }

    //No método onCreateViewHolder
    @NonNull
    @Override
    public ComidaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //TODO(16) Recuperar uma instância de LayoutInflater utilizando LayoutInflater.from(parent.getContext())
            //atribuir para uma variável
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //TODO(17) Chamar o método inflate(int, ViewGroup, boolean), por meio da variável recuperada no passo anterior
            //Atribuir o retorno para uma variável compatível
            //Utilizar a classe R para passar o lista_item.xml
            //O ViewGroup a ser utilizado é o argumento do método onCreateViewHolder
            //Utilizar false no último parêmtro
        View view = layoutInflater.inflate(R.layout.lista_item, parent, false);
        //TODO(18) Retornar uma instância de ComidaViewHolder passando a variável gerada no passo anterior

        return new ComidaViewHolder(view);
    }

    //No método onBindViewHolder
    @Override
    public void onBindViewHolder(@NonNull ComidaViewHolder holder, int position) {
        //TODO(19) Recuperar o String referente a posição utilizando o segundo parâmetro do método onBindViewHolder
        String comida = mComidas[position];
        //TODO(20) Utilizar o primeiro parâmetro, que é uma referência ao ComidaViewHolder e
            //Utilizar o atributo de classe de ComidaViewHolder (TextView) para definir o String recuperado no passo anterior
        holder.mComidaTextView.setText(comida);
    }

    //No método getItemCount
    @Override
    public int getItemCount() {
        //TODO(21) Se o conteúdo do atributo de classe (lista de comidas) não estiver nulo retorno o tamanho do vetor
        if(mComidas != null)
            return mComidas.length;

        return 0;
    }

    //TODO(8) Definir uma inner class chamada ComidaViewHolder e estender de RecyclerView.ViewHolder
    class ComidaViewHolder extends RecyclerView.ViewHolder{
        //Na classe ComidaViewHolder
        //TODO(9) Definir um atributo do tipo TextView
        TextView mComidaTextView;

        //TODO(10) Definir o construtor
        public ComidaViewHolder(View itemView) {
            super(itemView);
            //TODO(11) No construtor atribuir uma referência do t_comida (definido no lista_item.xml)
                //utilizando itemView.findViewById
            mComidaTextView = itemView.findViewById(R.id.t_comida);
        }
    }
}
