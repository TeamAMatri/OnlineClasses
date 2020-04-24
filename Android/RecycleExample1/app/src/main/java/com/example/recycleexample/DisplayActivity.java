package com.example.recycleexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recycleexample.databinding.ActivityDisplayBinding;
import com.squareup.picasso.Picasso;

public class DisplayActivity extends AppCompatActivity {

    /*ImageView iv;
    TextView name,date,author,title,desc,content;*/
    ActivityDisplayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_display);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_display);
        String name = getIntent().getStringExtra("name");
        String title = getIntent().getStringExtra("title");
        String author = getIntent().getStringExtra("author");
        String date = getIntent().getStringExtra("date");
        String desc = getIntent().getStringExtra("desc");
        String url = getIntent().getStringExtra("url");
        String link = getIntent().getStringExtra("imglink");
        String content = getIntent().getStringExtra("content");
        Picasso.with(this).load(link).into(binding.imagev);
        binding.name.setText(name);
        binding.publishedat.setText(date);
        binding.title.setText(title);
        binding.author.setText(author);
        binding.desc.setText(desc);
        binding.content.setText(content);
    }
}
