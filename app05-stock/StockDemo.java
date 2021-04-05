/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author Abbas Raziq
 * @version 11/03/2021
 */
public class StockDemo
{
    // The stock manager.
    private StockManager manager;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockManager manager)
    {
        this.manager = manager;

        // Add at least 10 products, they do not have to be mobiles
        // Make sure the ids are sequential numbers
        System.out.println("Attempt to add products with 0 quantity");

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
     * This is where the products will be delivered by the stock manager
     */
    private void demoDeliverProducts()
    {
        System.out.println("Attempt to deliver products");

        manager.deliverProduct(101, 10);
        manager.deliverProduct(102, 10);
        manager.deliverProduct(103, 10);
        manager.deliverProduct(104, 10);
        manager.deliverProduct(105, 10);
        manager.deliverProduct(106, 10);
        manager.deliverProduct(107, 10);
        manager.deliverProduct(108, 10);
        manager.deliverProduct(109, 10);
        manager.deliverProduct(110, 10);
        manager.deliverProduct(111, 10);
        manager.deliverProduct(112, 10);
        manager.deliverProduct(113, 10);
    }

    /**
     * This is where the products will be sold by the stock manager and the quantity sold
     */
    private void demoSellProducts()
    {
        System.out.println("Attempt to sell products");

        manager.sellProduct(101, 10);
        manager.sellProduct(102, 10);
        manager.sellProduct(103, 10);
        manager.sellProduct(104, 10);
        manager.sellProduct(105, 10);
        manager.sellProduct(106, 10);
        manager.sellProduct(107, 10);
        manager.sellProduct(108, 10);
        manager.sellProduct(109, 10);
        manager.sellProduct(110, 10);
        manager.sellProduct(111, 10);
        manager.sellProduct(112, 10);
        manager.sellProduct(113, 10);
    }
}
