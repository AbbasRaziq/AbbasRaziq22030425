import java.util.*;

/**
 * The LabClass is where students will be enrolled on certain course. This is
 * also where the students, the room and time where they will be and will show
 * the instructors name.
 * The students will be enrolled on here.
 * 
 * @author Abbas Raziq
 * @version 12/02/2021
 */
public class LabClass
{
    private String instructor;
    private String room;
    private String timeAndDay;
    
    private ArrayList<Student> students;
    private int capacity;
    
    /**
     * The max number of students in the course.
     */
    public LabClass(int maxNumberOfStudents)
    {
        instructor = "unknown";
        room = "unknown";
        timeAndDay = "unknown";
        
        students = new ArrayList<Student>();
        capacity = maxNumberOfStudents;
    }

    /**
     * Enrolling new students on to course.
     */
    public void enrollStudent(Student newStudent)
    {
        if(students.size() == capacity) 
        {
            System.out.println("The class is full, you cannot enrol.");
        }
        else 
        {
            students.add(newStudent);
        }
    }
    
    /**
     * Return the number of students currently enrolled in this LabClass.
     */
    public int numberOfStudents()
    {
        return students.size();
    }
    
    /**
     * Set the room number for this LabClass.
     */
    public void setRoom(String roomNumber)
    {
        room = roomNumber;
    }
    
    /**
     * Set the time for this LabClass. The parameter should define the day
     * and the time of day, such as "Friday, 10am".
     */
    public void setTime(String timeAndDayString)
    {
        timeAndDay = timeAndDayString;
    }
    
    /**
     * Where the instructor will be set.
     */
    public void setInstructor(String instructorName)
    {
        instructor = instructorName;
    }
    
    /**
     * This is where it would print all the information.
     */
    public void printList()
    {
        System.out.println("Lab class " + timeAndDay);
        System.out.println("Instructor: " + instructor + "   Room: " + room);
        System.out.println("Class list:");
        
        for(Student student : students) 
        {
            student.print();
        }
        
        System.out.println("Number of students: " + numberOfStudents());
    }
}
