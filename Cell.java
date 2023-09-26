/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graphics;

/**
 *
 * @author joban
 */
public class Cell implements ICell {
    private boolean[] open;
    private boolean visted;
    private ICell[] adj;
    
    public Cell(){
        visted = false;
        open = new boolean[4];
        distance_from_start = -1;
    }
    
    //Letting the generated know if a cell had been visited or not
    public void setVisited(){
        visted = true;
    }
    public void resetVisited(){
        visted = false;
    }
    public boolean getVisited(){
        return visted;
    }
    //changes a direction from a barrier (default) to a non barrier
    public void setOpen(Direction d){
        open[convDir(d)] = true;
    }
    //checking if a direction is a barrier or not
    public boolean canMove(Direction d){
        return open[convDir(d)];
    }
    //Never seems to work
    
    //get an array of booleans indicating if the ordinal directions are open
    //NESW is what is intended
    public boolean[] getOpenArray(){
        return open;
    }
    //Sets the adjacent cells.  
    //NESW is what is intended
    public void setAdj(ICell[] adj){
        this.adj = adj;
    }
    public ICell[] getAdj(){
        return adj;
    } 
    public int convDir(Direction d){
        return d == Direction.NORTH ? 0 : d ==  Direction.EAST ? 1 : d == Direction.SOUTH ? 2 : d == Direction.WEST ? 3 : -1;

    }
    
    public Direction numToDirection(int num){
        if(num == 0){
            return Direction.NORTH;
        }else if(num == 1){
            return Direction.EAST;
        }else if(num == 2){
            return Direction.SOUTH;
        }else{
            return Direction.WEST;
        }
    }
    
    private int distance_from_start;
    public void setDistance(int d){
        distance_from_start = d;
    }
    public int getDistance(){
        return distance_from_start;
    }
}
