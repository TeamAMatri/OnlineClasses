package com.example.recycleexample;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context ct;
    ArrayList<Aitam> list;

    public MyAdapter(MainActivity mainActivity, ArrayList<Aitam> list) {
        this.ct = mainActivity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(ct).inflate(R.layout.row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv.setText(list.get(position).getTitle());
        Picasso.with(ct).load(list.get(position).getImglink()).
                placeholder(R.drawable.ic_launcher_background).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv;
        CircleImageView iv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv  = itemView.findViewById(R.id.tv);
            iv = itemView.findViewById(R.id.iv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int i = getAdapterPosition();
            Intent intent = new Intent(ct,DisplayActivity.class);
            intent.putExtra("name",list.get(i).getName());
            intent.putExtra("author",list.get(i).getAuthor());
            intent.putExtra("date",list.get(i).getDate());
            intent.putExtra("title",list.get(i).getTitle());
            intent.putExtra("desc",list.get(i).getDesc());
            intent.putExtra("url",list.get(i).getUrl());
            intent.putExtra("imglink",list.get(i).getImglink());
            intent.putExtra("content",list.get(i).getContent());
            ct.startActivity(intent);
        }
    }
}
