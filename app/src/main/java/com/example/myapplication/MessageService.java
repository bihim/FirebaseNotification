package com.example.myapplication;

import android.app.PendingIntent;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Random;

public class MessageService extends FirebaseMessagingService
{
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        showNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());


    }

    //notification showing method
    public void showNotification(String title, String message)
    {
        //every pending result needs a unique request code.
        Random random = new Random();
        int randomInt = random.nextInt(1000);
        //this is why I have used random


        //created intent pending intent
        Intent intent = new Intent(this, ReceiveNotification.class);
        intent.putExtra("title",title);
        intent.putExtra("message",message);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setAction(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent result = PendingIntent.getActivity(this,randomInt,intent,0);
        //this chunk of code will handle the press event of notification and will open ReceiveNotification activity

        //Notification Builder
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"MyNotifications")
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setAutoCancel(true)
                .setContentIntent(result)
                .setContentText(message);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(123,builder.build());

        //here all the suffering ends
    }


}
