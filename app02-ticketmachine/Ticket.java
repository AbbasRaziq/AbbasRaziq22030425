import java.util.Date;

/**
 * This is where the ticket is created and stored with the date, price and destination.
 * 
 * @author Abbas Raziq
 * @version 27/11/2020
 */
public class Ticket
{
    // Ticket price in pence
    private int price;
    // Time in hours
    private String destination;
    
    private Date present = new Date();
    
    /**
     * This constructor is for creating tickets and input the destination.
     */
    public Ticket( String destination, int price)
    {
        // Variables used to input info on tickets
        this.price = price;
        this.destination = destination;
    }

    /**
     * Price of tickets
     */
    public int getPrice()
    {
        return price;
    }
    
    /**
     * Name of destination
     */
    public String getDestination()
    {
        return destination;
    }
    
    public Date getDate()
    {
        return present;
    }
    
}