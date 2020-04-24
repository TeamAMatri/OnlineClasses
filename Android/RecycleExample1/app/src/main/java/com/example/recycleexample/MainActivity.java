package com.example.recycleexample;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    RecyclerView rv;
    MyAdapter myAdapter;
    //ArrayList<Aitam> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
       // list = new ArrayList<>();
        getSupportLoaderManager().initLoader(0,null,this);
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return new AsyncTaskLoader<String>(this) {
            @Override
            protected void onStartLoading() {
                super.onStartLoading();
                forceLoad();
            }

            @Nullable
            @Override
            public String loadInBackground() {

                try {
                    URL url = new URL("https://newsapi.org/v2/top-headlines?sources=google-news&apiKey=9289a087e01d439896afd13a985363b2");
                    HttpsURLConnection huc = (HttpsURLConnection) url.openConnection();
                    huc.setRequestMethod("GET");
                    huc.connect();
                    InputStream is = huc.getInputStream();
                    BufferedReader br  = new BufferedReader(new InputStreamReader(is));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while((line=br.readLine())!=null){
                        sb.append(line);
                    }
                    return sb.toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        ArrayList<Aitam> list=new ArrayList<>();
        try {
            JSONObject root = new JSONObject(data);
            JSONArray articles = root.getJSONArray("articles");
            for (int i=0;i<articles.length();i++){
                JSONObject object = articles.getJSONObject(i);
                JSONObject source = object.getJSONObject("source");
                String name = source.getString("name");
                String author = object.getString("author");
                String title = object.getString("title");
                String desc = object.getString("description");
                String url = object.getString("url");
                String imglink = object.getString("urlToImage");
                String date = object.getString("publishedAt");
                String content = object.getString("content");
                Aitam aitam = new Aitam(name,author,title,desc,url,imglink,date,content);
                list.add(aitam);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        myAdapter = new MyAdapter(this,list);
        rv.setAdapter(myAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}
