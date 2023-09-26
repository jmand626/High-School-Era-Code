/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graphics;

/**
 *
 * @author joban
 */
public abstract class Maze implements IMaze{
    private ICell[][] maze;
    private int width;
    private int height;
    
    public Maze(){
        this(5, 5);
    }
    public Maze(int rows, int cols){
        maze = new ICell[rows][cols];
        for(int row = 0; row < maze.length; row++){
            for(int col = 0; col < maze[row].length; col++){
                maze[row][col] = new Cell();
            }
        }
        for(int row = 0; row < maze.length; row++){
            for(int col = 0; col < maze[row].length; col++){
                ICell[] cells = new ICell[4];
                if(row > 0){
                    cells[0] = maze[row-1][col];
                }if(col < maze[row].length-1){
                    cells[1] = maze[row][col+1];
                }if(row < maze.length-1){
                    cells[2] = maze[row+1][col];
                }if(col > 0){
                    cells[3] = maze[row][col-1];
                }
                maze[row][col].setAdj(cells);
            }
        }
        generateMaze();
    }
    //all code methods from IMaze go here
    //Returns the maze as an Array of Cells
    public ICell[][] getMaze(){
        return maze;
    }
    //Returns a specific cell in the maze
    public ICell getCell(int row, int col){
        return maze[row][col];
    }
    public ICell getCell(int[] coords){
        return getCell(coords[0], coords[1]);
    }
    //Creates a link between two cells in the maze| Must be two adjacent cells
    public void createLink(ICell from, ICell to) throws IllegalArgumentException{
        ICell[] fromAdj = from.getAdj();
        for(int i = 0; i < fromAdj.length; i++){
            if(fromAdj[i] == to){
                from.setOpen(intToDir(i));
                to.setOpen(intToDir((i+2)%4));
            }
        }
    }
    //Returns all cells adjacent (intention is NESW)
    public ICell[] getAdjacent(ICell cell){
        ICell[] adj = new ICell[4];
        if(getRow(cell)>0){
            adj[0] = maze[getRow(cell)-1][getCol(cell)];
        }
        if(getCol(cell)<maze[0].length-1){
            adj[1] = maze[getRow(cell)][getCol(cell)+1];
        }
        if(getCol(cell)<maze.length-1){
            adj[2] = maze[getRow(cell)+1][getCol(cell)];
        }
        if(getCol(cell)>0){
            adj[3] = maze[getRow(cell)][getCol(cell)-1];
        }
        return adj;
    }
    //Helper method for the generate maze to ensure all ICells are linked
    //NESW is what I used to keep everything organized
    public boolean allVisited(){
        for(int row = 0; row < maze.length; row++){
            for(int col = 0; col < maze[row].length; col++){
                if(!maze[row][col].getVisited()){
                    return false;
                }
            }
        }
        return true;
    }
    //returns a random ICell 
    public ICell getRandomCell(){
        int row = (int) (Math.random() * maze.length);
        int col = (int) (Math.random() * maze[row].length);
        return maze[row][col];
    }
    //returns coordinates of the cell passed in {row, col} format
    public int[] getCoords(ICell cell){
         for(int row = 0; row < maze.length; row++){
            for(int col = 0; col < maze[row].length; col++){
               if(cell == maze[row][col]){
                   return new int[] {row, col};
               }
            }
        }
        return null;
    }
    //returns the row of the passed cell
    public int getRow(ICell cell){
        return getCoords(cell)[0];
    }
    //returns the column of the passed cell
    public int getCol(ICell cell){
        return getCoords(cell)[1];
    }
    private Direction intToDir(int n){
        return n == 0? Direction.NORTH : n == 1 ? Direction.EAST : n == 2 ? Direction.SOUTH : Direction.WEST;
    }
    
    public String toString(){   
        String st = "+";
        for(int col = 0; col<maze[0].length; col++){
            st+= "---+";
        }
        st += "\n";
        for(int row = 0; row < maze.length; row++){
            
            //The bulk of the grid: the vertical pieces and spacing of the cells
            st += "|";
            for(int col = 0; col<maze[row].length; col++){
                //st += " ";
                st += "";
                
                //Without Dijkstra
                /*if(maze[row][col].getOpenArray()[1]){
                    st += "   ";
                }else{
                    st += "  |";
                }*/
                
                
                
                //For Dijkstra
                String temp = ((Cell) maze[row][col]).getDistance() + "";
                int remainder = 3 - temp.length();
                for(int i = 0; i < remainder; i++){
                    temp += " ";
                }                
                if(maze[row][col].getOpenArray()[1]){
                    st += temp + " ";
                }else{
                    st += temp + "|";
                }
                //End of the Dijkstra code
                
            }
            st += "\n";
            //End of the code designed for cells;
            
            for(int col = 0; col<maze[row].length; col++){//Horizontal pieces of the cell
                st += "+";
                if(maze[row][col].getOpenArray()[2]){
                    st += "   ";
                }else{
                    st += "---";
                }
            }
            st += "+";
            
            st += "\n";
        }
        return st;
    }
    
    //All Children of Maze must implement the generateMaze() method.      
    public abstract void generateMaze();
    
}