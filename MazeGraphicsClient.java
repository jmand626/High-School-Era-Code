/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author joban
 */
public class MazeGraphicsClient {
    
    public static final int ROWS = 30;
    public static final int COLS = 40;
    public static final int SIZE = 20;
    
    public static void main(String[] args){//Draws maze with graphics -> Code to draw from is in MazePanel
        //Graphics Binary Tree
        /*JFrame frame = new JFrame("Maze");
        JPanel p = new MazePanel(new BinaryTree(ROWS, COLS), SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(p);
        frame.pack();
        frame.setVisible(true);*/
        
        //Graphics Sidewinder
        /*JFrame frame = new JFrame("Maze");
        JPanel p = new MazePanel(new Sidewinder(ROWS, COLS), SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(p);
        frame.pack();
        frame.setVisible(true);*/
        
        //Graphics Aldous Broder
        /*JFrame frame = new JFrame("Maze");
        JPanel p = new MazePanel(new AldousBroder(ROWS, COLS), SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(p);
        frame.pack();
        frame.setVisible(true);*/
        
        //Graphics Wilson
        JFrame frame = new JFrame("Maze");
        JPanel p = new MazePanel(new Wilson(ROWS, COLS), SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(p);
        frame.pack();
        frame.setVisible(true);
    }
}
