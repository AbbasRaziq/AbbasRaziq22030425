import java.util.Date;
/**
 * Write a description of class Ticket here.
 *
 * @author Abbas Raziq
 * @date 13/11/2020
 */
public class Ticket
{
    private String destination;
    
    //in pence
    private int price;
    
    private Date datePurchased;
    /**
     * Constructor for objects of creating a price and destination.
     */
    public Ticket(String destination, int price)
    {
        this.price = price;
        this.destination = destination;
        datePurchased = new Date();
    }
    
    /**
     * This method allows us to get the ticket price.
     */
    public int getPrice()
    {
        return price;
    }
    
    /**
     * This method allows us to get the ticket destination.
     */
    public String getDestination()
    {
        return destination;
    }
    
    /**
     * This method allows us to get the date the ticket was purchased.
     */
    public Date getdatePurchased()
    {
        return datePurchased;
    }
    
    public void print()
    {
        System.out.print("Destination: " + destination);
        System.out.println(" Price: "+ price + " pence");
    }
}
