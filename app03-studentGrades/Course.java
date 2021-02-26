
/**
 * This class will store information about a course that may be completed by enrolled students.
 *
 * @author Abbas Raziq
 * @version 18/02/21
 */
public class Course
{
    public static final int MAX_MODULES = 4;

    private String codeNumber;
    private String title;

    private int numberofModules;
    private int totalCredits;
    private int totalMarks;
    private int meanMark;

    private boolean complete;

    private Module module1;
    private Module module2;
    private Module module3;
    private Module module4;

    /**
     * This constructor will be used for creating a course and define it by the
     * code number and title.
     */
    public Course(String codeNumber, String title)
    {
        this.codeNumber=codeNumber;
        this.title=title;

        numberofModules = 0;
        totalMarks = 0;
        totalCredits = 0;
        complete = false;
    }

    /**
     * Add a module and the number
     */
    public void addModule(int number, Module module)
    {
        if((number >= 1) & (number <= MAX_MODULES)) numberofModules++;

        switch(number)
        {
            case 1: module1 = module; break;
            case 2: module2 = module; break;
            case 3: module3 = module; break;
            case 4: module4 = module; break;
        }
    }

    /**
     * This will print the code number and title of the course
     */
    public void print()
    {
        //put your code here
        System.out.println("CodeNumber: "+codeNumber+" Title: "+title);
        System.out.println();

        printModules();
    }

    /**
     * Print out all the modules that are part of the course.
     */
    private void printModules()
    {
        if(module1 != null) module1.print();
        if(module2 != null) module2.print();
        if(module3 != null) module3.print();
        if(module4 != null) module4.print();
    }

    /**
     * Prints the final grade by calculating the mean mark and will display the final mark and if the course isn't completed yet.
     */
    public void printGrade()
    {
        if(numberofModules == MAX_MODULES)
        {
            totalMarks = 0;

            addMarks(module1);
            addMarks(module2);
            addMarks(module3);
            addMarks(module4);

            if(totalCredits == MAX_MODULES * Module.CREDIT)
            {
                System.out.println("Your final mark is " + meanMark + " your final grade is " + calculateGrade());
            }
            else
            {
                System.out.println("Your final grade is" + calculateGrade());
                System.out.println("Please complete the module.");
            }
        }
    }

    /**
     * Add marks to the module to see how many credits are rewarded.
     */
    private void addMarks(Module module)
    {
        if(module.isComplete())
        {
            totalMarks = totalMarks + module.getMark();
            totalCredits += module.CREDIT;
        }
    }

    /**
     * Calculate the mean mark to work out which grade is acheived. 
     */
    private String calculateGrade()
    {
        meanMark = totalMarks / MAX_MODULES;

        if(meanMark <= 40)
        {
            return "F";
        }
        else if(meanMark <= 50)
        {
            return "D";
        }
        else if(meanMark <= 60)
        {
            return "C";
        }
        else if(meanMark <= 70)
        {
            return "B";
        }
        else return "A";
    }

}
