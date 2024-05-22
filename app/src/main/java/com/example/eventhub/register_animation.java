package com.example.eventhub;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class register_animation extends AppCompatActivity  {

    TextView appname;
    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Ensure this is correctly implemented
        setContentView(R.layout.activity_register_animation);

        appname = findViewById(R.id.appname);
        lottie = findViewById(R.id.lottie);

        appname.animate().translationY(-1400).setDuration(2700).setStartDelay(0).start();
        appname.animate().translationY(2000).setDuration(2000).setStartDelay(2900).start();

        lottie.playAnimation();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), Register.class);
                startActivity(i);
// Optional: to finish the current activity
            }
        }, 4000);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
