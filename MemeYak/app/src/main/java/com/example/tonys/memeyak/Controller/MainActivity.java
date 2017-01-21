package com.example.tonys.memeyak.Controller;

// ListView
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

  import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
///// Austin-Firebase
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tonys.memeyak.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.LinkedList;
//
//public class MainActivity extends AppCompatActivity {
//
//    Button button;
//    EditText urlText;
//
//
//import com.example.tonys.memeyak.R;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText urlText;
    private Button button;
// master

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// ListView


        ArrayList<Post> posts = new ArrayList();
        posts.add(new Post ("@mipmap/clips", 0));
        posts.add(new Post ("@mipmap/dos",0));
        mImageadapter = new ImageAdapter(this, posts);
        setListAdapter(mImageadapter);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
// Austin-Firebase
        final DatabaseReference myPostsRef = database.getReference("posts");

        myPostsRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.i("CHILDADDED", dataSnapshot.getValue().toString());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        urlText = (EditText) findViewById(R.id.urlEditText);
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                String url = urlText.getText().toString();
//                Log.e("YOO",url);
                myPostsRef.push().setValue(url);
                urlText.setText("");
            }
        });

        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
// master
// master
    }
}
