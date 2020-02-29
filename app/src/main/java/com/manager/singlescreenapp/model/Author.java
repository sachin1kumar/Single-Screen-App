package com.manager.singlescreenapp.model;


import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Author implements Parcelable {

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

    // State of the item
    private boolean expanded;

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.forks);
        dest.writeTypedArray(this.builtBy, flags);
        dest.writeString(this.author);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.language);
        dest.writeString(this.avatar);
        dest.writeString(this.languageColor);
        dest.writeString(this.stars);
        dest.writeString(this.url);
        dest.writeString(this.currentPeriodStars);
    }

    public Author() {
    }

    protected Author(Parcel in) {
        this.forks = in.readString();
        this.builtBy = in.createTypedArray(BuiltBy.CREATOR);
        this.author = in.readString();
        this.name = in.readString();
        this.description = in.readString();
        this.language = in.readString();
        this.avatar = in.readString();
        this.languageColor = in.readString();
        this.stars = in.readString();
        this.url = in.readString();
        this.currentPeriodStars = in.readString();
    }

    public static final Parcelable.Creator<Author> CREATOR = new Parcelable.Creator<Author>() {
        @Override
        public Author createFromParcel(Parcel source) {
            return new Author(source);
        }

        @Override
        public Author[] newArray(int size) {
            return new Author[size];
        }
    };

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}


