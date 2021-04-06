import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Abbas Raziq
 * @version 02/04/2021
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
            System.out.println(" Product Delivered : " + product);
            System.out.println(" Quantity Delivered : " + amount);
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
        // if product is not equal to null
        if(product != null)
        {
            System.out.println(" Selling: " + id);
            System.out.println(" Quantity: " + amount);
            product.sellQuantity(amount);
        }
        else
        {
            System.out.println("The product was not found");
        }
    }

    /** 
     * This shows the detail of the product
     */
    public void printDetails(int id)
    {
        Product product = findProduct(id);

        if(product != null)
        {
            System.out.println(" Stock Available : " + product.getQuantity());
            System.out.println(product);
        }
        else 
        { 
            System.out.println(" The product was not found ");
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
     * This will allow the stock manager to rename a product using the inputted id if not it will return will 
     * null if the id is not matching any products
     */
    public void renameProduct(int id, String newName, String name)
    {

        Product product = findProduct(id);

        if(product == null)
        {
            System.out.println("Product id = " + id + " NOT FOUND");
        }
        else 
        {
            System.out.println(product);
            product.setName(newName);
            System.out.println("== Product RENAMED ==");
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
            System.out.println("Product id = " + id + " NOT FOUND");
        }
        else
        {
            stock.remove(product);
            System.out.println("\n Product ID " + id + " REMOVED \n ");
        }
    }

    /**
     * This will print out products that are low in stock
     */
    public void printLowStock()
    {
        System.out.println(" Products with low stock: ");
        System.out.println();
        for(Product product : stock)
        {
            if(product.getQuantity() < 5)
            {
                product.printDetails();
            }
        }
    }

    /**
     *  This will restock products with stock lower than or equal to 5
     */
    public void reStockProduct(int amount)
    {
        for(Product product : stock)
        {
            if(product.getQuantity() <= 5)
            {
                product.increaseQuantity(amount);    
            }
        }
    }

    /**
     * This will find products relating to the keyword
     */
    public void searchProducts(String targetPhrase)
    {
        int number = 0;
        System.out.println("\nSearching for  " + targetPhrase + "\n");
        for(Product product: stock)
        {
            if(product.getName().contains(targetPhrase))
            {
                System.out.println(product);
                number++;
            }
        }

        System.out.println(" There are " + number + " " + " remaining product " + targetPhrase + " in their name ");
    }

    /**
     * This is to check the number of products with stock
     */
    public boolean checkNoProducts()
    {
        if(stock.isEmpty() == true)
        {
            return true;
        }
        return false;
    }

    /**
     * This will print out a heading with the stock managers details
     * 
     */
    public void printHeading()
    {
        System.out.println();
        System.out.println(" Abbas's Stock List ");
        System.out.println("====================");
        System.out.println();
    }
}
