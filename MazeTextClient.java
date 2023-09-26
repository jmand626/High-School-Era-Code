/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graphics;

/**
 *
 * @author joban
 */
public class MazeTextClient {
    public static void main(String[] args){//Draws maze with text -> Code to draw from is in Maze
       //Text Binary Tree
       /*IMaze m = new BinaryTree();
       System.out.println(m);
       m = new BinaryTree(5, 8);
       System.out.println(m);*/
       
       //Text Sidewinder
       /*IMaze m = new Sidewinder();
       System.out.println(m);
       m = new Sidewinder(5, 8);
       System.out.println(m);*/
       
       //Text AldousBroder
       /*IMaze m = new AldousBroder();
       Dijkstra.dijkstra(m);
       System.out.println(m);
       m = new AldousBroder(5, 8);
       Dijkstra.dijkstra(m);
       System.out.println(m);*/
       
       //Text Wilson
       IMaze m = new Wilson();
       Dijkstra.dijkstra(m);
       System.out.println(m);
       m = new Wilson(5, 8);
       Dijkstra.dijkstra(m);
       System.out.println(m);
    }
}
