package com.example.exampleintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ShareActionProvider;

public class MainActivity extends AppCompatActivity {

    // declare the view here
    EditText name,num,link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initalize all the views
        name = findViewById(R.id.name);
        num = findViewById(R.id.number);
        link = findViewById(R.id.link);
    }

    public void send(View view) {
        String n= name.getText().toString();
        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("key",n);
        startActivity(i);
    }

    public void call(View view) {
        String n = num.getText().toString().trim();
        Uri uri = Uri.parse("tel:"+n);
        Intent i = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i);

    }

    public void search(View view) {
        String n = link.getText().toString().trim();
        Uri uri = Uri.parse("https://"+n);
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);
    }
}
