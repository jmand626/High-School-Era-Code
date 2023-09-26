package com.mycompany.towersofhanoi;


//Mr. Binz
//Peg Class for the Tower of Hanoi project
//last modified 12/12/2022
import java.util.Stack;



 
//The Peg class will hold all the Disks in an Stack

public class Peg {
    public Stack<Disk> stack;
    private int height;
    private int n;
    
    //Constructor - Creates a Peg that can hold Disks
    //establishes height and peg number
    public Peg(int h, int n){
        stack = new Stack<Disk>();
        height = h;
        this.n = n;
    }
    //adds a disk to the peg, returns false if unsuccessful
    public boolean push(Disk d){
        //checks if the stack is empty
        if(!stack.isEmpty()){
            //if the stack is not empty, gets the top disk to compare
            Disk disk = stack.peek();
            if(d.compareTo(disk)>0){
                //if the top disk is bigger than what is being pushed on, success
                stack.push(d);
                return true;
            }
            //top disk is smaller than what is trying to be pushed on
            return false;
        }
        stack.push(d);
        return true;
    }
    //remove a disk from the stack
    public Disk pop(){
        if(stack.isEmpty()) return null;
        return stack.pop();
    }
    public int size(){
        return stack.size();
    }

    //toString for printing
    public String toString(){
        String toReturn = "";
        Stack<Disk> temp = new Stack<>();
        //top
        toReturn += addBlank();
        
        //blank rows
        for(int i = 0; i<height -stack.size(); i++){
            toReturn += addBlank();
        }
        //disks
        while(!stack.isEmpty()){
            
            Disk d = stack.pop();
            toReturn += addSpaces(height - d.size());
            toReturn += d.toString();
            toReturn += addSpaces(height - d.size() );
            toReturn += "\n";
            temp.push(d);          
            
        }
        //reset stack
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
        toReturn+= base();
        return toReturn;
    }
    public String base(){
        String toReturn = "";
        for(int i = 0; i<height+1; i++){
            toReturn += "#";
        }
        toReturn += n;
        for(int i = 0; i<height; i++){
            toReturn += "#";
        }
        return toReturn + "\n";
    }
    
    public String addSpaces(int sp){
        String toReturn = "";
        for(int i = 0; i<sp; i++){
            toReturn += " ";
        }
        return toReturn;
    }
    
    public String addBlank(){
        String toReturn = "";
        toReturn += addSpaces(height);
        toReturn += "||";
        toReturn += addSpaces(height) + "\n";
        return toReturn;
    }

}
