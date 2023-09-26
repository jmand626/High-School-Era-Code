/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graphics;
import java.util.*;
/**
 *
 * @author joban
 */
public class Sidewinder extends Maze {
    public Sidewinder(){
        super();
    }
    public Sidewinder(int rows, int cols){
        super(rows, cols);
    }
    
    public void generateMaze(){
        //to do
        ICell[][] maze = getMaze();
        Random r = new Random();
        List<ICell> list = new ArrayList<>();
        int a = 0;
        ICell temp = new Cell();
        for(int row = 0; row < maze.length - 1; row++){
            list = new ArrayList<>();
            list.add(maze[row][0]);
            for(int col = 1; col < maze[0].length; col++){
                if(Math.random() < .5){
                    //EAST
                    createLink(maze[row][col-1], maze[row][col]);
                    list.add(maze[row][col]);
                }else{
                    //SOUTH
                    a = r.nextInt(list.size());
                    temp = list.get(a);
                    createLink(maze[getRow(temp)][getCol(temp)], maze[getRow(temp)+1][getCol(temp)]);
                    list.clear();
                    list.add(maze[row][col]);
                }
            }
            a = r.nextInt(list.size());
            temp = list.get(a);
            createLink(maze[getRow(temp)][getCol(temp)], maze[getRow(temp)+1][getCol(temp)]);
        }
        for(int i = 0; i < maze[0].length - 1; i++){
            createLink(maze[maze.length-1][i], maze[maze.length-1][i+1]);
        }
        
        
        
        
        /*List<ICell> list = new ArrayList<>();
        ICell[][] maze = getMaze();
        Random r = new Random();
        int a = 0;
        ICell temp = new Cell();
        for(int row = 0; row < maze.length; row++){
            for(int col = 0; col < maze[0].length; col++){
                if(Math.random() < .5 && col + 1 < maze[row].length){
                   //EAST 
                   createLink(maze[row][col], maze[row][col+1]);
                   list.add(maze[row][col]);
                }else if(row + 1 < maze.length){
                   //SOUTH
                   if(list.size() >= 1){
                      a = r.nextInt(list.size());
                      temp = list.get(a);
                      createLink(maze[getRow(temp)][getCol(temp)], maze[getRow(temp)+1][getCol(temp)]);
                      list.clear();
                   }else{
                      createLink(maze[row][col], maze[row+1][col]);
                   }
                }
            }
            //far right col
            if(row + 1 < maze.length){
                createLink(maze[row][maze[0].length-1], maze[row+1][maze[row].length-1]);
                if(list.size() >= 1){
                    a = r.nextInt(list.size());
                    temp = list.get(a);
                    createLink(maze[getRow(temp)][getCol(temp)], maze[getRow(temp)+1][getCol(temp)]);
                    list.clear();
                }else{
                    createLink(maze[row][maze[0].length-1], maze[row+1][maze[row].length-1]);
                }
            }
        }
        //bottom row
        int row = maze.length-1;
        for(int col = 0; col < maze[0].length-1; col++){
            createLink(maze[row][col], maze[row][col+1]);
        }*/
    }
    
        
}
