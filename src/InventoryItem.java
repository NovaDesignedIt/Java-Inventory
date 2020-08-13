import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * THIS IS A WRAPPER CLASS OF INVENTORY ITEM THE INVENTORYITEM CONTAINS AN EXPIRY DATE  OBJECTS AND A ITEM QUANTITY in STOCK VARAIBLE
 *
 *
 */
public class InventoryItem {
    private int ItemQuantityinStock;
    private FoodItem item;
    private ArrayList<Date> Expiry;
    /**
     * constructor for this InventoryItem
     * @param item
     */
    public InventoryItem(FoodItem item) {
        this.item = item;
        Expiry = new ArrayList<>();

    }
    /**
     * @param scan Scanner from assignement.java class
     * @return true if addItem is succefull
     */
    public boolean addItem(Scanner scan) {

        item.addItem(scan, false);
        //TODO CREATE A METHOD TO ADD A NEW DATE.
        ItemQuantityinStock = item.getQuantity();
        addExp(scan, false, 1);

        return true;
    }
    /***
     * getter method for the item code.
     * @return retreives the item code.
     */
    public int getItemCode() {
        return this.item.getItemCode();
    }
    /**
     * checks to see if the code is value.
     *
     * @param scan takes in a scanner from main class
     * @return true if code found.
     */
    public boolean inputCode(Scanner scan) {
        return scan.nextInt() == getItemCode();
    }
    /**
     * prints the expiry summary for the fooditems uses a SET to find the Unique
     * keys then uses a collections method called Frequency to count the repetitive elements in the array.
     */
    public void printExpirySum() {
        Set<Date> unique = new HashSet<>(Expiry);
        for (Date key : unique) {
            System.out.println(key + " :" + Collections.frequency(Expiry, key));
        }

    }
    /**
     * removes the expired items from the data structures
     *
     */
    public void RemoveExpiredItems(Date today) {
        //TODO REMOVE ALL THE EXPIRED ITEMS
        if (today != null) {
            Expiry.removeIf(exp -> exp.before(today));
        } else {
            System.err.println("the date isn't set, see option 8.");
        }
        ItemQuantityinStock = Expiry.size();
    }

    /**
     * @param amount the amount you wish to update
     * @return true if amount added false is else.
     */
    public boolean updateQuantity(int amount, Scanner scan) {
        if (amount < 0) {
            ItemQuantityinStock = item.updateItem(amount);

            int j;
            ArrayList<Date> temp;
            Date tempItem;
            Date key;
            temp = Expiry;
            for (int i =1; i < Expiry.size() ;i++){
                key = temp.get(i);
                j = i-1;

                while(j >= 0 && key.before(temp.get(j))){
                    tempItem = temp.get(j);
                    temp.set(j,temp.get(j+1));
                    temp.set(j+1,tempItem);
                    j--;
                }
            }

            for(int i=0; i< (amount*-1); i++){
                Expiry.remove(i);
            }


        } else {
            ItemQuantityinStock = item.updateItem(amount);
            addExp(scan, true, amount);
        }
        return true;
    }

    /**
     *This method takes a InventoryItem calls the class compareTo method and compares both items using the Comparator method in the Inventory class it also calls get item
     * @param itemcompared the item compared
     * @return
     */
    public int compare(InventoryItem itemcompared) {
        return this.item.compareTo(itemcompared.getItem());
    }

    /**
     *
     * @return the Quantity in stock!
     */
    public int getItemQuantityinStock() {
        return ItemQuantityinStock;
    }



    /**
     * @return returns the concatenated strings for output.
     */
    public String toString() {
        return this.item.toString();
    }

    private FoodItem getItem() {
        return item;
    }

    private void addExp(Scanner scan, boolean update, int amount) {
        int stock = ItemQuantityinStock;
        boolean kill = true;
        int ItemsAdded = 0;
        if (update) {
            ItemsAdded = amount;
        } else {
            ItemsAdded = stock;
        }
        while (kill) {
            System.out.println("Please enter a valid date format: yyyy-mm-dd ");
            String Today = scan.nextLine();
            String[] tokens = Today.split("-");
            ArrayList<Date> temp = new ArrayList<>(stock);
            if (tokens.length == 3) {
                int months = Integer.parseInt(tokens[1]);
                int days = Integer.parseInt(tokens[2]);
//                //TODO SO
                if (months < 13 && days < 32) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        Date expDate = formatter.parse(Today);
                        for (int i = 0; i < ItemsAdded; i++) {
                            temp.add(expDate);
                        }
                        Expiry.addAll(temp);
                        System.out.println("Size of the array ----> " + Expiry.size());
                        System.out.println("Item code: " + getItemCode() + ", Expiry date: " + expDate.toString());
                        kill = false;
                    } catch (ParseException e) {
                        System.err.println("date miss-formatted, please enter valid date format: ");
                    }
                } else {
                    System.err.println("please enter valid calendar dates.");
                }
            } else {
                System.err.println("this this format isn't accepted -> yyyy-mm-dd ");
            }
        }
    }
}
