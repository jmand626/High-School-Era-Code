//Mr. Binz
//Disk Class for the Tower of Hanoi project
//last modified 12/12/2022 
package com.mycompany.towersofhanoi;

 
//The disk class allows for comparison to other disks and has the toString for printing

public class Disk implements Comparable<Disk>{
    //Field for how big the Disk is
    private int size;
    
    //Constructor for storing how big
    public Disk(int size){
        this.size = size;
    }
    //accessor
    public int size(){
        return size;
    }
    //comparing two disks sizes
    public int compareTo(Disk disk) {
        return disk.size-size;
    }
    //toString for printing
    public String toString(){
        //1 = |==|
        //2 = |====|
        //3 = |======|
        //4 = |========|
        String toReturn = "|";
        for(int i = 0; i<size*2; i++){
            toReturn += "=";
        }
        return toReturn + "|";
    }
    
}
