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
public class AldousBroder extends Maze {
    public AldousBroder(){
        super();
    }
    public AldousBroder(int rows, int cols){
        super(rows, cols);
    }
    
    public void generateMaze(){
        ICell[][] maze = getMaze();
        ICell temp = getRandomCell();
        temp.setVisited();
        int numLeft = maze.length * maze[0].length - 1;
        Random r = new Random();
        int a = 0;  
        
        while(numLeft>0){
            a = r.nextInt(4);    
            if( a == 0 && getRow(temp) != 0 ){//North         
                if( !(maze[getRow(temp) - 1][getCol(temp)]).getVisited() ){
                   createLink(maze[getRow(temp)][getCol(temp)], maze[getRow(temp) - 1][getCol(temp)]);
                   numLeft--;                  
                   (maze[getRow(temp) - 1][getCol(temp)]).setVisited();
                }
                
                temp = (maze[getRow(temp) - 1][getCol(temp)]);
                
            }else if(a == 1 && getCol(temp) != maze[0].length - 1){//East
                if( !(maze[getRow(temp)][getCol(temp) + 1]).getVisited() ){
                   createLink(maze[getRow(temp)][getCol(temp)], maze[getRow(temp)][getCol(temp) + 1]);
                   numLeft--;                  
                   (maze[getRow(temp)][getCol(temp) + 1]).setVisited();
                }
                
                temp = (maze[getRow(temp)][getCol(temp) + 1]);
                
            }else if (a == 2 && getRow(temp) != maze.length - 1 ){//South
                if( !(maze[getRow(temp) + 1][getCol(temp)]).getVisited() ){
                   createLink(maze[getRow(temp)][getCol(temp)], maze[getRow(temp) + 1][getCol(temp)]);
                   numLeft--;                  
                   (maze[getRow(temp) + 1][getCol(temp)]).setVisited();
                }
                
                temp = (maze[getRow(temp) + 1][getCol(temp)]);
                
            }else if (a == 3 && getCol(temp) != 0){//West
                if( !(maze[getRow(temp)][getCol(temp) - 1]).getVisited() ){
                   createLink(maze[getRow(temp)][getCol(temp)], maze[getRow(temp)][getCol(temp) - 1]);
                   numLeft--;                  
                   (maze[getRow(temp)][getCol(temp) - 1]).setVisited();
                }
                
                temp = (maze[getRow(temp)][getCol(temp) - 1]);
                
            }
        }
    }
}
