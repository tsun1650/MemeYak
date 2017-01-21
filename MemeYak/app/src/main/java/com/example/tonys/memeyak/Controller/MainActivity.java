package com.example.tonys.memeyak.Controller;

import android.app.Application;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.tonys.memeyak.Model.Post;
import com.example.tonys.memeyak.R;

import java.util.ArrayList;

public class MainActivity extends ListActivity {
    private ListView mListView;
    private ImageAdapter mImageadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Post> posts = new ArrayList();
        posts.add(new Post ("@mipmap/clips", 0));
        posts.add(new Post ("@mipmap/dos",0));
        mImageadapter = new ImageAdapter(this, posts);
        setListAdapter(mImageadapter);

    }
}
