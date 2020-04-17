/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ethan
 */
public class Main {
//tested around 7:50 pm on April 16, 2020
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        toDoEntry one = new toDoEntry("meditate", "default", 4, 20, 2020, 4, 20, 1);   //April 20, 2020 at 4:20 am
        System.out.println(one.toString());
        one.update();
        System.out.println("\n" + one.toString());
        one.setTask("exercise");
        System.out.println("\n" + one.toString());
        one.setCategory("getting fit");
        System.out.println("\n" + one.toString());
        one.setDueDate(4, 15, 2020, 4, 20); //April 15
        System.out.println("\n" + one.toString());
        one.setDueDate(4, 17, 2020, 4, 20); //April 17 (less than 24 hr)
        System.out.println("\n" + one.toString());
        one.setDueDate(4, 18, 2020, 4, 20); //April 17 (24-48 hr)
        System.out.println("\n" + one.toString());
        one.setEntryDate(4, 15, 2020, 4, 20);
        System.out.println("\n" + one.toString());
        one.setDueDate(4, 17, 2020, 4, 20);
        one.setEntryDate(4, 14, 2020, 4, 20);
        System.out.println("\n" + one.toString());
    }
    
     
}
