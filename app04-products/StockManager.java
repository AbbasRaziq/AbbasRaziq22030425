import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Abbas Raziq
 * @version 11/03/2021
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void deliverProduct(int id, int amount)
    {
        Product product = findProduct(id);

        if(product != null)
        {
            product.increaseQuantity(amount);
        }
        else
        {
            System.out.println("The product was not found");
        }   
    }

    /**
     * This will find the product in the stock with the given id, it will then either return with the product or
     * nothing if there is no product with the id
     */
    public Product findProduct(int id)
    {
        for(Product product : stock)
        {
            if(id == product.getID())
            {
                return product;
            }
        }
        return null;
    }

    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int id, int amount)
    {
        Product product = findProduct(id);

        if(product != null) 
        {
            product.sellQuantity(amount);
        }
        else
        {
            System.out.println("The product was not found");
        }   
    }    

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        return 0;
    }

    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printProduct(int id)
    {
        Product product = findProduct(id);

        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }

    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void printAllProducts()
    {
        printHeading();

        for(Product product : stock)
        {
            System.out.println(product);
        }

        System.out.println();
    }

    /**
     * This will just output the heading given below
     */
    public void printHeading()
    {
        System.out.println();
        System.out.println("Abbas's Stock List");
        System.out.println("====================");
        System.out.println();
    }

    /**
     * This will allow the stock manager to rename a product using the inputted id if not it will return will 
     * null if the id is not matching any products
     */
    public void renameProduct(int id, String newName)
    {
        Product product = findProduct(id);

        if(product == null) 
        {
            System.out.println("Product id = " + id + " not found");
        }
        else
        {
            System.out.println(product);
            product.setName(newName);
            System.out.println("==Product Renamed==");
            System.out.println(product);
        }
    }

    /**
     * This will allow the stock manager to remove a product using the inputted id and output it has been 
     * removed if not it will return will null if the id is not matching any products
     */
    public void removeProduct(int id)
    {
        Product product = findProduct(id);

        if(product == null) 
        {
            System.out.println("Product id = " + id + " not found");
        }
        else
        {
            stock.remove(product);
            System.out.println("Product id " + id + " removed");
        }
    }
    
    public void getLowStockProducts(int minimum)
    {
        System.out.println("Products with low stock:");
        
        for(Product product : stock)
        {
            if(product.getQuantity() <= 10)
            {
                System.out.println(product.toString());
            }
        }
    }
    
    public void searchProducts(String searchPhrase)
    {
        int number = 0;
        System.out.println("===Searching for " + searchPhrase + "===");
        
        for(Product product : stock)
        {
            if(product.getName().contains(searchPhrase))
            {
                System.out.println(product);
                number++;
            }
        }
        
        System.out.println("There are " + number + " products that contain " + searchPhrase + " in their name");
    }
}
