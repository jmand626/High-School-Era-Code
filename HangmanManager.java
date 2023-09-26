/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evilhangman;

/**
 *
 * @author Joban Mand
 * Advanced Computer Science P. 3
 * 12/14/22
 * EvilHangman
 */

import java.util.*;
import java.io.*;

public class HangmanManager {
    private Set<String> words;
    //set of all words being considered
    private int length;
    //desired length
    private int max;
    //maximum amount of guesses
    private int remainder;
    //the amount of guesses left
    private Set<Character> guessedLetters;
    //the letters which have been guessed
    private String mostCommonPattern; 
    //the mostCommonPattern currecntly being considered
    public HangmanManager(Collection<String> dictionary, int length, int max) throws IllegalArgumentException{
        if(length < 1 || max < 0 ) throw new IllegalArgumentException();
        words = new TreeSet<String>();
        for (String word : dictionary) {
          if (word.length() == length) {
              words.add(word);
          } 
        }
        //moving every word from collection dictionary to set words, deleting any duplicates
        this.length = length;
        this.max = max;
        this.remainder = max;
        guessedLetters = new TreeSet<Character>();
        mostCommonPattern = "-";
        //no space before this dash. We also default mostCommonPattern to "- - - -" to make the record method work
        for(int i = 1; i < length; i++){
            mostCommonPattern += " -";
            //space before each of these
        }        
        
    }
    public Set<String> words(){//getter
        return words;
    }
    public void mostCommonPatternModifier(String s){//setter
        mostCommonPattern = s;
    }
    public int guessesLeft(){//getter
        return remainder;
    }
    public Set<Character> guesses(){//getter
        return guessedLetters;
    }
    public String pattern() throws IllegalStateException{//getter
        if(words.isEmpty()) throw new IllegalStateException();
        return mostCommonPattern;   
    }
    public int record(char guess) throws IllegalStateException, IllegalArgumentException{//the bulk method
        //However, this method has been broken apart several times
        if(remainder < 1 || words.isEmpty()) {
            throw new IllegalStateException();
        }else if( (guesses()).contains(guess)){
            throw new IllegalArgumentException();
        }//above are illegal cases
        Map<String, List<String>> patterns = new TreeMap<>();//patterns stored to be used later to find the most
        //common one. String is the pattern. List<String> are the words connected to it.
        for(String s : words()){
            String change = s;
            //we need to protect the orginial word copy
            change = change.replaceAll(".(?!$)", "$0 ");
            //regular expression code to add spaces in front of all characters but first and last
            if(s.length() == length()){//check if we are on the right words
                for(int i = 0; i < change.length(); i++){//going through every character
                    if(change.charAt(i) != guess && change.charAt(i) != pattern().charAt(i)){
                        //if a character does not equal guess and it does not equal the character at that point
                        //in the current mostCommonPattern....
                        change = change.replace(change.charAt(i)+"", "-");
                        //....replace it with dash
                    }
                }
                sendToPatterns(patterns, change, s);
                //sending the multitude of possible patterns to another method
            }
        }
        return modifyAfterRecord(patterns, guess);
        //this will make sure everything stays up to date
    } 
    public int modifyAfterRecord(Map<String, List<String>> patterns, Character guess){//updating everything
        findMostCommonPattern(patterns, guess);
        //self explantory
        
        patternsSafetyCheck(patterns);
        //making sure patterns is not empty and fixing that issue if it is
        
        patternsTrim(patterns, guess);
        //removing words that do not match our mostCommonPattern
        
        guessedLetters.add(guess); //updating the letters that have been guessed
        int num  = countOccurences(pattern(), guess); //count the number of times the most recent guess
        //has appeared in the pattern
        if(num  == 0) remainder--;
        //if the guess never occurs, we want to remove a guess since the user got a wrong guess
        return num;
        //returned as dicated by sheet
    }
    public void findMostCommonPattern(Map<String, List<String>> patterns, Character guess){//self explantory
        int maximum = 1; //at the very least, a pattern must have one word with it
        Iterator<String> t = patterns.keySet().iterator(); //cant really use loops with sets sadge
        while(t.hasNext()){
            String key = t.next();
            if(patterns.get(key).size() > maximum){//if we a find a more common pattern, we assign that to... 
                //...mostCommonPattern
                mostCommonPatternModifier(key);
                maximum = patterns.get(key).size(); //new max
            }else if(patterns.get(key).size() == maximum && words().size() == 1){//special case
                //this was frustating, but if there is only word left, and that word is that attached to a pattern,
                //that pattern is the most common one.
                mostCommonPatternModifier(key);
            }else{
                t.remove();
                //otherwise, get rid of that method
            }
        }  
    }
    public int length(){//getter method
        return length;
    }
    public int countOccurences(String n, char guess){//counting number of guesses
        int occurences = 0;
        for(int i = 0; i < n.length(); i++){
            if(n.charAt(i) == (guess)){
                occurences++;
            }
        }
        //very simple culmative sum
        return occurences;
    }
    public void sendToPatterns(Map<String, List<String>> patterns, String change, String s){//actually deciding
        //where to send our patterns
        if(! (patterns.keySet()).contains(change) ){//if a specfic pattern has not been made yet...
            List<String> list = new ArrayList<>();
            list.add(s);
            //creating and adding to our list
            patterns.put(change, list);
            //make one!
        }else{//if a specfic pattern has already been made
            patterns.get(change).add(s);
            //add one to the list which is located in patterns at the key 'change'
        }
    }
    public void patternsSafetyCheck(Map<String, List<String>> patterns){//what happens if patterns happens to be null?
        Iterator<String> w = words().iterator();
        if(patterns.isEmpty()){
            while(w.hasNext()){
                String p = w.next();
                if(patterns.isEmpty()){
                    List<String> list = new ArrayList<>();
                    list.add(p);
                    patterns.put(pattern(), list );
                    //similar to sendToPatterns method, but here we always use mostCommonPattern
                    //this will always one first and never again
                }else{
                    patterns.get(pattern()).add(p);
                    //similar to sendToPatterns method, but here we add to the mostCommonPattern list
                    //after the first time, this will be the only statement that runs
                }
            }
        }
    }   
    public void patternsTrim(Map<String, List<String>> patterns, char guess){//removing patterns that are not
        //the most common
        Iterator<String> t =  words().iterator();
        //iterating through ALL OF THE WORDS
        while(t.hasNext()){
            String p = t.next();
            //placeholder for each word
            if(patterns.get(pattern()) != null && !patterns.get(pattern()).contains(p) ){
                t.remove();
                //if mostCommonPattern exists and mostCommonPatterns does not point to the specfic word in patterns...
                //...it is deleted as it does not match the pattern
            }else{
                if(p.contains(guess+"") && !pattern().contains(guess+"") && words.size() > 1){
                    //another very frustating piece. if the word contains the guess letter AND mostCommonPattern...
                    //..does not contain guess(since it will have some dashes) AND the size of words is greater than...
                    //..one, it will be deleted. If there are two words left such as "cool" and "good", and 
                    //mostCommonPattern is -oo-, and then a new guess of "c" is made, this will make sure "cool" is...
                    //..eliminated
                    t.remove();
                }
                
            }
            
        }
    } 
}
