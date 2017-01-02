package me.didik.activityresultsample.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by didik on 12/21/16.
 * C
 */

@Table(name = "Contact")
public class Contact extends Model implements Parcelable {
    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Type")
    private String type;

    @Column(name = "Phone")
    private String phone;

    public Contact() {
        super();
    }

    public Contact(String name, String email, String type, String phone) {
        super();
        this.name = name;
        this.email = email;
        this.type = type;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.email);
        dest.writeString(this.type);
        dest.writeString(this.phone);
    }

    protected Contact(Parcel in) {
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

    public static List<Contact> get() {
        return new Select().from(Contact.class).execute();
    }
}
