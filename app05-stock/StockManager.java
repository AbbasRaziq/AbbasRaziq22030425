import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Abbas Raziq
 * @version 01/04/2021
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
            System.out.println(" Delivered Product : " + product);
        }
        else 
        {
            System.out.println("== Product not found ==");
        }
    }

    /**
     * This is to find the product by ID
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
     * This is to find products with the keyword input
     */
    public void searchProducts(String keyword)
    {
        int count = 0;
        System.out.println("\nSearching for  " + keyword + "\n");
        for(Product product: stock)
        {
            if(product.getName().contains(keyword))
            {
                System.out.println(product);
                count++;
            }
        }
        System.out.println(" There are " + count+ " " + " remaining product " + keyword + " in their name ");
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
            System.out.println(" Selling Product: " + id);
            System.out.println("Product quantity: " + amount);
            product.sellQuantity(amount);
        }
        else
        {
            System.out.println("== Product not found ==");
        }
    }

    /** 
     * This prints the details of the product
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
            System.out.println("== Product not found ==");
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
     * This prints all products and the stock of the products
     */
    public void printAllProducts()
    {
        for(Product product : stock)
        {
            System.out.println(product);
        }
        System.out.println();
    }

    /**
     * This is to rename a product
     */
    public void renameProduct(int id, String newName, String name)
    {

        Product product = findProduct(id);

        if(product == null)
        {
            System.out.println( "Product: " + id + ", Name" + name  + " not found ");
        }
        else 
        {
            System.out.println(product);
            product.setName(newName);
            System.out.println("=== RENAMED ===");
            System.out.println (product);
        }
    }
    
    /**
     * This is to remove a product by ID
     */
    public void removeProduct(int id)
    {
        Product product = findProduct(id);

        if(product == null)
        {
            System.out.println(" Product ID " + id + "== Product Not Found ==");
        }
        else
        {
            stock.remove(product);
            System.out.println(" Product " + id);
            System.out.println("=== REMOVED ===");
        }
    }

    /**
     *  This is to restock products with low stock
     */
    public void reStockProduct(int amount)
    {
        for(Product product: stock)
        {
            if(product.getQuantity() <= 5)
            {
                product.increaseQuantity(amount);    
            }
        }
    }

    /**
     * This is to print the products with stock lower than 5
     */
    public void printLowStock()
    {
        System.out.println(" All Products with Low Stock ");
        System.out.println();
        for(Product product: stock)
        {
            if(product.getQuantity() < 5)
            {
                product.printDetails();
            }
        }
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
}
