package com.mycompany.towersofhanoi;

//Mr. Binz
//Board Class for the Tower of Hanoi project
//last modified 12/12/2022 
 
//The board class will hold all the Pegs in an array
//This class is hardcoded to hold only 3 pegs, as is the traditional Tower of Hanoi game


public class Board {
    //Fields
    //a collection of Pegs
    private Peg[] pegs;
    //Max Size is how many disks each peg can hold
    private int maxSize;
    
    //Constructors
    //Default - Default constructor will hold 3 disks on 3 pegs
    public Board(){
        //calls the detailed constructor
        this(3);       
    }
    
    //Detailed constructor
    public Board(int disks){
        pegs = new Peg[3];
        //creates each peg
        for(int i = 0; i<3; i++){
            pegs[i] = new Peg(disks, i+1);
        }
        //pushes all disks on the first peg
        //decreases size as they are pushed on
        for(int i = 0; i<disks; i++){
            pegs[0].push(new Disk(disks-i));
        }
        maxSize = disks;
    }
    public boolean win(){
        return pegs[2].size() == maxSize;
    }
    
    //This will take the top disk from the 'from' peg and move it 'to' the to peg
    public boolean move(int from, int to){
        Disk d = pegs[from].pop();
        if(d == null){
            return false;
        }
        boolean toReturn = pegs[to].push(d);
        if(!toReturn){
            pegs[from].push(d);
            
        }
        return toReturn;
    }
    
    //Returns the max size
    public int size(){
        return maxSize;
    }

    //toString for printing in main
    @Override
    public String toString(){
        String peg1 = pegs[0].toString();
        String peg2 = pegs[1].toString();
        String peg3 = pegs[2].toString();
        String toReturn = "";
        while(peg1.contains("\n")){
            toReturn += peg1.substring(0, peg1.indexOf("\n"));
            peg1 = peg1.substring(peg1.indexOf("\n")+1);
            if(!peg1.contains("\n")){
                toReturn += "#";
            } else{
                toReturn += " ";
            }
            toReturn += peg2.substring(0, peg2.indexOf("\n"));
            peg2 = peg2.substring(peg2.indexOf("\n")+1);
            if(!peg1.contains("\n")){
                toReturn += "#";
            } else{
                toReturn += " ";
            }
            toReturn += peg3.substring(0, peg3.indexOf("\n"));
            peg3 = peg3.substring(peg3.indexOf("\n")+1);
            toReturn += "\n";             
        }
        return toReturn;
    }
    
    public Peg[] getPegs(){
        return pegs;
    }
    
    public Peg getPeg(int index){
        return pegs[index];
    }
    
    public void reset() {
        for (int i = 0; i < pegs.length; i++) {
            pegs[i] = new Peg(maxSize, i+1);
        }
        for(int i = 0; i<maxSize; i++){
            pegs[0].push(new Disk(maxSize-i));
        }
    }
    public void setNumDiscs(int numDiscs) {
        this.maxSize = numDiscs;
        pegs = new Peg[3];
        for(int i = 0; i<3; i++){
            pegs[i] = new Peg(numDiscs, i+1);
        }
        for(int i = 0; i<maxSize; i++){
            pegs[0].push(new Disk(maxSize-i));
        }
    }

}
