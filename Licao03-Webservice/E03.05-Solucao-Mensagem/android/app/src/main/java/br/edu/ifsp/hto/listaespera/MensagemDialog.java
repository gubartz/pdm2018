package br.edu.ifsp.hto.listaespera;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class MensagemDialog extends DialogFragment {
    public final static String EXTRA_MENSAGEM = "mensagem";

    public static MensagemDialog newInstance(String mensagem){
        Bundle args = new Bundle();
        args.putString(EXTRA_MENSAGEM, mensagem);

        MensagemDialog mensagemDialog = new MensagemDialog();
        mensagemDialog.setArguments(args);

        return mensagemDialog;
    }

    @Override
    public Dialog onCreateDialog(Bundle bundle) {

        String mensagem = getArguments().getString(EXTRA_MENSAGEM, "");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.aviso);

        builder.setMessage(mensagem)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });

        return builder.create();
    }
}
