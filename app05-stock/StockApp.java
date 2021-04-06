
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Abbas Raziq
 * @version 02/04/2021
 */
public class StockApp
{
    private InputReader reader;
    private StockManager manager;
    private Product product;
    private StockDemo demo;

    //Constants
    private final String ADD =          "ADD";
    private final String PRINT =        "PRINT ALL";
    private final String REMOVE =       "REMOVE PRODUCT";
    private final String DELIVER =      "DELIVER PRODUCT";
    private final String SELL =         "SELL PRODUCT";
    private final String SEARCH =       "SEARCH PRODUDCT";
    private final String LOWSTOCK =     "LOW STOCK";
    private final String RESTOCK =      "RESTOCK";
    private final String PRINTPRODUCT = "PRINT A PRODUCT";
    private final String QUIT =         "QUIT";

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

            String prompt = "\n Enter your choice:";
            String choice = reader.getString(" Please enter your choice ");
            choice = choice.toUpperCase();
            System.out.println();
            if(choice.equals("QUIT"))
            {
                finished = true;
                System.out.println(" Thank you for using the app, you are now exiting the program ");
            }
            else
            {
                executeMenuChoice(choice);
            }
        }
        printHeading();
    }

    /**
     *  This allows the user to choose what to do
     */
    public void executeMenuChoice(String choice)
    {
        //This allows the user to add a product
        if(choice.equals(ADD))
        {
            String name = reader.getString("Enter new product name to ADD \n");
            int id = reader.getInt("Enter new product ID to ADD \n");
            Product product = new Product(id, name);
            manager.addProduct(product);
            System.out.println(product.getName() + ": " + product.getID());
            System.out.println("== ADDED ==");
            manager.printAllProducts();
        }
        
        //This allows the user to print all products
        else if(choice.equals("PRINT"))
        {
            System.out.println(" Printing All Products ");
            manager.printAllProducts();
        }
        
        //This allows the user to remove a product
        else if(choice.equals("REMOVE"))
        {            
            manager.printAllProducts();
            String name = reader.getString("Enter product name to REMOVE \n");
            int id = reader.getInt("Enter product ID to remove \n");
            Product product = new Product(id, name);
            manager.removeProduct(id);
            System.out.println(product.getName() + ": " + product.getID());
            System.out.println("== REMOVED ==");
            manager.printAllProducts();            
        }
        
        //This allows the user to deliver a product
        else if(choice.equals("DELIVER"))
        {
            String name = reader.getString("Enter product name to deliver \n");
            int id = reader.getInt("Enter product ID to deliver \n");
            int amount = reader.getInt("Enter product AMOUNT to DELIVER \n");
            Product product = new Product(id, name);
            manager.deliverProduct(id, amount);
            System.out.println(product.getName() + ": " + product.getID());
            System.out.println("== DELIVERED ==");
            manager.printAllProducts();
        }
        
        //This allows the user to sell a product
        else if(choice.equals("SELL"))
        {
            String name = reader.getString("Enter product name to SELL \n");
            int amount = reader.getInt("Enter product AMOUNT to SELL \n");
            int id = reader.getInt("Enter product ID to SELL \n");
            Product product = new Product(id, name);
            manager.sellProduct(id, amount);
            System.out.println(product.getName() + ": " + product.getID());
            System.out.println("== SOLD ==");
        }
        
        //This allows the user to search fro a product using a keyword to find products relating to it
        else if(choice.equals("SEARCH"))
        {
            manager.printAllProducts();
            String targetPhrase = reader.getString("Enter a KEYWORD (case sensitive)  \n");
            manager.searchProducts(targetPhrase);
        }
   
        //This allows the user to see products with low stock
        else if(choice.equals("LOWSTOCK"))
        {
            if(manager.checkNoProducts()== true)
            {
                System.out.println("Products are low in stock");
            }
            else
            {
                manager.printLowStock();
            }
        }
        
        //This allows the user to restock products if the stock is low and the amount of stock to add
        else if(choice.equals("RESTOCK"))
        {
            if(manager.checkNoProducts()== true)
            {
                System.out.println("This product is low in stock needs RESTOCKING");
            }
            else
            {
                manager.printLowStock();
                int amount = reader.getInt("Enter the AMOUNT to RESTOCK");
                manager.reStockProduct(amount);
                manager.printAllProducts();
            }
        }
        
        //This allows the user to print a single product
        else if(choice.equals("PRINTPRODUCT"))
        {
            if(manager.checkNoProducts()== true)
            {
                System.out.println("There are no products in the system");
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
        System.out.println("    PRINT:          Print all products\n");
        System.out.println("    DELIVER:        Deliver specific product\n"); 
        System.out.println("    SELL:           Sell a specific product\n"); 
        System.out.println("    LOWSTOCK:       Print Product that is low in stock\n");
        System.out.println("    SEARCH:         Search for a specific product\n");
        System.out.println("    RESTOCK:        Restock Product\n");
        System.out.println("    PRINTPRODUCT:   Print a specific product\n"); 
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
