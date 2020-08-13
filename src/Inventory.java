import java.io.*;
import java.rmi.ServerError;
import java.util.*;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;


/**
 * Inventory is the class that runs the show, it has all the methods that will be called in the main class of the program and it's in this class that the inventory will be modified/Updated..etc
 * this class has the foodItem array set to default.
 */

////TODO
//        Inventory:
//        Updated: public boolean addItem(Scanner scanner, boolean fromFile)
//        Added: public void searchForItem(Scanner scanner)
//        Added: public void saveToFile(Scanner scanner)
//        Added: public void readFromFile(Scanner scanner)


public class Inventory {


    private Date today;
    private InventoryItem[] Inventory;
    private int numItems;

    /**
     * Constructor default array set to 20 nothing over 20
     */
    public Inventory(){
        Inventory = new InventoryItem[20];
    }

    /**
     * this Method will first count the null values in the array and count what's actually valid in the array. I use this count as my iteration to avoid Array Out of Bounds index. ]
     *
     * @param item
     * @return Integer Either the index or -1 to signify that it doesn't exist.
     */
    public int alreadyExists(InventoryItem item) {
        //TODO Returns the index of a FoodItem in the inventory array with the same itemCode as the FoodItem object in the parameter list, else returns -1
        int checknulls=checkNull();
        int i =0;
        while(i<checknulls){
            if (item.getItemCode() ==Inventory[i].getItemCode()) {
                return i;
            }
            i++;
        }
        return -1;

    }
    /*String[] token = item.toString().split("\\s");
      System.out.println(token[1]);
           System.out.println(" \n\n\n\n\n");
           //just some test stuff
        return Integer.parseInt(token[1]);
       }
       else return -1;
*/

    /**
     * this method adds an item buy scanning data from the user.
     * @param scan
     * @return true
     */
   public boolean addItem(Scanner scan, boolean fromFile) {
//    if(fromFile){
//TODO READ PROGRAM FROM FILE

//   }else{
           //so Additems is calling the child class method but in the child class method they're calling the super class method to
           int index = 0;
           //to get the information needed from the data members
           while (Inventory[index] != null) {
               index++;
               //incrementing the array
               //so this is going until it's empty than returns the index at witch it's empty
           }


           String choice = "";
           System.out.println("Do you wish to add Fruit (f), Vegetable (v) or a preserve (p)");
           choice = scan.nextLine();
        switch (choice) {
            case "f": {
                // System.out.println("you made it to fruits");
                InventoryItem item = new InventoryItem(new Fruit());
               item.addItem(scan);
                //Find the empty spot in the array
                int check = alreadyExists(item);
                //if returns -1 it already exists
                if (check == -1) {
                    Inventory[index] = item;
                } else {
                    System.err.println("this Item already exists in our records. check index: " + check);
                }

                break;
            }
            case "v": {
                //  System.out.println("you made it vegetables");
                InventoryItem item = new InventoryItem(new Vegetable());
                item.addItem(scan);
                //Find the empty spot in the array
                int check = alreadyExists(item);
                //if returns -1 it already exists
                if (check == -1) {
                    Inventory[index] = item;
                } else {
                    System.err.println("this Item already exists in our records. check index: " + check);
                }

                break;
            }
            case "p": {
                // System.out.println(" you made it preservatives");
                InventoryItem item = new InventoryItem(new Preserve());
                item.addItem(scan);
                //Find the empty spot in the array
                int check = alreadyExists(item);
                //if returns -1 it already exists
                if (check == -1) {
                    Inventory[index] = item;
                } else {
                    System.err.println("this Item already exists in our records. check index: " + check);
                }

                break;
            }
            default:
                System.err.println("Invalid input.");
                break;
        }
       SortIndex();
       //}
return true;
   }//END METHOD;


