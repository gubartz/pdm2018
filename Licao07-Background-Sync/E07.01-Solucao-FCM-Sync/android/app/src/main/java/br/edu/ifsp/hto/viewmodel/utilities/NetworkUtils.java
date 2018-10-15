package br.edu.ifsp.hto.viewmodel.utilities;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;

public class NetworkUtils {
    private Application context;

    @Inject
    public NetworkUtils(Application context) {
        this.context = context;
    }

    public final boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm != null ? cm.getActiveNetworkInfo() : null;

        if(activeNetwork != null)
            return activeNetwork.isConnected();

        return false;
    }
}
