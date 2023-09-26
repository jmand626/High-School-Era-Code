/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graphics;

/**
 *
 * @author joban
 */
public class Dijkstra {
    public static void dijkstra(IMaze maze){
        for(int row  = 0; row < maze.getMaze().length; row++){
            for(int col = 0; col < maze.getMaze()[0].length; col++){
                ((Cell)maze.getMaze()[row][col]).resetVisited();
            }
        }
        dijkstra(maze, maze.getMaze()[0][0]);
    }
    public static void dijkstra(IMaze maze, ICell start){
        ((Cell) start).setDistance(0);
        start.setVisited();
        ICell[] adj = start.getAdj();
        for(int i = 0; i < 4; i++){
            dijkstra(adj[i], 0, start.getOpenArray()[i]);
        }
    }
    public static void dijkstra(ICell current, int level, boolean open){
        //Recursive solution to finish here
        
        if( !(current == null || !open || current.getVisited() || ((Cell)current).getDistance() > 0) ){
            ICell[] adj = current.getAdj();
            boolean[] openArray = current.getOpenArray();
            ((Cell)current).setDistance(level + 1);
            for(int i = 0; i < 4; i++){
                dijkstra(adj[i], level + 1, openArray[i]);
            }
        }
        
        
        
        /*if(current != null){
            current.setVisited();
            ICell[] adj = current.getAdj();
            boolean[] openArray = current.getOpenArray();
            
            if( (adj[0] == null || !openArray[0] || adj[0].getVisited()) && (adj[1] == null ||
            !openArray[1] || adj[1].getVisited()) && (adj[2] == null ||
            !openArray[2] || adj[2].getVisited()) 
            && (adj[3] == null || !openArray[3] || adj[3].getVisited()) ){
            
                ((Cell) current).setDistance(level);
                
            }else{
                ((Cell) current).setDistance(level);
                for(int i = 0; i < 4; i++){ 
                    
                    if( adj[i] != null && openArray[i] && !adj[i].getVisited()  ){
                        dijkstra(adj[i], level++, current.getOpenArray()[i]);
                    }
                    
                }
            }
        }*/
        
        
        
        
        //Base case
        //if()
        
        
        
        /*PseudoCode
        
        //Base case
        if(all directions are either closed or visited){
            setDistance(int level);
            getDistance(int level);
        }
        
        //Recursive case
        else{
            increment distance, get adj cells, recursive solution for each path
        }
        
        */
    }
}
