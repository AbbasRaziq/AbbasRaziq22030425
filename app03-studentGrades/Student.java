import java.util.*;

/**
 * This class is representing a student in a administration system.
 * It contains the student name, id, credits and course.
 * 
 * @author Abbas Raziq
 * @version 18/02/2021
 */
public class Student
{
    // the student's full name
    private String name;
    // the student ID
    private String id;
    // the amount of credits for study taken so far
    private int credits;
    //This links the student class to the course class.
    private Course course;

    /**
     * This is where the students name, id and credits are created.
     */
    public Student(String fullName, String studentID)
    {
        name = fullName;
        id = studentID;
        credits = 0;
    }

    /**
     * This will get the full name of the student.
     */
    public String getName()
    {
        return name;
    }

    /**
     * This will change the students name.
     */
    public void changeName(String replacementName)
    {
        name = replacementName;
    }

    /**
     * This will return the student id
     */
    public String getStudentID()
    {
        return id;
    }

    /**
     * Add some credit points to the student's accumulated credits.
     */
    public void addCredits(int additionalPoints)
    {
        credits += additionalPoints;
    }

    /**
     * Enrol the student on a course.
     */
    public void enrolOnCourse(Course course)
    {
        this.course = course;
    }

    /**
     * Return the number of credit points this student has accumulated.
     */
    public int getCredits()
    {
        return credits;
    }

    /**
     * Return the login name of this student. The login name is a combination
     * of the first four characters of the student's name and the first three
     * characters of the student's ID number.
     */
    public String getLoginName()
    {
        return name.substring(0,4) + id.substring(0,3);
    }

    /**
     * Print the student's name and ID number to the output terminal.
     */
    public void print()
    {
        System.out.println(name + ", student ID: " + id + ", credits: " + credits);
        course.print();
    }

    /**
     * This will print the grade achieved.
     */
    public void printCourse()
    {
        course.print();
        course.printGrade();
    }

}
