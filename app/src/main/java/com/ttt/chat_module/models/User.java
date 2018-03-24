package com.ttt.chat_module.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by TranThanhTung on 20/02/2018.
 */

public class User implements Parcelable {
    public static final String FIRST_NAME = "firstName";
    public static final String EMAIL = "email";
    public static final String IS_ONLINE = "isOnline";

    private String email;
    private String firstName;
    private String lastName;
    private String avatarUrl;
    private String coverUrl;
    private boolean isOnline = false;

    public User(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof User && ((User) obj).email.equals(this.email);
    }

    @Override
    public int hashCode() {
        if(email != null) {
            return email.hashCode();
        }
        return super.hashCode();
    }

    public User(Parcel in) {
        email = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        avatarUrl = in.readString();
        coverUrl = in.readString();
        isOnline = in.readByte() != 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(email);
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(avatarUrl);
        parcel.writeString(coverUrl);
        parcel.writeByte((byte) (isOnline ? 1 : 0));
    }
}
