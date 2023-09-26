package com.mycompany.graphics;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author joban
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Demo2 {
    static int x = 0;
    static int y = 0;
    static int size = 50;

    public static void main(String[] args){
        JFrame frame = new JFrame("Demo Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new MyPanel();

        p.setFocusable(true);
        p.setPreferredSize(new Dimension(400, 400));
        frame.add(p);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
    public static class MyPanel extends JPanel implements KeyListener{

        public MyPanel(){
            addKeyListener(this);
        }

        @Override
        public void paintComponent(Graphics g){
            g.clearRect(0,0,400,400);
            g.fillOval(x, y ,size, size);
        }

        public void keyReleased(KeyEvent ke){}

        public void keyPressed(KeyEvent ke){
            if(ke.getKeyCode() == KeyEvent.VK_UP){
                y-=size;
            }
            if(ke.getKeyCode() == KeyEvent.VK_DOWN){
                y+=size;
            }
            if(ke.getKeyCode() == KeyEvent.VK_LEFT){
                x-=size;
            }
            if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
               x+=size; 
            }
            repaint();
        }

        public void keyTyped(KeyEvent ke){}
    }

}