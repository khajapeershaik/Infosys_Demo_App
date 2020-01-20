package com.infosys.modelview;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResponseList implements Parcelable {


    @SerializedName("title")
    private final String airportCode;

    @SerializedName("rows")
    private final ArrayList<DataList> dataList;

    public ResponseList(String airportCode, ArrayList<DataList> dataList) {
        this.airportCode = airportCode;
        this.dataList = dataList;
    }

    protected ResponseList(Parcel in) {
        airportCode = in.readString();
        dataList = in.createTypedArrayList(DataList.CREATOR);
    }

    public String getAirportCode() {
        return airportCode;
    }

    public ArrayList<DataList> getDataList() {
        return dataList;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(airportCode);
        dest.writeTypedList(dataList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ResponseList> CREATOR = new Creator<ResponseList>() {
        @Override
        public ResponseList createFromParcel(Parcel in) {
            return new ResponseList(in);
        }

        @Override
        public ResponseList[] newArray(int size) {
            return new ResponseList[size];
        }
    };
}
