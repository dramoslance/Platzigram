package com.dramit.platzigram.model;

/**
 * Created by Deiby Ramos on 22/02/2018.
 */

public class Card {

    private String picture;
    private String username;
    private String date;
    private String likes = "0";

    public Card(String picture, String username, String date, String likes) {
        this.picture = picture;
        this.username = username;
        this.date = date;
        this.likes = likes;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }
}
