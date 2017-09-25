/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring;

import com.sg.flooring.controller.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jstuart15
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        if (ctx.getBean("orderDao").toString().contains("Training")) {
            System.out.println("\n==== TRAINING MODE ==== "
                    + "\nNo transactions will be saved.");
        }
        Controller controller = ctx.getBean("controller", Controller.class);
        controller.run();
    }
}