    /**
     * uodate Quantity method takes in a Scanner and A Boolean if the Boolean is true the program will add items to the given inventory code
     * Otherwise the boolean is false, and the program will send scan a positive integer and pass the negative of that integer in the updateItem Method in the FootItem class.
     * @param scan
     * @param buyOrSell
     * @return true
     */
   public boolean updateQuantity(Scanner scan, Boolean buyOrSell) {
       //TODO NOTES: THIS CODE CHECKS FOR THE NULL VALUES IN THE ARRAY
       //   WHAT EVER INST NULL
        boolean found =false;
        int checknulls=checkNull();

       if(Inventory.length !=  checknulls) {
        if (buyOrSell) {

                int code;
                                                                                                                        System.out.println("CAPTAIN HOOK");
                try {
                    System.out.println("Enter the code for the Item:");
                    code = Integer.parseInt(scan.nextLine());
                } catch (InputMismatchException | NumberFormatException e) {
                    code = 0;
                }

                                                                                                                        System.out.println("CAPTIAN HOOK???");
                //TODO HANDLE THE EXCEPTIONS HERE **************************

                int match = 0;

                //TODO THIS FOOR LOOP WILL CHECK EACH INVENTORY ITEM GET IT'S TOO STRING AND GET THE ITEM CODE.

                for (int i = 0; i <checknulls; i++) {

                    if (code == Inventory[i].getItemCode()) {
                        match=i;
                        found=true;
                       i = checknulls;
                    }
                }
                    //just gonna parse the string from the fooditems it's accessing and get the code
/*
                    try {
                        s = Inventory[i].toString();
                    } catch (NullPointerException e) {
                        i=Inventory.length;
                       // System.out.println("CHECK CHECK CHECK");
                    }

                    //TODO CATCH THE NULL POINTER EXCEPTION

                    String[] token = s.split(" ");
                    if (code == Integer.parseInt(token[1])) {
                        match = i;
                        i = Inventory.length;

                        found =true;
                    }//END OF THE IF STATEMENT TO CHECK THE PARSE MATCH*/
               // END OF THE FOR LOOP

            if(found) {                //  Inventory[i].updateItem()
                int itemQuantity;
                do {
                    try {
                        System.out.println("Please enter Quantity of items");
                        itemQuantity = Integer.parseInt(scan.nextLine());
                        if (itemQuantity < 0) {
                            System.err.println("Must be Positive");
                        }
                    } catch (NumberFormatException | InputMismatchException e) {
                        itemQuantity = -1;
                        System.err.println("Must enter Valid positive Integer");
                    }
                } while (itemQuantity < 0);

                Inventory[match].updateQuantity(itemQuantity,scan);
            }   else System.err.println("this Item doesn't exist.");


       } else {//this  is IF It's sell
//TODO ***********************************************************************************************************

    //TODO THIS SECTION IS DEDICATED TO THE SALE OF ITEMS SAME CONCEPT

            int code;



            try {
                System.out.println("Enter the code for the Item:");
                code = Integer.parseInt(scan.nextLine());
            } catch (InputMismatchException | NumberFormatException e) {
                code = 0;
                System.err.println("invalid input");
            }



            //TODO HANDLE THE EXCEPTIONS HERE **************************
            String s = "";
            int match = 0;
            for (int i = 0; i < Inventory.length; i++) {

                //just gonna parse the string from the fooditems it's accessing and get the code

                try {
                    s = Inventory[i].toString();
                } catch (NullPointerException e) {
                    i=Inventory.length;
                    //System.out.println("CHECK CHECK CHECK");
                }

                //TODO CATCH THE NULL POINTER EXCEPTION

                String[] token = s.split(" ");
                if (code == Integer.parseInt(token[1])) {
                    match = i;
                    i = Inventory.length;

                    found =true;
                }//END OF THE IF STATEMENT TO CHECK THE PARSE MATCH
            }// END OF THE FOR LOOP





            //  Inventory[i].updateItem()'

            if(found) {

                int itemQuantity=1;
                //TODO THIS BLOCK OF CODE PARSES THE TO STRING
                int amountAvailable;



//                String[] result = Inventory[match].toString().split("\\s");
                //amount = Integer.parseInt(result[3]);

               amountAvailable =  Inventory[match].getItemQuantityinStock();

                //TODO **********************

                do {
                    try {
                        System.out.println("Please enter Quantity of items... available units: "+amountAvailable);
                        itemQuantity = Integer.parseInt(scan.nextLine());
                        if (itemQuantity < 0) {
                            System.err.println("Must be Positive");
                        } else if (itemQuantity > amountAvailable) {
                            System.err.println("not enough items to sell");
                        }


                    } catch (NumberFormatException | InputMismatchException e) {
                        itemQuantity = -1;
                        System.err.println("Must enter Valid positive Integer");
                    }
                    //TODO CONDITION THAT CHECKS IF THE SALE IS POSSIBLE ]
                    //  NEED TO PARSE THE TO STRING TO BE ABLE
                /*
               while(itemQuantity > amount)
                   if(itemQuantity > amount){
                   }
             }
*/
                } while (itemQuantity > amountAvailable);

                Inventory[match].updateQuantity(-itemQuantity,scan);
            }else{
                System.err.println("Item doesn't Exist");
            }
           //System.out.println("Enter Item Code");
       }// END OF SELL


       }else{
           System.err.println("INVENTORY EMPTY");

       }
       //TODO THIS CHECKS IF THE INVENTORY IS EVEN WORTH SELLING AND BUYING
       return true;
   }

