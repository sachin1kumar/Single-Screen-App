package com.manager.singlescreenapp.domain.entities;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class BuiltBy implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.href);
        dest.writeString(this.avatar);
        dest.writeString(this.username);
    }

    public BuiltBy() {
    }

    protected BuiltBy(Parcel in) {
        this.href = in.readString();
        this.avatar = in.readString();
        this.username = in.readString();
    }

    public static final Parcelable.Creator<BuiltBy> CREATOR = new Parcelable.Creator<BuiltBy>() {
        @Override
        public BuiltBy createFromParcel(Parcel source) {
            return new BuiltBy(source);
        }

        @Override
        public BuiltBy[] newArray(int size) {
            return new BuiltBy[size];
        }
    };
}


