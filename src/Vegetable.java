import java.util.Formatter;
import java.util.Scanner;

/**
 * public class vegetable is a food item
 */
public class Vegetable extends FoodItem {

    private String farmName;

    public Vegetable(){
        farmName= "Peperigde farms";
    }

    /**
     *builds the string calls the super to string because it needs the other information from it's parent class.
     * @return String
     */

    public String toString() {
        return super.toString()+" Farm supplier: "+farmName+ " qty: "+super.getQuantity();
    }
    /**
     *this Method adds the item, but it calls the super addItem method because it's parent class contains all the data members that makes up a fooditem
     * each extension of food item contains it's own Unique Data member.
     * @param scan
     * @return true
     */
    public boolean addItem(Scanner scan, boolean fromFile) {

        if(fromFile){
            super.addItem(scan,true);
            //System.out.println("we are here" );
            farmName = scan.nextLine();
            return true;
        }


        super.addItem(scan,false);
        System.out.println("Enter the name of the farm supplier:");
        farmName = scan.nextLine();

        return true;
    }
    /**
     * outputs the formatted strings to append to a text file. makes a call to super to obtain the parent class data
     * @param writer
     */
    public void outputItem(Formatter writer){
    writer.format("v\n");
    super.outputItem(writer);
    writer.format("%s\n",farmName);
    writer.flush();
    }

    /**
     *  Comparator method that returns the super Compareto methods.
     * @param foodItem
     * @return
     */
    @Override
    public int compareTo(FoodItem foodItem) {

        return super.compareTo(foodItem);
    }
}
