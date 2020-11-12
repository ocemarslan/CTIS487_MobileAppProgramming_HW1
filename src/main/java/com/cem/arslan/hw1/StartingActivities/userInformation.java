package com.cem.arslan.hw1.StartingActivities;

import android.os.Parcel;
import android.os.Parcelable;


//osman cem arslan ctis487 hw1 object class
public class userInformation implements Parcelable {
    private String name,surname,gender;

    public userInformation(String name, String surname, String gender) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User Information\n" + "User Name:" + name + "\nUser Surname:" + surname + "\nUser Gender:" + gender;
    }




    protected userInformation(Parcel in) {
        name = in.readString();
        surname = in.readString();
        gender = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(surname);
        dest.writeString(gender);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<userInformation> CREATOR = new Parcelable.Creator<userInformation>() {
        @Override
        public userInformation createFromParcel(Parcel in) {
            return new userInformation(in);
        }

        @Override
        public userInformation[] newArray(int size) {
            return new userInformation[size];
        }
    };
}
