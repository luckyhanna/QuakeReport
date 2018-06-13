package com.example.android.quakereport;

import java.math.BigDecimal;

public class Earthquake {

    private double mMagnitude;

    private String mPlace;

    private Long mTime;

    private String mUrl;

    public Earthquake(double magnitude, String place, Long time, String url) {
        this.mMagnitude = magnitude;
        this.mPlace = place;
        this.mTime = time;
        this.mUrl = url;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public void setMagnitude(double mMagnitude) {
        this.mMagnitude = mMagnitude;
    }

    public String getPlace() {
        return mPlace;
    }

    public void setPlace(String mPlace) {
        this.mPlace = mPlace;
    }

    public Long getTime() {
        return mTime;
    }

    public void setTime(Long mTime) {
        this.mTime = mTime;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
