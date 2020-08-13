import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**TODO  ---- < ASSIGNMENT 2 >
     * Fruit:
     * Updated: public boolean addItem(Scanner scanner, boolean fromFile)
     * Added: public void outputItem(Formatter writer)
  TODO
     * Vegetable:
     * Updated: public boolean addItem(Scanner scanner, boolean fromFile)
     * Added: public void outputItem(Formatter writer)
  TODO
     * Preserve:
     * Updated: public boolean addItem(Scanner scanner, boolean fromFile)
     * Added: public void outputItem(Formatter writer)
 *
 *  Food Item class is an abstract class that will be the parent class for the various food Item class,
 *  we'll use this class to build the food items and call the child class methods to get their data members
 *
 */
 abstract class FoodItem implements Comparable <FoodItem> {
//TODO COMPLETE THE FRAME TONIGHT
private int itemCode;
private String itemName;
private float itemPrice;
private int itemQuantity;
private float itemCost;


    public FoodItem()
    {
//TODO DEFAULT constructor FOOD ITEM CLASS
    }

    /**
     * this method just compiles the Strings data member.
     * @return String
     */
    public String toString()
        {
//TODO TOO STRING TO RETURN THE DATA MEMBERS
    return "Item: "+itemCode+" "+itemName+" price: $"+itemPrice
            +" cost: $"+itemCost;
        }

    /**
     * this update Item simply updates the Quantity in the inventory.
     * @param amount
     * @return true
     */
    public int updateItem(int amount)
    {
//TODO UPDATE THE ITEM
       itemQuantity += amount;
    return itemQuantity;
    }

/*
            TODO
                isEqual	 Method returns true if the itemCode of the object being acted on and the item object parameter are the same value
                inputCode	Reads a valid itemCode from the Scanner object and returns true/false if successful
                You're here*** **** *** **** ****
                you need to update the isEqual method to  and input code
*/

    /**
     * *so it takes a food item from Inventory and then will compare it's Item code if the item codes are identical than it returns true, otherwise it returns false.
     * @param item
     * @return true;
     */
 public boolean isEqual(InventoryItem item){
//TODO USE THIS METHOD TO SEE IF THE FOOD ITEM CODE MATCH
    return this.itemCode == item.getItemCode();

 }

    /**
     * comparator method used to compare the item codes when sorting them.
     * @param item
     * @return integer
     */
 public int compareTo(FoodItem item){
    if(this.itemCode<item.itemCode)
        return 1;
    else return -1;

 }




    /**
     *the Add Item method scans all the data members of the class,
     * @param scan
     * @return true
     */
 public boolean addItem(Scanner scan,boolean fromFile){


     if(fromFile){
//TODO THIS WILL SCAN FROM THE FILE ASSIGNE THE DATA MEMEBERS THE APPROPRIATE VALUES. THIS IS BEING CALLED FROM THE CHILD.
        // System.out.println("we are here" );
//  THESE MUST BE IN ORDER
         String s = scan.nextLine();
         int code;
         itemCode = Integer.parseInt(s);
         itemName = scan.nextLine();
         itemQuantity = scan.nextInt();
         itemCost = scan.nextFloat();
         itemPrice = scan.nextFloat();
         return true;
//         s = scan.nextLine();
//         tokens = s.split(" ");
//         itemQuantity = Integer.parseInt(tokens[tokens.length - 1]);

     }

          System.out.println("Please enter code for Item: ");
        boolean check = true;
while(check) {
    try {
        itemCode = Integer.parseInt(scan.nextLine());
        check=false;
    } catch (NumberFormatException | InputMismatchException e) {
        itemCode = 0;

        System.err.println("Enter enter Valid positive Integer");
    }
}

     //TODO GETTING THE NAME OF THE ITEM REQUIRES NO CHECK BECAUSE THE NAME CAN TECHNICALLY BE ANYTHING?

     System.out.println("Enter The Name of the Item");
     itemName = scan.nextLine();


     //DO I have to error check the name?

     //TODO SCANS THE ITEM QUANTITY
     do {
         try {
             System.out.println("Please enter Quantity of items");
             itemQuantity = Integer.parseInt(scan.nextLine());
             if (itemQuantity < 0){
                 System.err.println("Must be Positive");
             }
         } catch (NumberFormatException | InputMismatchException e) {
             itemQuantity = -1;
             System.err.println("Must enter Valid positive Integer");
         }
     }while(itemQuantity < 0);
     // TODO SCANS THE ITEM COST
     do {
         try {
             System.out.println("Please enter Item cost");
             itemCost = Float.parseFloat(scan.nextLine());
             if (itemCost < 0){
                 System.err.println("Must be Positive");
             }
         } catch (NumberFormatException | InputMismatchException e) {
             itemCost = -1;
             System.err.println("Entry Invalid");
         }
     }while(itemCost < 0);

     //TODO SCANS THE ITEM PRICE
     do {
         try {
             System.out.println("Please enter Item Price");
            itemPrice = Float.parseFloat(scan.nextLine());
             if ( itemPrice  < 0){
                 System.err.println("Must be Positive");
             }
         } catch (NumberFormatException | InputMismatchException e) {
             itemPrice  = -1;
             System.err.println("Entry Invalid");
         }
     }while( itemPrice  < 0);

     return true;
 }

    /**
     * get's the item Quantity.
     * @return
     */
 public int getQuantity(){
  return itemQuantity;
 }

    /**
     * gets the itemcode
     * @return
     */
 public int getItemCode(){
     return itemCode;
 }

    /**
     * this outputItems item format this get's called by the child method.
     * @param writer
     */
 public void outputItem(Formatter writer){
//writer.format("item Code: %d\nitem Name: %s\nitem quantity: %d\nitem cost: %.2f\nitem price: %.2f\n",this.itemCode,this.itemName,this.itemQuantity,this.itemCost,this.itemPrice);
     writer.format("%d\n%s\n%d\n%.2f\n%.2f\n",this.itemCode,this.itemName,this.itemQuantity,this.itemCost,this.itemPrice);
 }

//TODO WHAT'S LEFT TO DO.
// I NEED TO COMPARE ALL THE OBJECTS I CREATED SEE IF THE ITEM CODE IS BEING USED.. THEN SORT THEM BY ITEM CODE.  A METHOD THAT SORTS THE OBJECTS FOOD ITEM



    //TODO SEARCH ITEM
    // ************************************************** +++ YOU'RE HERE >
    // >>

}
