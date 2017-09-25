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
public class Airplane1 {

    private String planeType;
    private String planeModel;
    private int soulsOnBoard;
    private String callSign;
    private String airline;

    //constructors
    public Airplane1(String planeType, String planeModel, int soulsOnBoard, String callSign, String airline) {
        this.planeType = planeType;
        this.planeModel = planeModel;
        this.soulsOnBoard = soulsOnBoard;
        this.callSign = callSign;
        this.airline = airline;
    }

    
    //getters and setters
    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public String getPlaneModel() {
        return planeModel;
    }

    public void setPlaneModel(String planeModel) {
        this.planeModel = planeModel;
    }

    public int getSoulsOnBoard() {
        return soulsOnBoard;
    }

    public void setSoulsOnBoard(int soulsOnBoard) {
        this.soulsOnBoard = soulsOnBoard;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

}
