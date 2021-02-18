
/**
 * A module is part of a course that a student will complete. When the module is complete a mark is awarded and if it is a pass mark students gain credits for completing
 * the module.
 *
 * @author Abbas Raziq
 * @version 18/02/2021
 */
public class Module
{
    public static final int CREDIT = 30;

    // the module code
    private String code;
    //the title of the module
    private String title;

    private int mark;
    private boolean complete;

    /**
     * Constructor for objects of class Module
     */
    public Module(String code, String title)
    {
        this.code = code;
        this.title = title;

        complete = false;
        mark = -1;
    }

    /**
     * Return a mark between 0 and 100. A mark less than zero shows that no mark has yet been awarded.
     */
    public int getMark()
    {
        return mark;
    }

    /**
     * A mark has been awarded and the module is completed.
     */
    public boolean isComplete()
    {
        return complete;
    }

    /**
     * What mark is achieved and if it is awarded a mark the module is complete.
     */
    public void awardMark(int mark)
    {
        if((mark >= 0) & (mark <= 100))
        {
            this.mark = mark;
            complete = true;
        }
    }

    /**
     * Print the mark achieved, module code and title or if no mark is given.
     */
    public void print()
    {
        System.out.print("\tModule " + code);
        System.out.print(" " + title);

        if(isComplete())
        {
            System.out.println(" mark = " + mark);
        }
        else
        {
            System.out.println(" is not completed yet!");
        }    
    }
}
