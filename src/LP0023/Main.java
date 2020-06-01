/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LP0023;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author PC
 */
public class Main {
    static int menu(){
        System.out.println("1. Create Fruit.");
        System.out.println("2. View Orders.");
        System.out.println("3. Shopping(for buyer).");
        System.out.println("4. Exit.");
        System.out.println("Enter your choice: ");
        int choice = CheckInput.checkLimit(1,4);
        return choice;
    }
    
    public static void main(String[] args) {
        ArrayList<Fruit> lf = new ArrayList<>();
        Hashtable<String, ArrayList<Order>> ht = new Hashtable<>();
        while(true){
            int choice = menu();
            switch(choice){
                case 1:
                    ManagerFruit.creatFruit(lf);
                    break;
                case 2:
                    ManagerOrder.viewOrder(ht);
                    break;
                case 3:
                    ManagerOrder.shopping(lf, ht);
                    break;
                case 4:
                    return;
            }
        }
    }
}