    /**
     * this method is the intermediate method from the wrapper to the main method this method simply checks if the  Item code is valid
     * @param scan
     */
   public void displayItemExpiryDates(Scanner scan){
      int index = searchForItem(scan);
      if(index == -1){
          System.err.println("Item not found, index :"+index);
      }else{
          Inventory[index].printExpirySum();
      }
   }





    /**
     * this method searches through the index to find an item. implemented using a binairy search.
     * @return void
     * @param scan
     */
   public int searchForItem(Scanner scan) {
       SortIndex();
       int searchKey=0;
       try {
           System.out.println("Enter the code for the Item:");
           searchKey = Integer.parseInt(scan.nextLine());
       } catch (InputMismatchException | NumberFormatException e) {
           System.err.println("invalid input");
       }

       int left=0;
       int right = checkNull();
       // Big O(log n)
       while(left <= right){
           int middle = (left +right)/2;
           if(searchKey < Inventory[middle].getItemCode()){
               right = middle-1;
           } else if (searchKey >  Inventory[middle].getItemCode()){
               left = middle +1;
           }else{
               System.out.println(Inventory[middle].toString());
               return middle;
           }
       }
       return -1;
   } //TODO ********* [ END OF SEARCH FOR ITEM ] ****************
    /**
     * This saves to a file using file input stream and a formatter to append the strings to a file in the temp directory.
     * @param scan
     */
   /*
   public void saveToFile(Scanner scan){
       //TODO SEARCH ITEM VOIDING FUNCTIONAL SUPPORT FOR READING AND WRITING
       // ********************************************* WRITE CODE HERE ***** +++ YOU'RE HERE >
       // >>
       try {
           System.out.println("Enter the Name of the file you wish to save to:");
           String path = scan.nextLine();
           File file = new File("c:\\temp\\" + path);
           int i=0;

           while(!(Inventory[i]==null)) {
               Inventory[i].outputItem(new Formatter(new FileWriter(file,true)));
               i++;
           }
       }catch(IOException ignore){
           System.err.println("");
       }


  }  */  //TODO ********* [ END OF SAVE TO ITEM ] ******************

