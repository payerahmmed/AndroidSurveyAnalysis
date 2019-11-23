package com.example.surveyanalysis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextUsername;
    EditText editTextPassword;
    Button loginB;
    Button singupbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        singupbtn = findViewById(R.id.sinup);
        editTextUsername = findViewById(R.id.usernameId);
        editTextPassword = findViewById(R.id.passwordId);
        loginB = findViewById(R.id.loginbtn);

        singupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignupForm.class);
               startActivity(intent);
            }
        });

    }
}
