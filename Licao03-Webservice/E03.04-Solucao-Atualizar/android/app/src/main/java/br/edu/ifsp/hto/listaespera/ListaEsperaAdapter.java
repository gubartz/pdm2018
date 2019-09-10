package br.edu.ifsp.hto.listaespera;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.edu.ifsp.hto.listaespera.entities.ListaEsperaEntry;


public class ListaEsperaAdapter extends RecyclerView.Adapter<ListaEsperaAdapter.ListaEsperaViewHolder>{
    private List<ListaEsperaEntry> mListaEspera;
    //TODO(13) Declarar um atributo para a interface OnItemClickListener
    OnItemClickListener mOnItemClickListener;

    //TODO(11) Definir uma interface OnItemClickListener
        //Dentro de OnItemClickListener
    interface OnItemClickListener {
        //TODO(12) Definir um método onClickItem que recebe um ListaEsperaEntry
        void onClickItem(ListaEsperaEntry listaEspera);
    }

    //TODO(21) Definir um construtor que recebe um OnItemClickListener e atribuí-lo para o atributo de classe (passo 13)
    public ListaEsperaAdapter(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @NonNull
    @Override
    public ListaEsperaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.lista_espera_item, parent, false);

        return new ListaEsperaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaEsperaViewHolder holder, int position) {
        ListaEsperaEntry listaEspera = mListaEspera.get(position);

        holder.bind(listaEspera);
    }

    @Override
    public int getItemCount() {

        if(mListaEspera != null)
            return mListaEspera.size();

        return 0;
    }

    public void setListaEspera(List<ListaEsperaEntry> listaEspera){
        mListaEspera = listaEspera;
        this.notifyDataSetChanged();
    }

    public List<ListaEsperaEntry> getListaEspera() {
        return mListaEspera;
    }

    //TODO(14) Implementar a interface View.OnClickListener
    class ListaEsperaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView mNomeReservaTextView, mTotalPessoasTextView;

        public ListaEsperaViewHolder(View itemView) {
            super(itemView);
            mNomeReservaTextView = itemView.findViewById(R.id.t_nome_reserva);
            mTotalPessoasTextView = itemView.findViewById(R.id.t_total_pessoas);

            //TODO(19) Registrar o itemView utilizando setOnClickListener
            itemView.setOnClickListener(this);
        }

        public void bind(ListaEsperaEntry listaEspera){
            mNomeReservaTextView.setText(listaEspera.getNomeReserva());
            mTotalPessoasTextView.setText(String.valueOf(listaEspera.getTotalPessoas()));
        }

        //TODO(15) Sobrescrever o método onClick
            //Dentro de onClick
        @Override
        public void onClick(View v) {
            //TODO(16) Recuperar a posição no adapter
            int position = getAdapterPosition();
            //TODO(17) Recuperar o elemento da lista correspondnete
            ListaEsperaEntry listaEspera = mListaEspera.get(position);
            //TODO(18) Chamar o método onClickItem da interface mOnItemClickListener passar o objeto ListaEsperaEntry correspondente
            mOnItemClickListener.onClickItem(listaEspera);
        }
    }
}
