/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.robocode;

import java.util.Random;
import robocode.*;

/**
 *
 * @author jstuart15
 */
public class JsRobot1 extends Robot {

    public void run() {
        Random randnum = new Random();
        // Initialization of the robot should be put here

        // After trying out your robot, try uncommenting the import at the top,
        // and the next line:
        // setColors(Color.red,Color.blue,Color.green); // body,gun,radar
        // Robot main loop
        while (true) {
            
            // Replace the next 4 lines with any behavior you would like
            
            ahead(randnum.nextGaussian()*100);
            turnGunRight(360);
            back(randnum.nextGaussian()*100);
            turnGunRight(360);
        }
    }

    /**
     * onScannedRobot: What to do when you see another robot
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        // Replace the next line with any behavior you would like
        fire(1);
        e.g

    }

    /**
     * onHitByBullet: What to do when you're hit by a bullet
     */
    public void onHitByBullet(HitByBulletEvent e) {
        // Replace the next line with any behavior you would like
        double headingToFire;
        if (e.getBullet().getHeading() > 180){
            headingToFire = e.getBullet().getHeading() - 180;
        } else{
            headingToFire = e.getBullet().getHeading() + 180;
        }
        //determine my gun's heading
        double myGunHeading = getGunHeading();
        turnGunRight(headingToFire - myGunHeading);
        fire(1);
    }

    /**
     * onHitWall: What to do when you hit a wall
     */
    public void onHitWall(HitWallEvent e) {
        // Replace the next line with any behavior you would like
        back(40);
    }
}
