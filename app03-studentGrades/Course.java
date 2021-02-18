
/**
 * Write a description of class Course here.
 *
 * @author Abbas Raziq
 * @version 16/02/21
 */
public class Course
{
    private String codeNumber;
    private String title;

    /**
     * This constructor will be used for creating a course and define it by the
     * code number and title.
     */
    public Course(String codeNumber, String title)
    {
        this.codeNumber=codeNumber;
        this.title=title;
    }

    /**
     * This will print the code number and title of the module.
     */
    
    public void print()
    {
        System.out.println("CodeNumber: "+codeNumber+" Title: "+title);
    }
}
