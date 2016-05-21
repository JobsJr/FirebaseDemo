package com.example.rajeevkr.studioexplore.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rajeevkr on 5/21/16.
 */

public class ToDoList implements Parcelable {
    public String  todo;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.todo);
    }

    public ToDoList() {
    }

    protected ToDoList(Parcel in) {
        this.todo = in.readString();
    }

    public static final Parcelable.Creator<ToDoList> CREATOR = new Parcelable.Creator<ToDoList>() {
        @Override
        public ToDoList createFromParcel(Parcel source) {
            return new ToDoList(source);
        }

        @Override
        public ToDoList[] newArray(int size) {
            return new ToDoList[size];
        }
    };
}
