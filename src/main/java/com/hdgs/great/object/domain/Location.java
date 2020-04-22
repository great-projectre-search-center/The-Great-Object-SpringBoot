package com.hdgs.great.object.domain;

public class Location {
    private double longtitude;//位置的经度
    private double latitude;//位置的纬度

    public Location() {
    }

    public Location(double longtitude, double latitude) {
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "longtitude=" + longtitude +
                ", latitude=" + latitude +
                '}';
    }
}
