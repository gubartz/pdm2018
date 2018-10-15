package br.edu.ifsp.hto.viewmodel.firebase_fcm;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

import dagger.android.AndroidInjection;

public class BaseService extends FirebaseMessagingService {

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidInjection.inject(this);
        FirebaseMessaging.getInstance().subscribeToTopic("lista_espera");
    }
}
