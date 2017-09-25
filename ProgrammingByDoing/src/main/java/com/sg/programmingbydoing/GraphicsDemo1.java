/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.programmingbydoing;
import java.awt.*;
import javax.swing.JFrame;
/**
 *
 * @author jstuart15
 */
public class GraphicsDemo1 extends Canvas{
    public void paint(Graphics g){
        g.setColor(Color.green);
        g.drawRect(50, 20, 100, 200);
        g.fillOval(160, 20, 100, 200);
        g.setColor(Color.blue);
        g.fillRect(200, 400, 200, 20);
        g.drawOval(200, 420, 200, 100);
        
        g.setColor(Color.black);
        g.drawString("Graphics are pretty neat.", 500, 100);

    }
    
    public static void main(String[] args) {
        //You can change the title or size here if you want.
        JFrame win = new JFrame("Jeff's Graphics Demo 1");
        win.setSize(800,600);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GraphicsDemo1 canvas1 = new GraphicsDemo1();
        win.add(canvas1);
        win.setVisible(true);
    }
}
