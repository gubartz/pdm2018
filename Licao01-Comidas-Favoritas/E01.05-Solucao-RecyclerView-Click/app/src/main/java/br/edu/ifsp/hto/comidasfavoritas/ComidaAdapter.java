package br.edu.ifsp.hto.comidasfavoritas;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ComidaAdapter extends RecyclerView.Adapter<ComidaAdapter.ComidaViewHolder>{
    String[] mComidas;

    //TODO(3) Definir um atributo de classe do tipo onClickItemListener
    onClickItemListener mOnClickItemListener;

    //TODO(1) Definir uma interface chamada onClickItemListener
        //Dentro da interface
    interface onClickItemListener{
        //TODO(2) Definir um método chamado onClickItem que recebe um String
        void onClickItem(String comida);
    }

    //TODO(10) Adicionar ao construtor um parâmetro do tipo onClickItemListener
    public ComidaAdapter(String[] mComidas, onClickItemListener mOnClickItemListener) {
        this.mComidas = mComidas;
        this.mOnClickItemListener = mOnClickItemListener;
    }

    @NonNull
    @Override
    public ComidaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.lista_item, parent, false);

        return new ComidaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComidaViewHolder holder, int position) {
        String comida = mComidas[position];

        holder.mComidaTextView.setText(comida);
    }

    @Override
    public int getItemCount() {
        if(mComidas != null)
            return mComidas.length;

        return 0;
    }

    //TODO(4) Implemetar a interface OnClickListener
    class ComidaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView mComidaTextView;

        public ComidaViewHolder(View itemView) {
            super(itemView);
            mComidaTextView = itemView.findViewById(R.id.t_comida);

            //TODO(9) Registrar o itemView no listener com setOnClickListener
            itemView.setOnClickListener(this);
        }

        //TODO(5) Sobrescrever o método onClick
            //Dentro de onClick
        @Override
        public void onClick(View view) {
            //TODO(6) Chamar o método getAdapterPosition e atribuir o retorno para uma variável compatível
            int adapterPosition = getAdapterPosition();
            //TODO(7) Recuperar a comida do vetor (atributo da classe adapter)
            String comida = mComidas[adapterPosition];
            //TODO(8) Usar a variável mOnClickItemListener e chamar o método onClickItem passando a comida recuperada no passo anterior
            mOnClickItemListener.onClickItem(comida);
        }
    }
}
