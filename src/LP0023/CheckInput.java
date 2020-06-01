/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LP0023;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class CheckInput {
    private static final Scanner in = new Scanner(System.in);
    
    public static String checkInputString(){
        while(true){
            String result = in.nextLine().trim();
            if (result.isEmpty()){
                System.err.println("Not empty!!!");
                System.out.println("Enter again: ");
            } else{
                return result;
            }
        }
    }
    
    public static boolean checkIdOut(ArrayList<Fruit> lf, String id){
        for(Fruit fruit : lf){
            if(id.equalsIgnoreCase(fruit.getFruitId())){
                return false;
            }
        }
        return true;
    }
    
    public static double checkInputDouble(){
        while(true){
            try{
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch(NumberFormatException e){
                System.err.println("Must be input double!!!");
                System.out.println("Enter again: ");
            }
        }
    }
    
    public static int checkInputInt(){
        while(true){
            try{
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch(NumberFormatException e){
                System.err.println("Must be input integer!!!");
                System.out.println("Enter again: ");
            }
        }
    }
    
    public static boolean checkYN(){
        System.out.println("Do you want to continue(Y/N)? ");
        while(true){
            String result = checkInputString();
            if(result.equalsIgnoreCase("Y")){
                return true;
            }
            if(result.equalsIgnoreCase("N")){
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.println("Enter again: ");
        }
    }
    
    public static int checkLimit(int min, int max){
        while(true){
            try{
                int result = Integer.parseInt(in.nextLine().trim());
                if(result < min || result > max){
                    throw new NumberFormatException();
                }
                return result;
            } catch(NumberFormatException e){
                System.err.println("Please input number in range from " + min + " to " + max);
                System.out.println("Enter again:");
                
            }
        }
    }
    
    public static boolean checkItemOut(ArrayList<Order> ol, String id){
        for(Order order : ol){
            if(order.getFruitId().equalsIgnoreCase(id)){
            return false;
            }
        }
        return true;
    }
}