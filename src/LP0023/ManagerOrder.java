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
public class ManagerOrder {
    static void viewOrder(Hashtable<String, ArrayList<Order>> ot){
        for(String name: ot.keySet()){
            System.out.println("Cutomer: " + name);
            ArrayList<Order> ol = ot.get(name);
            displayOrderList(ol);
        }
    }

    static void displayOrderList(ArrayList<Order> ol) {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for(Order order: ol){
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", order.getFruitName(), order.getQuantity(), order.getPrice(), order.getPrice() * order.getQuantity());
            total += order.getPrice() * order.getQuantity();
        }
        System.out.println("Total: " + total); 
    }
    
   static void updateOrder(ArrayList<Order> ol, String id, int quantity){
       for(Order order : ol){
           if(order.getFruitId().equalsIgnoreCase(id)){
               order.setQuantity(order.getQuantity() + quantity);
               return;
           }
       }
   }
   
   static void shopping(ArrayList<Fruit> lf, Hashtable<String, ArrayList<Order>> ht) {
        //check list empty user can't buy
        if (lf.isEmpty()) {
            System.err.println("No have item.");
            return;
        }
        //loop until user don't want to buy continue
        ArrayList<Order> ol = new ArrayList<>();
        while (true) {
            displayFruit(lf);
            System.out.print("Enter item: ");
            int item = CheckInput.checkLimit(1, lf.size());
            Fruit fruit = getFruitByItem(lf, item);
            System.out.print("Enter quantity: ");
            int quantity = CheckInput.checkLimit(1, fruit.getQuantity());
            fruit.setQuantity(fruit.getQuantity() - quantity);
            //check item exist or not
            if (!CheckInput.checkItemOut(ol, fruit.getFruitId())) {
                updateOrder(ol, fruit.getFruitId(), quantity);
            } else {
                ol.add(new Order(fruit.getFruitId(), fruit.getFruitName(),
                        quantity, fruit.getPrice()));
            }

            if (!CheckInput.checkYN()) {
                break;
            }
        }
        displayOrderList(ol);
        System.out.print("Enter name: ");
        String name = CheckInput.checkInputString();
        ht.put(name, ol);
        System.err.println("Add successfull");
    }
   
   static void displayFruit(ArrayList<Fruit> lf){
        int count = 1;
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit Name", "Origin", "Price");
        for(Fruit fruit : lf){
            if(fruit.getQuantity() != 0){
                System.out.printf("%-10d%-20s%-20s%-15.0f$\n", count++, fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            }
        }
    }
    
    static Fruit getFruitByItem(ArrayList<Fruit> lf, int item) {
        int count = 1;
        for (Fruit fruit : lf) {
            //check shop have item or not 
            if (fruit.getQuantity() != 0) {
                count++;
            }
            if (count - 1 == item) {
                return fruit;
            }
        }
        return null;
    }
}