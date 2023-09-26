/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.graphics;

/**
 *
 * @author joban
 */
public interface ICell {
    //Letting the generated know if a cell had been visited or not
    public void setVisited();
    public boolean getVisited();
    //changes a direction from a barrier (default) to a non barrier
    public void setOpen(Direction d);
    //checking if a direction is a barrier or not
    public boolean canMove(Direction d);
    //get an array of booleans indicating if the ordinal directions are open
    //NESW is what is intended
    public boolean[] getOpenArray();
    //Sets the adjacent cells.  
    //NESW is what is intended
    public void setAdj(ICell[] adj);
    public ICell[] getAdj();    
}
