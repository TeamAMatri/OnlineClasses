package com.example.recycleexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    String[] names = {"Alpha","Beta","Cupcake","Donut","Eclairs","Froyo","Gingerbreed",
            "Honeycomb","Icecream","Jellybean"};
    int[] images = {R.drawable.alpha,R.drawable.beta,R.drawable.cupcake
    ,R.drawable.donut,R.drawable.eclairs,R.drawable.froyo,R.drawable.ginger,R.drawable.honey
    ,R.drawable.icecream,R.drawable.jbean};
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        myAdapter = new MyAdapter(this,names,images);
        rv.setAdapter(myAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        //rv.setLayoutManager(new GridLayoutManager(this,2));
    }
}
