package com.example.uidq0205.mdo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by uidq0205 on 2017-12-15.
 */

public class MesInter implements Parcelable {
    private long id;
    private String content;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public String toString() {
        return "MesInter{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.content);
    }
    public MesInter() {
    }
    protected MesInter(Parcel in) {
        this.id = in.readLong();
        this.content = in.readString();
    }
    public static final Creator<MesInter> CREATOR = new Creator<MesInter>() {
        @Override
        public MesInter createFromParcel(Parcel source) {
            return new MesInter(source);
        }
        @Override
        public MesInter[] newArray(int size) {
            return new MesInter[size];
        }
    };
}