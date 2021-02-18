
/**
 * This is where the code number and title of the course name will be created.
 *
 * @author (your name)
 * @version 12/02/21
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
