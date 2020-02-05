package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveNotification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_notification);


        //all the data through getExtra
        String title = getIntent().getExtras().getString("title");
        String message = getIntent().getExtras().getString("message");
        TextView textViewTitle = findViewById(R.id.title_name);
        TextView textViewMessage = findViewById(R.id.message_body);
        textViewTitle.setText(title);
        textViewMessage.setText(message);
        //data


    }

}
