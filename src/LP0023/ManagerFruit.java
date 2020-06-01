/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LP0023;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class ManagerFruit {
    static void creatFruit(ArrayList<Fruit> lf){
        while (true){
            System.out.println("Enter fruit id: ");
            String fruitId = CheckInput.checkInputString();
            if(!CheckInput.checkIdOut(lf, fruitId)){
                System.err.println("Id exit.");
                return;
            }
            System.out.println("Enter fruit name: ");
            String fruitName = CheckInput.checkInputString();
            System.out.println("Enter price: ");
            double price = CheckInput.checkInputDouble();
            System.out.println("Enter quatity: ");
            int quatity = CheckInput.checkInputInt();
            System.out.println("Enter origin: ");
            String origin = CheckInput.checkInputString();
            lf.add(new Fruit(fruitId, fruitName, price, quatity, origin));
            if(!CheckInput.checkYN()){
                return;
            }
        }
    }
}