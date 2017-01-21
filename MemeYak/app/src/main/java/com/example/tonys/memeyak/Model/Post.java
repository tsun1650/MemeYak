package com.example.tonys.memeyak.Model;

import android.media.Image;

/**
 * Created by tonys on 1/21/2017.
 */
public class Post {
    int voteCount;
    String imgSrc;
    public Post () {
        String src = "@drawable/ic_action_name";
        voteCount = 0;
    }
    public Post (String imgSrc, int vote) {
        this.imgSrc = imgSrc;
        this.voteCount = vote;
    }
    public void vote(int vote) {
        voteCount += vote;
    }
    public int getVoteCount() {return voteCount;}
    public void setImgSrc(String s) {imgSrc = s;}
    public String getImgSrc() {return imgSrc;}
// ListView
}
