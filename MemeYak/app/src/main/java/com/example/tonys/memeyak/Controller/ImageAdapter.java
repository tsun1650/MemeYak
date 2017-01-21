package com.example.tonys.memeyak.Controller;

import android.content.Context;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tonys.memeyak.Model.Post;
import com.example.tonys.memeyak.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by tonys on 1/21/2017.
 */
public class ImageAdapter extends ArrayAdapter<Post> {

    public ImageAdapter(Context context, ArrayList<Post> posts) {
        super(context, R.layout.post_view,posts);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater theInflater = LayoutInflater.from(getContext());
        View theView = theInflater.inflate(R.layout.post_view, parent, false);

        Post post = getItem(position);
        String img = post.getImgSrc();
        int voteCount = post.getVoteCount();

        ImageView post_view = (ImageView)theView.findViewById(R.id.imgSrc);
        TextView voteCount_view = (TextView) theView.findViewById(R.id.voteCount);

        post.setImgSrc(img);
        post.vote(voteCount);

        return theView;



    }
}
