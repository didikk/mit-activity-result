package me.didik.activityresultsample.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by didik on 12/21/16.
 * C
 */

public class Contact implements Parcelable {
    private int id;
    private String name;
    private String email;
    private String type;
    private String phone;

    public Contact(String name, String type, String phone) {
        this.name = name;
        this.type = type;
        this.phone = phone;
    }

    public Contact(String name, String email, String type, String phone) {
        this.name = name;
        this.email = email;
        this.type = type;
        this.phone = phone;
    }

    public Contact(int id, String name, String email, String type, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.type = type;
        this.phone = phone;
    }

    public Contact() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.email);
        dest.writeString(this.type);
        dest.writeString(this.phone);
    }

    protected Contact(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.email = in.readString();
        this.type = in.readString();
        this.phone = in.readString();
    }

    public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel source) {
            return new Contact(source);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };
}