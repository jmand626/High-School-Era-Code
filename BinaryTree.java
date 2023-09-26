/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graphics;

/**
 *
 * @author joban
 */
public class BinaryTree extends Maze {
    public BinaryTree(){
        super();
    }
    public BinaryTree(int a, int b){
        super(a, b);
    }
    
    public void generateMaze(){
        ICell[][] maze = getMaze();
        for(int row = 0; row < maze.length; row++){
            for(int col = 0; col < maze[row].length; col++){
                if(Math.random() < .5 && col + 1 < maze[row].length){
                   //EAST 
                   createLink(maze[row][col], maze[row][col+1]);
                }else if(row + 1 < maze.length){
                   //SOUTH
                   createLink(maze[row][col], maze[row+1][col]);
                }
            }
            //far right col
            if(row + 1 < maze.length ){
                createLink(maze[row][maze[row].length-1], maze[row+1][maze[row].length-1]);
            }
    
        }
        //bottom row
        int row = maze.length-1;
        for(int col = 0; col < maze[0].length-1; col++){
            createLink(maze[row][col], maze[row][col+1]);
        }
    }
}
