package com.example.authenticationexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegiterActivity extends AppCompatActivity {
    EditText rname,rpass;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiter);
        rname = findViewById(R.id.remail);
        rpass = findViewById(R.id.rpass);
        auth = FirebaseAuth.getInstance();
    }

    public void register(View view) {
            String email = rname.getText().toString();
            String pass = rpass.getText().toString();
            if(email.isEmpty()||pass.isEmpty()){
                Toast.makeText(this, "Shouldn't be empty", Toast.LENGTH_SHORT).show();
            }
            else{
                auth.createUserWithEmailAndPassword(email,pass).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegiterActivity.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(RegiterActivity.this, "Regsitration failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
    }
}
