package com.example.authenticationexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText name,pass;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        auth = FirebaseAuth.getInstance();
    }

    public void login(View view) {
        String email = name.getText().toString();
        String upass = pass.getText().toString();
        if(email.isEmpty()||upass.isEmpty()){
            Toast.makeText(this, "Shouldn't be empty", Toast.LENGTH_SHORT).show();
        }
        auth.signInWithEmailAndPassword(email,upass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Logged in Successful", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Invalid user", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void register(View view) {
        Intent i = new Intent(this,RegiterActivity.class);
        startActivity(i);
    }
}
