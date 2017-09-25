/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classmodeling;

/**
 *
 * @author jstuart15
 */
public class House1 {

    private float latitude;
    private float longitude;

    public House1() {

    }

    public House1(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //getters and setters
    public String[] getAddress(float latitude, float longitude) {
        String[] address = new String[5];
        return address;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

}
