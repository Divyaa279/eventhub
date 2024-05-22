package com.example.eventhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText editTextEmail,editTextPassword;
    Button buttonLogin;
    FirebaseAuth mAuth;

    TextView textView;




    ProgressDialog progressDialog;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
            startActivity(intent);

            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize FirebaseAuth instance
        mAuth = FirebaseAuth.getInstance();

        // Initialize views
        editTextEmail = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.submitbtn);
        textView = findViewById(R.id.createAccountTextView);

        // Initialize progressDialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Logging in...");
        progressDialog.setCancelable(false); // Prevent the dialog from being canceled by pressing back button

        // Set click listener for create account textview
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);
                finish();
            }
        });

        TextView textView1 = findViewById(R.id.forgotPasswordTextView);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), forgetpass.class);
                startActivity(intent);

                finish();
            }
        });


        // Set click listener for login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(MainActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressDialog.show(); // Show progress dialog

                // Sign in user with Firebase authentication
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss(); // Dismiss progress dialog
                                if (task.isSuccessful()) {
                                    // Login successful
                                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                                    startActivity(intent);
                                } else {
                                    // Login failed
                                    Toast.makeText(MainActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                                }
                            }



                        });



            }
        });
    }


}


