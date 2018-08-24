package br.edu.ifsp.hto.votacao;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.edu.ifsp.hto.votacao.entities.Candidato;

public class CandidatoAdapter extends RecyclerView.Adapter<CandidatoAdapter.CandidatoViewHolder>{
    private List<Candidato> mCandidatoList;
    private OnClickItemListener mOnClickItemListener;

    interface OnClickItemListener{
        void onClickItem(Candidato candidato);
    }

    public CandidatoAdapter(OnClickItemListener onClickItemListener) {
        this.mOnClickItemListener = onClickItemListener;
    }

    @NonNull
    @Override
    public CandidatoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_candidato, parent, false);

        return new CandidatoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CandidatoViewHolder candidatoViewHolder, int position) {
        Candidato candidato = mCandidatoList.get(position);
        candidatoViewHolder.bind(candidato);
    }

    @Override
    public int getItemCount() {
        if(mCandidatoList != null)
            return mCandidatoList.size();

        return 0;
    }

    public List<Candidato> getCandidatoList() {
        return mCandidatoList;
    }

    public void setCandidatoList(List<Candidato> mCandidatoList) {
        this.mCandidatoList = mCandidatoList;
        this.notifyDataSetChanged();
    }

    class CandidatoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView mCandidatoNumeroTextView, mCandidatoNomeTextView;

        public CandidatoViewHolder(@NonNull View itemView) {
            super(itemView);

            mCandidatoNumeroTextView = itemView.findViewById(R.id.t_candidato_numero);
            mCandidatoNomeTextView = itemView.findViewById(R.id.t_candidato_nome);

            itemView.setOnClickListener(this);
        }

        public void bind(Candidato candidato){
            mCandidatoNomeTextView.setText(candidato.getNome());
            mCandidatoNumeroTextView.setText(String.valueOf(candidato.getNumero()));
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Candidato candidato = mCandidatoList.get(position);

            mOnClickItemListener.onClickItem(candidato);
        }
    }
}
