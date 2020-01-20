package com.infosys.modelview;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class DataList implements Parcelable {

    @SerializedName("title")
    private final String title;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageHref() {
        return imageHref;
    }

    @SerializedName("description")
    private final String description;

    @SerializedName("imageHref")
    private final String imageHref;

    public DataList(String title, String description, String imageHref) {
        this.title = title;
        this.description = description;
        this.imageHref = imageHref;
    }

    protected DataList(Parcel in) {
        title = in.readString();
        description = in.readString();
        imageHref = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(imageHref);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DataList> CREATOR = new Creator<DataList>() {
        @Override
        public DataList createFromParcel(Parcel in) {
            return new DataList(in);
        }

        @Override
        public DataList[] newArray(int size) {
            return new DataList[size];
        }
    };
}
