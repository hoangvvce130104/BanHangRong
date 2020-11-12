package com.example.banhangrong.Class;

public class Location {
    //declare variables
    private int location_ID;
    private float longitude;
    private float latitude;
    private int location_status;

    //constructor null
    public Location() {
    }

    /**
     * Constructor
     * @param location_ID
     * @param longitude
     * @param latitude
     * @param location_status
     */
    public Location(int location_ID, float longitude, float latitude, int location_status) {
        this.location_ID = location_ID;
        this.longitude = longitude;
        this.latitude = latitude;
        this.location_status = location_status;
    }

    /**
     * Constructor hasn't id
     * @param longitude
     * @param latitude
     * @param location_status
     */
    public Location(float longitude, float latitude, int location_status) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.location_status = location_status;
    }

    /**
     * Getter setter of all variables
     * @return
     */
    public int getLocation_ID() {
        return location_ID;
    }

    public void setLocation_ID(int location_ID) {
        this.location_ID = location_ID;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public int getLocation_status() {
        return location_status;
    }

    public void setLocation_status(int location_status) {
        this.location_status = location_status;
    }

    @Override
    public String toString() {
        return "Location{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
