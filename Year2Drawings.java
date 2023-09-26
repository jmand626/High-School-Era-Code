/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.graphics;
import java.awt.*;
import java.util.*;

/**
 *
 * @author joban
 */
public class Year2Drawings {

    public static void main(String[] args) {
       DrawingPanel panel = new DrawingPanel(600, 400);//600 is the WIDTH in pixels and 400 is the HEIGHT
       Graphics g = panel.getGraphics(); //need the import statement:  import java.awt.*;
       firstDraw(g);
    }
    
    public static void firstDraw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,600, 400);
        g.setColor(Color.GRAY);
        g.drawOval(0, 0, 600, 350);
        g.setColor(Color.GREEN);
        g.fillRect(175, 350, 250,60);
        g.setColor(Color.GRAY);
        g.fillRect(270,120, 50,230);
        g.fillRect(270, 95, 10, 25);
        g.fillRect(310, 95, 10, 25);
        g.setColor(Color.RED);
        g.fillOval(280, 91, 30, 30);
        g.setColor(Color.YELLOW);
        g.fillRect(292, 90, 6, 30 );
        g.setColor(Color.ORANGE);
        g.fillRect(280, 100,30, 15 );
        
        g.setColor(Color.BLUE);
        Random rWidth = new Random();
        Random rHeight = new Random();
        int x = 0;
        int y = 0;
        for(int i = 0; i < 25; i++){
           x = rWidth.nextInt(500) - 70;
           y = rHeight.nextInt(285) - 30;
           g.fillOval(x, y, 10,10);
        }
    }
    
}
