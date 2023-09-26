/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adventofcode2022;
import java.util.*;
import java.io.*;
/**
 *
 * @author joban
 */
public class AoCDay1 {
    
    
    public static void main(String[] args)throws FileNotFoundException{
        Scanner input = new Scanner(new FileReader("AoCDay1Input.txt"));
        List<String> list = new ArrayList<>();
        while(input.hasNextLine()){
            String s = input.nextLine();
            list.add(s);
        }
        collectSum(list);
    }
    
    public static void collectSum(List<String> list){
        List<Integer> sums = new ArrayList<>();
        int total = 0;
        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i).equals("") && !list.get(i+1).equals("")){
                total = 0;
            }else if(!list.get(i).equals("") && list.get(i+1).equals("")){
                total += Integer.parseInt(list.get(i));
                sums.add(total);
            }else{
                total += (Integer.parseInt(list.get(i)));
            }
        }
        int max = sums.get(0);
        int temp = 0;
        for(int h = 1; h < sums.size(); h++){
            temp = sums.get(h);
            if(temp > max){
                max = temp;
            }
        }
        System.out.println(max);
        
        /*for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals("")){
                temp.add(list.get(i)); 
            }else{
                total = 0;
                int num = 0;
                for(int j = 0; j < temp.size(); j++){
                   num = Integer.parseInt(temp.get(j));
                   total += num;
                }
                sums.add(total);
            }
            temp.clear();
        }
        findSum(sums);*/
    }
    /*public static void findSum(List<Integer> sums){
        int a = sums.get(0);
        for(int h = 1; h < sums.size(); h++){
            if(sums.get(h) > a){
                a = sums.get(h);
            }
        }
        System.out.println(a);
    }*/
    
    
    
}
