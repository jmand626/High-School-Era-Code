/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
import java.util.ArrayList;

/**
 *
 * @author joban
 */
public class Demo3 {
    static final int WIDTH = 600;
    static final int HEIGHT = 400;
    static final int SIZE = 100;
    static Timer t;
    
    public static void main(String[] args) throws Exception{
        JFrame frame = new JFrame("Demo3");
        MyPanel p = new MyPanel();
        t = new Timer(1500, p);
        p.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        p.addMouseListener(p);
        p.setFocusable(true);
        frame.add(p);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        t.start();
    }
    public static class MyPanel extends JPanel implements MouseListener, ActionListener{
        BufferedImage minion;
        ArrayList<BufferedImage> minions;
        ArrayList<BufferedImage> backgrounds;
        int minionNumber;
        int bgNumber;
        int minionX;
        int minionY;
        int counter = 0;
        
        public MyPanel() throws IOException{
           minion = ImageIO.read(new File("minion.png"));
           minionNumber = 0;
           minions = new ArrayList<>();
           backgrounds = new ArrayList<>();
           File f = new File("minions");
           File[] files = f.listFiles();
           for(int i = 0; i < files.length; i++){
               minions.add(ImageIO.read(files[i]));
           }
           f = new File("backgrounds");
           files = f.listFiles();
           for(int i = 0; i < files.length; i++){
               backgrounds.add(ImageIO.read(files[i]));
           }
           minionX = 0;
           minionY = 0;
        }
        public boolean intersect(int x, int y){
            if(x>=minionX && x<minionX+SIZE){
                return y >=minionY && y <minionY+SIZE;
            }
            return false;
        }
        @Override
        public void paintComponent(Graphics g){
            g.clearRect(0, 0, Demo3.WIDTH, Demo3.HEIGHT);
            g.drawImage(backgrounds.get(bgNumber%backgrounds.size()), 0, 0, Demo3.WIDTH, Demo3.HEIGHT, null);
            g.drawImage(minions.get(minionNumber % minions.size()), minionX, minionY, SIZE, SIZE, null);
            g.drawString("Count: " + counter, Demo3.WIDTH/2 - SIZE, SIZE);
            g.drawString("Speed: " + t.getDelay()/1000.0, Demo3.WIDTH/2 - SIZE, SIZE+g.getFont().getSize()*2 );
                    
        }
        @Override
        public void mouseClicked(MouseEvent me){
            
        }
        @Override
        public void mouseEntered(MouseEvent me){
            
        }
        @Override
        public void mouseExited(MouseEvent me){
            
        }
        @Override
        public void mousePressed(MouseEvent me){
            if(intersect(me.getX(),me.getY())){
                  counter++;
                if(counter%5 == 0){
                    t.setDelay(t.getDelay()*9/10);
                    bgNumber++;
                }
                minionNumber++;
            }
                  
        }
        @Override
        public void mouseReleased(MouseEvent me){
            
        }
        @Override
        public void actionPerformed(ActionEvent ae){
            minionX = (int)(Math.random() * Demo3.WIDTH/SIZE) * SIZE;
            minionY = (int)(Math.random() * Demo3.HEIGHT/SIZE) * SIZE;
            repaint();
        }
    }
}
