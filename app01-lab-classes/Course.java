
/**
 * Write a description of class Course here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Course
{
    private String codeNumber;
    private String title;

    /**
     * Constructor for objects of class Course
     */
    public Course(String codeNumber, String title)
    {
        this.codeNumber=codeNumber;
        this.title=title;
    }

    public void print()
    {
        System.out.println("CodeNumber: "+codeNumber+" Title: "+title);
    }
}
