package com.example.eventhub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView listsTextView = findViewById(R.id.lists);
        TextView registrationTextView = findViewById(R.id.registration);
        TextView aboutTextView = findViewById(R.id.about);
        TextView logOutTextView = findViewById(R.id.log_out);

        // Set onClickListeners for each TextView
        listsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to eventlist_animation
                Intent intent = new Intent(MainActivity2.this, eventlist_animation.class);
                startActivity(intent);
            }
        });

        registrationTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to register_animation
                Intent intent = new Intent(MainActivity2.this, register_animation.class);
                startActivity(intent);
            }
        });

        aboutTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to info_animation
                Intent intent = new Intent(MainActivity2.this, info_animation.class);
                startActivity(intent);
            }
        });

        logOutTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to logout_animation


                Intent intent = new Intent(MainActivity2.this, logout_animation.class);
                startActivity(intent);
            }
        });
    }
}
