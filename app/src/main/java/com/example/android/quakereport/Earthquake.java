package com.example.android.quakereport;

import java.math.BigDecimal;

public class Earthquake {

    private BigDecimal mMagnitude;

    private String mPlace;

    private Long mTime;

    public Earthquake(BigDecimal magnitude, String place, Long time) {
        this.mMagnitude = magnitude;
        this.mPlace = place;
        this.mTime = time;
    }

    public BigDecimal getMagnitude() {
        return mMagnitude;
    }

    public void setMagnitude(BigDecimal mMagnitude) {
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
}
