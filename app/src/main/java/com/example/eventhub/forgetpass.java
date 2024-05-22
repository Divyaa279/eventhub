package com.example.eventhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgetpass extends AppCompatActivity {
    private EditText femail;
    private Button fpbn;
    private String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpass);
        getWindow().setStatusBarColor(ContextCompat.getColor(this,com.google.android.material.R.color.background_material_dark));

        femail=findViewById(R.id.username);
        fpbn=findViewById(R.id.btn);

        fpbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=femail.getText().toString();


                if(email.isEmpty()){
                    Toast.makeText(forgetpass.this, "Please provide your email", Toast.LENGTH_SHORT).show();
                }else{
                    forgotPassword();
                }
            }
        });

    }




    private void forgotPassword(){

        FirebaseAuth auth=FirebaseAuth.getInstance();

        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(forgetpass.this, "Check your email", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(forgetpass.this, MainActivity.class));

                            finish();
                        }else{
                            Toast.makeText(forgetpass.this, "Error :"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}