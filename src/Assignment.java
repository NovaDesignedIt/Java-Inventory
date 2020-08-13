/**
 *
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Title: Assignment 1 - Inventory System.
 * * Course: CST8234 - Data Structures
 * * Term: Summer 2020
 * @author  Meech Lamirande Kabuasa
 * @version 1.0
 * @since   2020-06-21
 */
public class Assignment {

    /**
     *THe main method of the while program. handles the menu section.
     *
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        //TODO DECLARE OBJECT INVENTORY


       // System.setIn(new FileInputStream("Test.txt"));


        Inventory inventory = new Inventory();
        Scanner input = new Scanner(System.in);
        int choice=0;


        while(choice != 9){

            //TODO METHOD MAIN
            System.out.print(menu());
            try {
               choice = Integer.parseInt(input.nextLine());
           }catch(InputMismatchException | NumberFormatException e) {
                //System.err.println("invalid Entry");
            }

           switch (choice) {
               case 1:
                   inventory.addItem(input, false);
                   break;
               case 2:
                   System.out.println(inventory.toString());
                   break;
               case 3:
                   inventory.updateQuantity(input,true);
                   break;
               case 4:
                   inventory.updateQuantity(input,false);
                   break;
               case 5:
                   int index = inventory.searchForItem(input);
                   if(index==-1){
                       System.err.println("Item not found.");
                   }else {
                       System.out.print("Item at index>> [ "+index+" ]\n");
                   }
                   break;
               case 6:
                   System.out.println("....");
                   inventory.removeExpiredItems();
                   break;
               case 7:
                   System.out.println("option 7:");
                   inventory.displayItemExpiryDates(input);
                 // inventory.readFromFile(input);
                   break;
               case 8:
                   System.out.println(inventory.setDate());
                   break;
               case 9:
                   System.out.println(" * * G O O D B Y E * * ");
                   break;
               default:
                   System.err.println("Invalid Input");
                   break;
           }

       }

    }


    private static String menu(){
        return "\nPlease select one the following option\n" +
                "1: Add Item to Inventory\n" +
                "2: Display Current Inventory\n" +
                "3: Buy Item(s)\n" +
                "4: Sell Items\n" +
                "5: search For Item\n" +
                "6: Remove Expired Items\n"+
                "7: Print Expiry Date\n"+
                "8: Set Today's Date.\n"+
                ">";
    }


}

