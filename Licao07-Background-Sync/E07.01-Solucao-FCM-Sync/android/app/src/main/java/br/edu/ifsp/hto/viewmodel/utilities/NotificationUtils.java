package br.edu.ifsp.hto.viewmodel.utilities;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.ContextCompat;

import javax.inject.Inject;

import br.edu.ifsp.hto.viewmodel.MainActivity;
import br.edu.ifsp.hto.viewmodel.R;

public class NotificationUtils {
    private static final String LISTA_ESPERA_NOTIFICATION_ID = "my_channel_01";
    private Context context;

    @Inject
    public NotificationUtils(Application context) {
        this.context = context;
    }

    public void notifyUserOfNewData(){
        initChannels();
        String notificationTitle = context.getString(R.string.app_name);
        String notificationText = context.getString(R.string.novos_dados);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, LISTA_ESPERA_NOTIFICATION_ID)
                .setColor(ContextCompat.getColor(context,R.color.colorPrimary))
                .setSmallIcon(R.drawable.account_alert)
                .setContentTitle(notificationTitle)
                .setContentText(notificationText)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_LOW);

        pendingActivity(notificationBuilder);

        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(1, notificationBuilder.build());
    }

    private void pendingActivity(NotificationCompat.Builder notificationBuilder){
        Intent mainActivity = new Intent(context, MainActivity.class);

        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(context);
        taskStackBuilder.addNextIntentWithParentStack(mainActivity);
        PendingIntent resultPendingIntent = taskStackBuilder
                .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        notificationBuilder.setContentIntent(resultPendingIntent);
    }

    private void initChannels(){
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }

        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel = new NotificationChannel(LISTA_ESPERA_NOTIFICATION_ID,
                "Channel name",
                NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription("Channel description");

        if(notificationManager != null)
            notificationManager.createNotificationChannel(channel);
    }
}
