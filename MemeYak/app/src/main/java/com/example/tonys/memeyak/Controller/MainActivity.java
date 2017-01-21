package com.example.tonys.memeyak.Controller;

// ListView
import android.app.Application;
import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.tonys.memeyak.Model.Post;
import com.example.tonys.memeyak.R;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tonys.memeyak.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;



public class MainActivity extends  ListActivity {

    private ListView mListView;
    private ImageAdapter mImageadapter;
    private EditText urlText;
    private Button button;
    private ArrayList<Post> posts;
    private Context context;
    private Stack<Post> postsToDo;
    private boolean firstAdd;
// master

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
// ListView
        firstAdd = true;

        postsToDo = new Stack();
        posts = new ArrayList<>();
        mImageadapter = new ImageAdapter(this, posts);
        setListAdapter(mImageadapter);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
// Austin-Firebase
        final DatabaseReference myPostsRef = database.getReference("posts");

        myPostsRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String url = dataSnapshot.getValue().toString();

                Log.i("CHILDADDED", url);
                Post malone = new Post(url, 0);
                posts.add(malone);
                //postsToDo.add(malone);
                mImageadapter.notifyDataSetChanged();
                Log.i("LOCALPOSTS", posts.toString());
                //dataSnapshot.getValue().toString();

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
            //click upload
            public void onClick(View v) {
                // Perform action on click
                String url = urlText.getText().toString();
                Log.i("YOO",url);

                urlText.setText("");

                if(url.equals("")) {

                    Context context = getApplicationContext();
                    CharSequence text = "URL is blank!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {

                    myPostsRef.push().setValue(url);
                    postsToDo.push(new Post(url, 0));

                }

            }
        });

        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

// master
// master
    }

}
