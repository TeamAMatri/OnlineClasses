package com.example.rpsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[] options = {"Rock","Paper","Scissor"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void rock(View view) {
        int r=new Random().nextInt(3);//new Random().nextInt(0,n-1)
        if(r==0){
            Toast.makeText(this, "Game Draw !!! becoz computer selected "+
                    options[r]+" and you selected "+options[0], Toast.LENGTH_SHORT).show();
        }
        else if(r==2){
            Toast.makeText(this, "Game won !!! becoz computer selected "+
                    options[r]+" and you selected "+options[0], Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "you lost !!! becoz computer selected "+
                    options[r]+" and you selected "+options[0], Toast.LENGTH_SHORT).show();
        }
    }

    public void paper(View view) {
        int r=new Random().nextInt(3);
        if(r==1){
            Toast.makeText(this, "Game Draw !!! becoz computer selected "+
                    options[r]+" and you selected "+options[1], Toast.LENGTH_SHORT).show();
        }
        else if(r==0){
            Toast.makeText(this, "Game won !!! becoz computer selected "+
                    options[r]+" and you selected "+options[1], Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "you lost !!! becoz computer selected "+
                    options[r]+" and you selected "+options[1], Toast.LENGTH_SHORT).show();
        }
    }

    public void scissor(View view) {
        int r=new Random().nextInt(3);
        if(r==2){
            Toast.makeText(this, "Game Draw !!! becoz computer selected "+
                    options[r]+" and you selected "+options[2], Toast.LENGTH_SHORT).show();
        }
        else if(r==1){
            Toast.makeText(this, "Game won !!! becoz computer selected "+
                    options[r]+" and you selected "+options[2], Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "you lost !!! becoz computer selected "+
                    options[r]+" and you selected "+options[2], Toast.LENGTH_SHORT).show();
        }
    }
}
