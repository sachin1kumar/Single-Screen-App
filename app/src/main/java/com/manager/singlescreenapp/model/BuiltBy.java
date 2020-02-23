package com.manager.singlescreenapp.model;


import com.google.gson.annotations.SerializedName;

public class BuiltBy {

    @SerializedName("href")
    private String href;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("username")
    private String username;

    public String getHref() {
        return href;
    }


    public String getAvatar() {
        return avatar;
    }


    public String getUsername() {
        return username;
    }


    @Override
    public String toString() {
        return "ClassPojo [href = " + href + ", avatar = " + avatar + ", username = " + username + "]";
    }
}


