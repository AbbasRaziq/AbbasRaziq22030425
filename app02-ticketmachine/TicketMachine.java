import java.text.SimpleDateFormat;

/**
 * The ticket machine is where the users select tickets and where the tickets
 * are printed and money stored.
 * Prices of the tickets are shown by the constructor.
 * The amount of money inserted by the user will be checked by instances and to
 * see if the right amount of money to purchase a ticket has been input.
 * 
 * @author Abbas Raziq
 * @version 27/11/2020
 */
public class TicketMachine
{
    public static final Ticket Aylesbury_TICKET = new Ticket("Aylesbury", 200);
    public static final Ticket Amersham_TICKET = new Ticket("Amersham", 300);
    public static final Ticket HighWycombe_TICKET  = new Ticket("High Wycombe", 330);
    
    // This selects the ticket you want and puts it in curret ticket.
    private Ticket currentTicket;
    
    // Money that is inputted by the user and is stored in the balance.
    private int balance;
    
    // The total of money collected by this machine in pence input by the user.
    private int total;
    
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * A machine that sets that the balance as 0 and that there is no ticket
     * selected.
     */
    public TicketMachine()
    {
        balance = 0;
        total = 0;

        currentTicket = null;
    }


    public void PrintDestinations()
    {
        System.out.println("Available Tickets: ");

        System.out.print(" Tickets to " + Aylesbury_TICKET.getDestination());
        System.out.println(" cost " + Aylesbury_TICKET.getPrice());
        
        System.out.print(" Tickets to " + Amersham_TICKET.getDestination());
        System.out.println(" cost " + Amersham_TICKET.getPrice());  
        
        System.out.print(" Tickets to " + HighWycombe_TICKET.getDestination());
        System.out.println(" cost " + HighWycombe_TICKET.getPrice());        
    }
    
    public void selectAylesburyTicket()
    {
       currentTicket = Aylesbury_TICKET; 
    }
    
    public void selectAmershamTicket()
    {
       currentTicket = Amersham_TICKET; 
    }
    
    public void selectWycombeTicket()
    {
       currentTicket = HighWycombe_TICKET; 
    }
    
    /**
     * Uses the current ticket to get price for the ticket.
     */
    public int getPrice()
    {
        if(currentTicket != null)
        {
            return currentTicket.getPrice();
        }
        else
        {
            System.out.println("You have not chosen a destination!");
            return 0;
        }
    }

    /**
     * The enumaration only allows the chosen coins.
     */
    public void insertCoin(Coin coin)
    {
        updateBalance(coin.getValue());
    }
    
    /**
     * Return the amount of money the user has input.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * This method allows a simple integer to only accept certain coins.
     */
    public void insertCoin(int value)
    {
        switch(value)
        {
            case 10:  case 20: case 100: case 200: 
            
                updateBalance(value);
                break;

            default: 
                System.out.println();
                System.out.println("This " + value + " is not an acceptable coin!");
        }
    }
    
    private void updateBalance(int amount)
    {
        balance = balance + amount;
        
        System.out.println();
        System.out.println("Received " + amount + " pence");
        printBalance();
    }

    public void printBalance()
    {
        System.out.println("Balance " + balance + " pence");
    }
    
    /**
     * This prints the ticket the user has chosen if the correct amount of money
     * has been input and then prints the balance after the ticket has been bought.
     */
    public void printTicket()
    {
        int price = currentTicket.getPrice();
        
        String date = formatter.format(currentTicket.getDate());
        String destination = currentTicket.getDestination();
        
        if(balance >= price) 
        {
            System.out.print("Train Ticket to ");
            System.out.println(destination );
            System.out.println("Date: " + date);
            System.out.println("Price: " + price + " pence");
            System.out.println();

            // Update the totalCollected collected with the price.
            total = total + price;
            // Reduce the balance by the prince.
            balance = balance - price;
        }
        else 
        {
            System.out.println("Please insert at least: " +
                (price - balance) + " more pence.");

        }
    }

    /**
     * Money is returned to balance and the balance is then cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
