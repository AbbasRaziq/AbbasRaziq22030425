
/**
 * Model some details of a product sold by a company.
 * 
 * @author Abbas Raziq
 * @version 01/04/2021
 */
public class Product
{
    // An identifying number for this product.
    private int id;
    // The name of this product.
    private String name;
    // The quantity of this product in stock.
    private int quantity;

    /**
     * Constructor for objects of class Product.
     * The initial stock quantity is zero.
     * @param id The product's identifying number.
     * @param name The product's name.
     */
    public Product(int id, String name)
    {
        this.id = id;
        this.name = name;
        quantity = 0;
    }

    /**
     * @return The product's id.
     */
    public int getID()
    {
        return id;
    }

    /**
     * @return The product's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * This will set the name and allow for the products to be renamed
     */
    public void setName(String newName)
    {
        name = newName;
    }

    /**
     * @return The quantity in stock.
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * @return The id, name and quantity in stock.
     */
    public void printDetails()
    {
        System.out.println(id + ": " +  name + " stock level: " + quantity);
    }

    /**
     * Restock with the given amount of this product.
     * The current quantity is incremented by the given amount.
     * @param amount The number of new items added to the stock.
     *               This must be greater than zero.
     */
    public void increaseQuantity(int amount)
    {
        if(amount > 0) 
        {
            quantity += amount;
        }
        else 
        {
            System.out.println(" Restock " + name + " quantity: " + amount);
        }
    }

    /**
     * Sell one of these products.
     * An error is reported if there appears to be no stock.
     */
    public void sellQuantity(int amount)
    {
        if(amount <= quantity) 
        {
            quantity -= amount;
        }
        else if(amount > quantity) 
        {
            System.out.println("This product does not have enough stock to sell");
        }
        else if(amount == 0)
        {
            System.out.println("Error: Must enter a positive value");
            System.out.println("Attempt to sell " + amount + " " + name + " when there is only " + quantity + " in stock");
        }
    }
}
