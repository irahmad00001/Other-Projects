import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandling {

    //This Method re-reads the information from the file
    public ArrayList<Student> overReading(){
        ArrayList<Student> students = new ArrayList<Student>();
        String st = "";

        //Read the file and save it in a String
        //"try" and "catch" report error

        try{
            File file = new File("Save.txt");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                st = st + "\n"+ myReader.nextLine();
            }
            myReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("!!!ERROR---File Not Available---ERROR!!!");
            return null;
        }

        //Split Students
        try {
            //Isolation of additional symbols
            String tmp = st.replace("_", "");
            tmp = tmp.replace(" ", "");
            tmp = tmp.replace("\t", "");

            //String separation based on "#" for each Student
            String[] tmpString0 = tmp.split("#");

            for (int i = 1; i < tmpString0.length; i++) {
                Student tempStudent = new Student();
                int a0 = 0, b0 = 0, tempInt0 = 0;

                //Set Student ID
                a0 = tmpString0[i].indexOf("StudentID:") + 10;
                b0 = tmpString0[i].indexOf("\n", a0);
                tempInt0 = Integer.parseInt(tmpString0[i].substring(a0, b0));
                tempStudent.setId(tempInt0);

                //Set Student Name
                a0 = tmpString0[i].indexOf("StudentName:") + 12;
                b0 = tmpString0[i].indexOf("\n", a0);
                tempStudent.setName(tmpString0[i].substring(a0, b0));

                //Finding Number Of Course
                a0 = tmpString0[i].indexOf("StudentNumberOfCourse:") + 22;
                b0 = tmpString0[i].indexOf("\n", a0);

                //String separation based on "$" for courses
                String[] tmpString2 = tmpString0[i].substring(b0 + 17).split("%");
                //Add Courses in tempStudent
                if(Integer.parseInt(tmpString0[i].substring(a0, b0)) >= 1 ) {
                    for (int j = 1; j <= Integer.parseInt(tmpString0[i].substring(a0, b0)); j++) {
                        Course tempCourse = new Course();
                        int a1 = 0, b1 = 0, tempInt1 = 0;
                        float tempFlout = 0;

                        //Split Course ID And Add Course ID
                        a1 = tmpString2[j].indexOf("CourseID:") + 9;
                        b1 = tmpString2[j].indexOf("\n", a1);
                        tempInt1 = Integer.parseInt(tmpString2[j].substring(a1, b1));
                        tempCourse.setId(tempInt1);

                        //Split Course Name And Add Course Name
                        a1 = tmpString2[j].indexOf("CourseName:") + 11;
                        b1 = tmpString2[j].indexOf("\n", a1);
                        tempCourse.setName(tmpString2[j].substring(a1, b1));

                        //Split Course Credit And Add Course Credit
                        a1 = tmpString2[j].indexOf("CourseCredit:") + 13;
                        b1 = tmpString2[j].indexOf("\n", a1);
                        tempInt1 = Integer.parseInt(tmpString2[j].substring(a1, b1));
                        tempCourse.setCredit(tempInt1);

                        //Split Course Score And Add Course Score
                        a1 = tmpString2[j].indexOf("CourseScore:") + 12;
                        b1 = tmpString2[j].indexOf("\n", a1);
                        tempFlout = Float.parseFloat(tmpString2[j].substring(a1, b1));
                        tempCourse.setScore(tempFlout);

                        //Add tempCourse to tempStudent
                        tempStudent.addCourse(tempCourse);
                    }
                }
                //Add tempStudent to ArrayList Students
                students.add(tempStudent);
            }
        }
        catch (Exception e){
            System.out.println("!!!ERROR---The File Has A Problem---ERROR!!!");
            return null;
        }
        return students;
    }

    //This Method stores an array of students in the File
    public void writeInFile(ArrayList<String> st){

        try {
            File file1 = new File("Save.txt");
            if(file1.exists()){
                FileWriter f1 = new FileWriter("Save.txt");
                for(int i=0 ; i < st.size() ; i++) {
                    f1.write(st.get(i)+"\n");
                }
                f1.close();
            }
            else {
                file1.createNewFile();
                FileWriter f1 = new FileWriter("Save.txt");
                for(int i=0 ; i < st.size() ; i++) {
                    f1.write(st.get(i)+"\n");
                }
                f1.close();
            }
        }
        catch (IOException e){
            System.out.println("!!!ERROR---Difficulty writing files---ERROR!!!");
        }
    }
}