    /**
     * TODO
     *  reads from the files, iterates through each individual line and passes the scanner values to then create a new class.
     *  it finds the first available letter to determine what sub class of fooditem it belongs to.
     * @param scanner
     */
    /*
    public void readFromFile(Scanner scanner)  {
        int index;
        System.out.println("Please enter file you wish to read from.");
        String path = scanner.nextLine();
        File file = new File("c:\\temp\\" + path);

       try(Scanner sc = new Scanner(file)) {

          // int i=0;
                while(sc.hasNextLine()) {

                   index = checkNull();
                    //System.out.println(i++);

                    switch (sc.nextLine()) {
                        case "f": {
                            boolean exists =true;
                            Fruit f = new Fruit();
                            f.addItem(sc, true);
                            for(int i=0;i<index;i++){
                               if(Inventory[i].isEqual(f)){
                                   System.err.println("Item already exists, ID: "+Inventory[i].getItemCode()+", reading process: -1 ");
                                   exists = false;
                               }
                            }
                            if(exists) {
                               Inventory[index] = f;
                            }
                          // System.out.println(f.toString());
                          break;
                       }
                       case "v":{
                           boolean exists =true;
                            Vegetable v = new Vegetable();
                            v.addItem(sc, true);
                            for(int i=0;i<index;i++){
                               if(Inventory[i].isEqual(v)){
                                    System.err.println("Item already exists, ID: "+Inventory[i].getItemCode()+", reading process: -1 ");
                                    exists = false;
                                }
                            }
                            if(exists) {
                                Inventory[index] = v;
                            }
                                break;
                        }
                        case "p": {
                            boolean exists =true;
                            Preserve p = new Preserve();
                            p.addItem(sc, true);
                            for(int i=0;i<index;i++){
                                if(Inventory[i].isEqual(p)){
                                    System.err.println("Item already exists, ID: "+Inventory[i].getItemCode()+", reading process: -1 ");
                                    exists = false;
                                }
                            }
                           // System.out.println(p.toString());
                            if(exists) {
                                Inventory[index] = p;
                            }
                            break;
                        }
                    }
                }
      }catch(IOException e){
           System.err.println("file doesn't exist.");
       }
   }         //TODO ********* [ END OF READ TO ITEM ] ******************
           System.out.println(i);
            System.out.println(temp[i].toString());

*/



    /**
     * this just builds the strings of the inventory using the string builder class.
     * @return Strings
     */
    @Override
    public String toString() {
        SortIndex();
        StringBuilder String = new StringBuilder("Inventory: \n");
        for(int i=0; Inventory[i]!=null;i++){
           String.append(Inventory[i].toString()).append("\n");
        }
        return String.toString();
    }

    private int checkNull(){
        int checknulls=0;
        for(int i =0;i<Inventory.length;i++) {
            if (Inventory[i] != null) {
                checknulls++;
            }
        }
        return checknulls;
    }
    private boolean checkExistance(int code){
        int index = checkNull();
        for(int i =0; i < index; i++){
            if(code == Inventory[i].getItemCode()){
                System.err.println("this Item already exists, abort reading.");
                return false;

            }
        }
        return true;
    }


    private void SortIndex(){
        int index = checkNull();
        int j;
        InventoryItem[] temp;
        InventoryItem tempItem;
        InventoryItem key;
        temp = Inventory;
        for (int i =1; i <index ;i++){
            key = temp[i];
            j = i-1;

            while(j>= 0 && key.compare(temp[j])==1){
                  tempItem = temp[j];
                  temp[j] = temp[j+1];
                  temp[j+1]= tempItem;
                  j--;
            }
        }
    }

    /**
     *
     * @return the local date, it sets the date to your systems date
     *
     */
    public Date setDate() {
        System.out.print("today date: ");
        today = Calendar.getInstance().getTime();
        return today;
    }

    /**
     * removeExpiredItems calls the InventoryItem class RemoveExpiredItems
     */
    public void removeExpiredItems(){
        int amount = checkNull();
        for(int i = 0; i< amount;i++)
            Inventory[i].RemoveExpiredItems(today);
    }


}
