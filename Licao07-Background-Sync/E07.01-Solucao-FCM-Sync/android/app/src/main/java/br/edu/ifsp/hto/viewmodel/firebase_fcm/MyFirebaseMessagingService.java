package br.edu.ifsp.hto.viewmodel.firebase_fcm;

import android.util.Log;

import com.google.firebase.messaging.RemoteMessage;

import javax.inject.Inject;

import br.edu.ifsp.hto.viewmodel.application.App;
import br.edu.ifsp.hto.viewmodel.repositories.ListaEsperaRepository;
import br.edu.ifsp.hto.viewmodel.utilities.NotificationUtils;

public class MyFirebaseMessagingService extends BaseService {
    @Inject
    ListaEsperaRepository mListaEsperaRepository;

    @Inject
    NotificationUtils mNotificationUtils;

    private final String TAG = MyFirebaseMessagingService.class.getSimpleName();

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if(((App) getApplication()).isAppInForeground()){
            Log.d(TAG, "Fore");
        }else{
            Log.d(TAG, "Back");
            mNotificationUtils.notifyUserOfNewData();
        }
        mListaEsperaRepository.refreshData();
    }
}
