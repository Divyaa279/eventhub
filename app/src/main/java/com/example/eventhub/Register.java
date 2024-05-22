package com.example.eventhub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    private int totalValue = 0;
    private TextView totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        totalTextView = findViewById(R.id.totalTextView);
        View SmtBtn =findViewById(R.id.sbmt);

        SmtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Register.this, tick_animation.class);
                startActivity(i);
            }
        });

        CheckBox techExpoCheckbox = findViewById(R.id.techExpoCheckbox);
        CheckBox hackathonCheckbox = findViewById(R.id.hackathonCheckbox);
        CheckBox globalFusionFestCheckbox = findViewById(R.id.globalFusionFestCheckbox);
        CheckBox mindscapeSymposiumCheckbox = findViewById(R.id.mindscapeSymposiumCheckbox);
        CheckBox stemExpoExtravaganzaCheckbox = findViewById(R.id.stemExpoExtravaganzaCheckbox);
        CheckBox artsRenaissanceCheckbox = findViewById(R.id.artsRenaissanceCheckbox);
        CheckBox careerCarnivalCheckbox = findViewById(R.id.careerCarnivalCheckbox);
        CheckBox entrepreneurshipExpoCheckbox = findViewById(R.id.entrepreneurshipExpoCheckbox);
        CheckBox literarySoireeCheckbox = findViewById(R.id.literarySoireeCheckbox);
        CheckBox cosmicOdysseyCheckbox = findViewById(R.id.cosmicOdysseyCheckbox);

        techExpoCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateTotal(buttonView, isChecked);
            }
        });

        hackathonCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateTotal(buttonView, isChecked);
            }
        });

        globalFusionFestCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateTotal(buttonView, isChecked);
            }
        });

        mindscapeSymposiumCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateTotal(buttonView, isChecked);
            }
        });

        stemExpoExtravaganzaCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateTotal(buttonView, isChecked);
            }
        });

        artsRenaissanceCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateTotal(buttonView, isChecked);
            }
        });

        careerCarnivalCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateTotal(buttonView, isChecked);
            }
        });

        entrepreneurshipExpoCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateTotal(buttonView, isChecked);
            }
        });

        literarySoireeCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateTotal(buttonView, isChecked);
            }
        });

        cosmicOdysseyCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateTotal(buttonView, isChecked);
            }
        });
    }

    private void updateTotal(CompoundButton buttonView, boolean isChecked) {
        int value = Integer.parseInt(buttonView.getTag().toString());
        if (isChecked) {
            totalValue += value;
        } else {
            totalValue -= value;
        }
        updateTotalTextView();
    }


    private void updateTotalTextView() {
        totalTextView.setText("Total: " + totalValue);
    }
}
