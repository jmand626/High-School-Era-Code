/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.towersofhanoi;

import java.util.*;

/**
 *
 * @author joban
 */
public class Main {
    static final int peg1 = 1;
    static final int peg2 = 2;
    static final int peg3 = 3;
    //Three static variables for each of the three pegs

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        //Console for input
        printIntro();
        //Print the intro information
        boolean play = true;
        //Boolean variable to keep the loop running
        System.out.print("How many disks to start with? ");
        int num = console.nextInt();
        console.nextLine();
        System.out.println();
        Board b = new Board(num);
        
       
        //input loop
        while(play != false){
            //Board object for the game
            
            
            System.out.println(b);
            System.out.println();
            System.out.print("Enter command: ");
            String line = console.nextLine();
            //Line for the next command
            
           
            String[] splitCheck = line.split("\\s+");
            //A statement to make sure that the string is split into its pieces
            if(line.charAt(0) == 's'){//when the command is solve
                if (b.win()) {//If the game was already run
                    System.out.println("Game already solved!");
                    return;
                }
                while(!b.win()){//When the game wins, the solve method should run
                    runSolve(b, num);
                }
            }else if(line.charAt(0) == 'q'){//quit
                break;
                //break the loop
            }else if (splitCheck.length == 3 && splitCheck[1].equals("to")) {
                //For movement commands
                int num1 = Integer.parseInt(splitCheck[0]);
                int num2 = Integer.parseInt(splitCheck[2]);
                if(!b.move(num1-1, num2-1)){//If the move does not work we print this
                    //One weird this is that calling this to check if it works also actually runs the method
                    //It might be obvious now but it wasnt later. Additonally, the fact that an
                    //array was used means there must be a -1 in the method call, something that was very hard to notice
                    System.out.println("You cannot move to a peg with a smaller disk underneath");
                }
            }else{
                System.out.println("Invalid Input. Please try again!");
            }
            //End menu where the user is prompted 
            b = endMenu(b, console, play);
        } 
    }
    
    public static void solve(Board b, int num, int start, int end, int helper){//Solve the puzzle with recursion
        if (num == 0) {//base case
            return;
        } else {
            solve(b, num - 1, start, helper, end);//Move from peg 1 to peg 2
            b.move(start, end);
            System.out.println(b);
            System.out.println();
            solve(b, num - 1, helper, end, start);//Move from peg 2 to peg 3
        }
    }
    
    public static void runSolve(Board b, int num){//Actually running solve and tracking the time
        int minMoves = (int)Math.pow(2, num) - 1;
        System.out.println("I will solve this in " + minMoves + " moves!");
        //the minimum amount of moves required to solve the problem
        long conversion = 1000000;
        //A long to double conversion factor.
        long time1 = System.nanoTime();
        solve(b, num, peg1-1, peg3-1, peg2-1);
        long time2 = System.nanoTime();
        //Taking the time before and after solve is called 
        //to see time elapsed
        
        long difference = (time2 - time1) / conversion;
        //Difference that is now being converted
        double change = difference / 1000.00;
        //Milliseconds to seconds
        System.out.println("It took me " + change + " seconds.");
    }

    public static Board endMenu(Board b, Scanner console, boolean play){//The menu at the end of the game
        if(b.win()){//If the game has won
            System.out.println(b);
            System.out.println("You have won!");
            System.out.println("Play again? (Y/N)");
            String s = console.nextLine();
            if((s).equals("N")){//Setting play to false ends the input loop
                play = false;
            }else if((s).equals("Y")){//Calls a new method that resets the game and the board
                System.out.print("How many disks to start with? ");
                int num = console.nextInt();
                console.nextLine();
                System.out.println();
                b = new Board(num);
                b.setNumDiscs(num);
                b.reset();
            }
        }
        return b;
    }


    
    public static void printIntro(){//printing all the introduction statements that explain the rules of the game
        System.out.println("Welcome to the Tower of Hanoi");
        System.out.println();
        System.out.println("This is a puzzle where you are taking all of the disks from");
        System.out.println("the first peg and moving them to the last peg.");
        System.out.println("The rules are: ");
        System.out.println("#1: Only one disk may be moved at a time");
        System.out.println("#2: Each move is taking the top disk from one stack and moving it to another stack or rod.");
        System.out.println("#3: No disk may be placed on top of a disk that is smaller than it");
        System.out.println();
        System.out.println("I accept commands:");
        System.out.println("	\"# to #\" - example - 1 to 2 - this would move the top disk from peg one to peg two");
        System.out.println("	solve (only currently works for the initial board");
        System.out.println("	quit");
        System.out.println(); 
    }
}