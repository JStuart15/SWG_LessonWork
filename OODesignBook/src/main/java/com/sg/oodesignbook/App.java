/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.oodesignbook;

/**
 *
 * @author jstuart15
 */
public class App {
    public static void main(String[] args) {
        Gear myGear = new Gear(15,2);
        System.out.println(myGear.getRatio());
        Gear myGear2 = new Gear(34,7);
        System.out.println(myGear2.getRatio());
        Wheel myWheel = new Wheel(20,5);
        System.out.println(myWheel.getWheelDiameter());
    }
}
