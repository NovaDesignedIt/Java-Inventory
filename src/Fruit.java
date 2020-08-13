import java.util.Formatter;
import java.util.Scanner;

/**
 * public class fruit is a foodItem.
 */
public class Fruit extends FoodItem {

    private String orchardName;

    public Fruit(){

    }

    /**
     *builds the string calls the super to string because it needs the other information from it's parent class.
     * @return String
     */
    public String toString() {
        return super.toString()+" Orchard Supplier: "+ orchardName+ " qty: "+super.getQuantity();
    }
    /**
     *this Method adds the item, but it calls the super addItem method because it's parent class contains all the data members that makes up a fooditem
     * each extension of food item contains it's own Unique Data member.
     * @param scan
     * @return true
     */
    public boolean addItem(Scanner scan, boolean fromFile) {

//        if(fromFile){
//            super.addItem(scan,true);
//            //System.out.println("we are here" );
//            orchardName = scan.nextLine();
//            return true;
//        }

        super.addItem(scan,false);
        System.out.println("Enter name of Orchard Supplier");
        orchardName = scan.nextLine();

        return  true;
    }

    /**
     * outputs the formatted strings to append to a text file. makes a call to super to obtain the parent class data
     * @param writer
     */
    public void outputItem(Formatter writer){
        writer.format("f\n");
        super.outputItem(writer);
        writer.format("%s\n",orchardName);
        writer.flush();
    }
    /**
     *  Comparator method that returns the super Compareto methods.
     * @param foodItem
     * @return
     */
    @Override
    public int compareTo(FoodItem foodItem) {
        return  super.compareTo(foodItem);
    }
}
