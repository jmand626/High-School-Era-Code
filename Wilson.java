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
public class Wilson extends Maze {
    public Wilson(){
        super();
    }
    
    public Wilson(int rows, int cols){
        super(rows, cols);
    }
    
    public void generateMaze(){
        ICell[][] maze = getMaze();
        ICell first = getRandomCell();
        Random r = new Random();
        first.setVisited();
        int remainder = maze.length * maze[0].length - 1;
        while(remainder > 0){
            first = getRandomCell();
            Stack<ICell> road = new Stack<>();
            ICell temp = null;
            while(temp == null){
                int dir = r.nextInt(4);
                temp = first.getAdj()[dir];                
            }
            while(!temp.getVisited()){
                if(road.contains(temp)){
                    while(road.peek() != temp){
                        road.pop();
                    }
                }else{
                    road.push(temp);
                }
                ICell end = temp;
                temp = null;
                while(temp == null){
                    int dir = r.nextInt(4);
                    temp = end.getAdj()[dir];
                }
            }
            while(!road.isEmpty()){
                ICell temp2 = road.pop();
                temp2.setVisited();
                remainder--;
                createLink(temp, temp2);
                temp = temp2;
            }
        }
        
        /*ICell[][] maze = getMaze();
        ICell temp = getRandomCell();
        temp.setVisited();
        int remainder = maze.length * maze[0].length - 1;
        while(remainder > 0){
            List<Direction> list =  (List<Direction>)walk(maze, temp);
            
            for(Direction d : list){
                int a = ((Cell)temp).convDir(d);
                ICell[] adj = temp.getAdj();
                if(adj[a] != null){
                    createLink(maze[getRow(temp)][getCol(temp)], maze[getRow(adj[a])][getCol(adj[a])]);
                    temp = adj[a];
                    temp.setVisited();
                    remainder--;
                }
            }
            
        }*/
        
        
        /*First Walk
        ICell rand1 = getRandomCell();
        ICell rand2 = getRandomCell();
        while(! (rand1 == rand2) ){
            
        }*/
        
    }
    /*public List<Direction> walk(ICell[][] maze, ICell temp){
        while(true){
            
            int tempX = getRow(temp);
            int tempY = getCol(temp);
            //if(!temp.getVisited()){
                
                
                List<Direction> list = new ArrayList<>();
                
                boolean transversing = true;
                
                while(transversing){
                    transversing = false;
                    ICell[] adj = temp.getAdj();
                    
                    for(int i = 0; i < 4; i++){
                        
                        if(adj[i] != null){
                            
                            
                            int newX = getRow(adj[i]);
                            int newY = getCol(adj[i]);
                            if(newX >= 0 && newY >= 0 && newY < maze.length && newX < maze[newY].length){
                                list.add(((Cell)temp).numToDirection(i));
                                if(maze[newY][newX].getVisited()){
                                    break;
                                }else{
                                    tempX = newX;
                                    tempY = newY;
                                    transversing = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                return list;
            //}
        }        
    }*/
}
