package com.manager.singlescreenapp.model;


import com.google.gson.annotations.SerializedName;

public class Author {

    @SerializedName("forks")
    private String forks;

    @SerializedName("builtBy")
    private BuiltBy[] builtBy;

    @SerializedName("author")
    private String author;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("language")
    private String language;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("languageColor")
    private String languageColor;

    @SerializedName("stars")
    private String stars;

    @SerializedName("url")
    private String url;

    @SerializedName("currentPeriodStars")
    private String currentPeriodStars;

    public String getForks() {
        return forks;
    }


    public BuiltBy[] getBuiltBy() {
        return builtBy;
    }


    public String getAuthor() {
        return author;
    }


    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }


    public String getLanguage() {
        return language;
    }


    public String getAvatar() {
        return avatar;
    }


    public String getLanguageColor() {
        return languageColor;
    }


    public String getStars() {
        return stars;
    }


    public String getUrl() {
        return url;
    }


    public String getCurrentPeriodStars() {
        return currentPeriodStars;
    }


    @Override
    public String toString() {
        return "ClassPojo [forks = " + forks + ", builtBy = " + builtBy + ", author = " + author + ", name = " + name + ", description = " + description + ", language = " + language + ", avatar = " + avatar + ", languageColor = " + languageColor + ", stars = " + stars + ", url = " + url + ", currentPeriodStars = " + currentPeriodStars + "]";
    }
}


