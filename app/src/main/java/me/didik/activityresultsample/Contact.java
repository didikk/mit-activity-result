package me.didik.activityresultsample;

/**
 * Created by didik on 12/21/16.
 * C
 */

public class Contact {
    private String name;
    private String type;
    private String phone;

    public Contact(String name, String type, String phone) {
        this.name = name;
        this.type = type;
        this.phone = phone;
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
}
