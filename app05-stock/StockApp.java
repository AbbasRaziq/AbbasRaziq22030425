
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Abbas Raziq
 * @version 01/04/2021
 */
public class StockApp
{
    private InputReader reader;
    private StockManager manager;
    private Product product;
    private StockDemo demo;

    //Constants
    private final String ADD = "ADD";
    private final String PRINT = "PRINTALL";
    private final String REMOVE = "REMOVE PRODUCT";
    private final String DELIVER = "DELIVER PRODUCT";
    private final String SELL = "SELL PRODUCT";
    private final String SEARCH = "SEARCH PRODUDCT";
    private final String LOWSTOCK = "LOW STOCK";
    private final String RESTOCK = "RESTOCK";
    private final String PRINTPRODUCT = "PRINT PRODUCT";
    private final String QUIT = "QUIT";

    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        manager = new StockManager();
        demo = new StockDemo(manager);
    }

    /**
     *  Display a list of menu choices and get the user's
     *  choice.
     */
    public void run()
    {
        boolean finished = false;

        while(!finished)
        {
            printHeading();
            printMenuChoices();

            String prompt = "Enter your choice:";
            String choice = reader.getString(" Please enter your choice ");
            choice = choice.toUpperCase();
            System.out.println();
            if(choice.equals("QUIT"))
            {
                finished = true;
                System.out.println(" Thank you for using our program ");
            }
            else
            {
                executeMenuChoice(choice);
            }
        }
    }

    /**
     *  This allows the user to choose what to do
     */
    public void executeMenuChoice(String choice)
    {   
        if(choice.equals(ADD))
        {
            String name = reader.getString("Enter New Product Name \n");
            int id = reader.getInt("Enter New Product ID \n");
            Product product = new Product(id, name);
            manager.addProduct(product);
            System.out.println(product.getName() + ": " + product.getID());
            System.out.println("== ADDED ==");
            manager.printAllProducts();
        }
        
        else if(choice.startsWith(PRINT))
        {
            System.out.println("Printing All Products");
            manager.printAllProducts();
        }
        
        else if(choice.equals("REMOVE"))
        {            
            manager.printAllProducts();
            String name = reader.getString("Enter Product Name \n");
            int id = reader.getInt("Enter Product ID \n");
            Product product = new Product(id, name);
            manager.removeProduct(id);
            System.out.println(product.getName() + ": " + product.getID());
            System.out.println("== REMOVED ==");
            manager.printAllProducts();            
        }
        
        else if(choice.equals("DELIVER"))
        {
            String name = reader.getString("Enter Deliver Product Name \n");
            int id = reader.getInt("Enter Deliver Product ID \n");
            int amount = reader.getInt("Enter Deliver Amount \n");
            Product product = new Product(id, name);
            manager.deliverProduct(id, amount);
            System.out.println(product.getName() + ": " + product.getID());
            System.out.println("== DELIVERED ==");
            manager.printAllProducts();
        }
        
        else if(choice.equals("SELL"))
        {
            String name = reader.getString("Enter Sell Product Name \n");
            int amount = reader.getInt("Enter Sell Product Amount \n");
            int id = reader.getInt("Enter Sell Product ID \n");
            Product product = new Product(id, name);
            manager.sellProduct(id, amount);
            System.out.println(product.getName() + ": " + product.getID());
            System.out.println("== SOLD ==");
        }
        
        else if(choice.equals("SEARCH"))
        {
            manager.printAllProducts();
            String targetPhrase = reader.getString("Enter a phrase (case sensitive) \n");
            manager.searchProducts(targetPhrase);
        }
  
        else if(choice.equals("LOWSTOCK"))
        {
            if(manager.checkNoProducts()== true)
            {
                System.out.println("Product is low in stock");
            }
            else
            {
                manager.printLowStock();
            }
        }
        
        else if(choice.equals("RESTOCK"))
        {
            if(manager.checkNoProducts()== true)
            {
                System.out.println("This product is low ins stock");
            }
            else
            {
                manager.printLowStock();
                int amount = reader.getInt("Enter restock amount");
                manager.reStockProduct(amount);
                manager.printAllProducts();
            }
        }
        else if(choice.equals("PRINTPRODUCT"))
        {
            if(manager.checkNoProducts()== true)
            {
                System.out.println("No product with that name");
            }
            else
            {
                product.printDetails();
            }
        }
    }
      

    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    ADD :           Add a new product \n");
        System.out.println("    REMOVE:         Remove an old product\n");
        System.out.println("    PRINTPRODUCT:   Print all products\n");
        System.out.println("    DELIVER:        Deliver product\n"); 
        System.out.println("    SELL:           Sell product\n"); 
        System.out.println("    LOWSTOCK:       Print product with low stock\n");
        System.out.println("    SEARCH:         Search for a product\n");
        System.out.println("    RESTOCK:        Restock Product\n");
        System.out.println("    PRINT:          Print a product\n"); 
        System.out.println("    QUIT:           Quit the program\n");
        System.out.println();        
    }

    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Abbas Raziq");
        System.out.println("******************************");
    }
}