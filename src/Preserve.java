import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * public class pereserve is a foodItem
 */
public class Preserve extends FoodItem {

    private int jarSize;

    public Preserve(){
        jarSize=0;
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

            jarSize = Integer.parseInt(scan.nextLine());

            return true;
        }


        super.addItem(scan,false);
        do {
            try {
                System.out.println("Please enter the Jar size:");
                jarSize  = Integer.parseInt(scan.nextLine());
                if (jarSize  < 0){
                    System.err.println("Must be Positive");
                }
            } catch (NumberFormatException | InputMismatchException e) {
                jarSize  = -1;
                System.err.println("Must enter Valid");
            }
        }while(jarSize  < 0);

        return true;
    }

    /**
     *builds the string calls the super to string because it needs the other information from it's parent class.
     * @return String
     */
    public String toString() {
      return super.toString()+"Jar Size: "+ jarSize+ " qty: "+super.getQuantity();


    }

    /**
     * outputs the formatted strings to append to a text file. makes a call to super to obtain the parent class data
     * @param writer
     */
    public void outputItem(Formatter writer){
        writer.format("p\n");
        super.outputItem(writer);
        writer.format("%d\n",jarSize);
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
