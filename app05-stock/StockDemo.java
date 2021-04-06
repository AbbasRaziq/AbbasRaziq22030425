import java.util.Random;

/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 *
 * @author Abbas Raziq
 * @version 02/04/2021
 */
public class StockDemo
{
    // The stock manager.
    private StockManager manager;
    private Random randomGenerator;
    private Product product;
    
    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockManager manager)
    {
        this.manager = manager;
        // Add at least 10 products, they do not have to be mobiles
        // Make sure the ids are sequential numbers;
        manager.addProduct(new Product(101, "Samsung Galaxy S21 Ultra"));
        manager.addProduct(new Product(102, "OnePlus 8 Pro"));
        manager.addProduct(new Product(103, "Google Pixel 4A"));
        manager.addProduct(new Product(104, "iPhone 12 Pro Max"));
        manager.addProduct(new Product(105, "Oppo Find X2 Pro"));
        manager.addProduct(new Product(106, "Motorola Edge Plus"));
        manager.addProduct(new Product(107, "Xiaomi Mi Note 10"));
        manager.addProduct(new Product(108, "Sony Xperia 1 II"));
        manager.addProduct(new Product(109, "Samsung Galaxy Note 20 Ultra"));
        manager.addProduct(new Product(110, "iPhone 11"));
        manager.addProduct(new Product(111, "iPad Pro 4th Gen"));
        manager.addProduct(new Product(112, "Xbox Series X"));
        manager.addProduct(new Product(113, "Playstation 5"));
    }

    /**
     * Provide a demonstration of how the StockManager meets all
     * the user requirements by making a delivery of each product 
     * re-stocking it by various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.
        manager.printAllProducts();
        demoDeliverProducts();
        manager.printAllProducts();        
        demoSellProducts();
        manager.printAllProducts();
    }
    
    /**
     * This is where the products will be delivered by the stock manager and will randomly generate deliver 
     * quantity
     */
    private void demoDeliverProducts()
    {
        System.out.println("Deliver");
        {
            manager.deliverProduct(103,20);
        }
    }
    
    /**
     * This is where the products will be sold by the stock manager and the quantity sold and will randomly
     * generate sell quantity
     */
    private void demoSellProducts()
    {
        System.out.println("Sell");
        {
            manager.sellProduct(103, 10);
        }
    }
}