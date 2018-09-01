package br.edu.ifsp.hto.livedata.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.edu.ifsp.hto.livedata.R;
import br.edu.ifsp.hto.livedata.entities.ListaEspera;

public class ListaEsperaAdapter extends RecyclerView.Adapter<ListaEsperaAdapter.ListaEsperaViewHolder>{
    private List<ListaEspera> mListaEspera;
    OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener{
        void onClickItem(ListaEspera listaEspera);
    }

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
        ListaEspera listaEspera = mListaEspera.get(position);

        holder.bind(listaEspera);
    }

    public List<ListaEspera> getListaEspera() {
        return mListaEspera;
    }

    @Override
    public int getItemCount() {
        if(mListaEspera != null)
            return mListaEspera.size();

        return 0;
    }

    public void setListaEspera(List<ListaEspera> listaEspera){
        mListaEspera = listaEspera;
        this.notifyDataSetChanged();
    }

    class ListaEsperaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView mNomeReservaTextView, mTotalPessoasTextView;

        public ListaEsperaViewHolder(View itemView) {
            super(itemView);
            mNomeReservaTextView = itemView.findViewById(R.id.t_nome_reserva);
            mTotalPessoasTextView = itemView.findViewById(R.id.t_total_pessoas);

            itemView.setOnClickListener(this);
        }

        public void bind(ListaEspera listaEspera){
            mNomeReservaTextView.setText(listaEspera.getNomeReserva());
            mTotalPessoasTextView.setText(String.valueOf(listaEspera.getTotalPessoas()));
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            ListaEspera listaEspera = mListaEspera.get(position);
            mOnItemClickListener.onClickItem(listaEspera);
        }
    }
}
