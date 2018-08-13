package br.edu.ifsp.hto.listardados;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.edu.ifsp.hto.listardados.entities.ListaEspera;

//TODO(14) Estender a classe de RecyclerView.Adapter. Utilize o ListaEsperaViewHolder no generics.
//TODO(15) Implementar os métodos necessários
public class ListaEsperaAdapter extends RecyclerView.Adapter<ListaEsperaAdapter.ListaEsperaViewHolder>{
    //TODO(16) Declarar um atributo de classe para manter uma lista de objetos ListaEspera
    private List<ListaEspera> mListaEspera;

    //TODO(17) Implementar onCreateViewHolder
        //Dentro de onCreateViewHolder
    @NonNull
    @Override
    public ListaEsperaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //TODO(18) Recuperar um LayoutInflater e inflar o lista_espera_item.xml
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.lista_espera_item, parent, false);

        //TODO(19) Retornar um objeto ListaEsperaViewHolder
        return new ListaEsperaViewHolder(view);
    }

    //TODO(20) Implementar onBindViewHolder
        //Dentro de onBindViewHolder
    @Override
    public void onBindViewHolder(@NonNull ListaEsperaViewHolder holder, int position) {
        //TODO(21) Recuperar o objeto ListaEspera correspondente da lista utilizando o parâmetro position
        ListaEspera listaEspera = mListaEspera.get(position);

        //TODO(22) Chamar o método binddo objeto ListaEsperaViewHolder e passar a ListaEspera recuperada no passo 21
        holder.bind(listaEspera);
    }

    //TODO(23) Implementar getItemCount
        //Dentro de getItemCount
    @Override
    public int getItemCount() {
        //TODO(24) Retornar o total de elementos da lista, utilizando a referência no atributo da classe.
            // Verifique se o valor não é nulo.
        if(mListaEspera != null)
            return mListaEspera.size();

        return 0;
    }

    //TODO(25) Criar um método chamado setListaEspera, que recebe um lista de objetos ListaEspera
        //Dentro de setListaEspera
    public void setListaEspera(List<ListaEspera> listaEspera){
        //TODO(26) Atribuir o argumento do método ao atributo de classe
        mListaEspera = listaEspera;
        //TODO(27) Chamar o método this.notifyDataSetChanged()
        this.notifyDataSetChanged();
    }

    //TODO(8) Criar uma classe ListaEsperaViewHolder. A classe deve estender de RecyclerView.ViewHolder
        //Dentro da classe ListaEsperaViewHolder
    class ListaEsperaViewHolder extends RecyclerView.ViewHolder{
        //TODO(9) Definir dois atributos para os TextViews definidos em lista_espera_item.xml
        TextView mNomeReservaTextView, mTotalPessoasTextView;

        //TODO(10) Definir um construtor
            //Dentro do construtor
            //TODO(11) Atribur aos atributos de classe os TextViews definidos no xml
        public ListaEsperaViewHolder(View itemView) {
            super(itemView);
            mNomeReservaTextView = itemView.findViewById(R.id.t_nome_reserva);
            mTotalPessoasTextView = itemView.findViewById(R.id.t_total_pessoas);
        }

        //TODO(12) Criar um método chamado bind, que recebe uma objeto ListaEspera
            //Dentro do método bind
        public void bind(ListaEspera listaEspera){
            //TODO(13) Utilizar os atributos de classe com o método setText para
                //atributos os conteúdos correspondentes que estão no objeto ListaEspera de declaro
                //como parâmetro do método bind (passo 12)
            mNomeReservaTextView.setText(listaEspera.getNomeReserva());
            mTotalPessoasTextView.setText(String.valueOf(listaEspera.getTotalPessoas()));
        }
    }
}
