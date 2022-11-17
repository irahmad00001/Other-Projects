import javax.swing.*;
import java.util.*;
import java.io.File;
//In this Class, student courses are stored

public class Student {

    //Create variables
    private int id;
    private String name;
    private String imageURL;
    private int number_of_course = 0;
    private ArrayList<Course> courseList = new ArrayList<Course>();
    private ImageIcon icon = new ImageIcon(imageURL);

    //Constructors
    public Student(int id, String name,ImageIcon icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }
    public Student(){
    }

    //Set and Get Methods
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setImageURL(String URL1) {
        this.imageURL = URL1;
    }
    public String getImageURL() {
        return this.imageURL;
    }

    public void setIcon(ImageIcon icon){
        this.icon = icon;
    }
    public ImageIcon getIcon(){
        return this.icon;
    }

    public ArrayList<Course> getCourseList() {return courseList;}
    public void setCourseList(ArrayList<Course> courseList) {this.courseList = courseList;}

    public void addCourse(Course c) {
        courseList.add(number_of_course,c);
        number_of_course++;
    }

    //With this Method you can add courses
    public void addCourse(int id, String name, int credit, float score) {
        Course temp = new Course();
        temp.setId(id);
        temp.setName(name);
        temp.setCredit(credit);
        temp.setScore(score);
        courseList.add(number_of_course,temp);
        number_of_course++;
    }

    //With this Method you can delete the course
    public void deleteCourse(int courseId) {
        courseList.removeIf(course ->course.getId() == courseId);
        number_of_course--;
    }

    //With this Method, you can get the average score for each student
    public float average() {
        float sum = 0,tmp = 0;
        for(int i = 0 ; i < courseList.size() ; i++){
            sum = sum + courseList.get(i).getScore() * (float) courseList.get(i).getCredit();
            tmp = tmp + (float) courseList.get(i).getCredit();
        }
        return sum / tmp;
    }

    @Override
    public String toString() {
        String st1 = "\tStudent ID:" + this.id +"\n\tStudent Name:" + this.name +
                "\n\tStudent Number Of Course:" + this.number_of_course + "\n\tStudent Courses:";
        for(int i =0 ;i < courseList.size() ; i++){
            st1 = st1 +"\n\t\t\t%Course "+Integer.toString(i)+":\n"+ courseList.get(i).toString()+"\n";
        }
        return st1;
    }
}