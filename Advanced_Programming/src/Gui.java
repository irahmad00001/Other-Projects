import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Gui implements ActionListener {

    private  ArrayList<Student> stArray;
    private int count = 0, countCourse = 0;
    private  JButton first, previous, next, last, add, delete, edit, list, sort, avarage, search, save, load, getAvarage, courseList, editCourse, picture, add_SaveButton, add_DontSaveButton, edit_Save, editCourses_next, editCourses_previous, editCourses_Delete, editCourses_Edit, editCourses_Add, editCourses_Save, editCourses_DontSave ,findBotton;

    private  JLabel idLabel, nameLabel, add_IDLabel, add_NameLabel, add_URLLabel, editCourses_IDLabel, editCourses_nameLabel, editCourses_creditLabel, editCourses_scoreLabel;
    private  JTextField idField, nameField, add_NameField, add_IDField, add_URLField, editCourses_IDField, editCourses_nameField, editCourses_creditField,
            editCourses_scoreField ,avarageField,totalAvarageField ,searchField;
    private JFrame addForm, editCoursesForm, listFormStudents , searchFrame;
    private JTable studentsTable;
    private FileHandling fh = new FileHandling();

    Gui(ArrayList<Student> studentArrayList) {
        stArray = studentArrayList;

        JFrame mainForm = new JFrame();
        addForm = new JFrame();
        editCoursesForm = new JFrame();
        listFormStudents = new JFrame();
        searchFrame = new JFrame();
        mainForm.setSize(765, 450);
        addForm.setSize(400, 200);
        editCoursesForm.setSize(400, 260);
        listFormStudents.setSize(400, 260);
        searchFrame.setSize(400, 200);

        if (stArray.isEmpty() == false) {
            first = new JButton("<< First");
            previous = new JButton("< Previous");
            next = new JButton("Next >");
            last = new JButton("Last >>");
            add = new JButton("Add");
            delete = new JButton("Delete");
            edit = new JButton("Edit");
            list = new JButton("List");
            sort = new JButton("Sort");
            avarage = new JButton("Avarage");
            search = new JButton("Search");
            save = new JButton("Save");
            load = new JButton("Load");
            getAvarage = new JButton("Get Avarage");
            courseList = new JButton("Course List");
            editCourse = new JButton("Edit Courses");
            edit_Save = new JButton("Save Edit");
            picture = new JButton(stArray.get(count).getIcon());
            idLabel = new JLabel("ID :");
            idField = new JTextField(Integer.toString(stArray.get(count).getId()));
            nameLabel = new JLabel("Name :");
            nameField = new JTextField(stArray.get(count).getName());
            if(stArray.get(count).getCourseList().isEmpty() == false)
            avarageField = new JTextField();
            totalAvarageField = new JTextField();
        } else {
            first = new JButton("<< First");
            first.setEnabled(false);
            previous = new JButton("< Previous");
            previous.setEnabled(false);
            next = new JButton("Next >");
            next.setEnabled(false);
            last = new JButton("Last >>");
            last.setEnabled(false);
            add = new JButton("Add");
            delete = new JButton("Delete");
            delete.setEnabled(false);
            edit = new JButton("Edit");
            edit.setEnabled(false);
            list = new JButton("List");
            list.setEnabled(false);
            sort = new JButton("Sort");
            sort.setEnabled(false);
            avarage = new JButton("Avarage");
            avarage.setEnabled(false);
            search = new JButton("Search");
            search.setEnabled(false);
            save = new JButton("Save");
            load = new JButton("Load");
            getAvarage = new JButton("Get Avarage");
            getAvarage.setEnabled(false);
            courseList = new JButton("Course List");
            courseList.setEnabled(false);
            editCourse = new JButton("Edit Courses");
            editCourse.setEnabled(false);
            edit_Save = new JButton("Save Edit");
            picture = new JButton();
            idLabel = new JLabel("ID :");
            idField = new JTextField();
            nameLabel = new JLabel("Name :");
            nameField = new JTextField();
            avarageField = new JTextField();
            totalAvarageField = new JTextField();
        }
        first.setBounds(67, 330, 95, 30);
        previous.setBounds(172, 330, 95, 30);
        next.setBounds(278, 330, 95, 30);
        last.setBounds(383, 330, 95, 30);
        add.setBounds(488, 330, 95, 30);
        delete.setBounds(593, 330, 95, 30);
        edit.setBounds(10, 370, 95, 30);
        list.setBounds(115, 370, 95, 30);
        sort.setBounds(220, 370, 95, 30);
        getAvarage.setBounds(60, 115, 130, 30);
        avarage.setBounds(325, 370, 95, 30);
        search.setBounds(430, 370, 95, 30);
        save.setBounds(535, 370, 95, 30);
        load.setBounds(640, 370, 95, 30);
        courseList.setBounds(60, 155, 130, 30);
        editCourse.setBounds(60, 195, 130, 30);
        edit_Save.setBounds(205, 15, 95, 30);
        picture.setBounds(500, 10, 225, 300);
        idLabel.setBounds(10, 10, 40, 40);
        idField.setBounds(60, 15, 130, 30);
        nameLabel.setBounds(10, 60, 40, 40);
        nameField.setBounds(60, 65, 130, 30);
        avarageField.setBounds(200,115 ,30,30);
        totalAvarageField.setBounds(240, 115, 30, 30);


        //add
        add_SaveButton = new JButton("Save");
        add_SaveButton.setBounds(280, 15, 95, 30);
        add_DontSaveButton = new JButton("Don't Save");
        add_DontSaveButton.setBounds(280, 65, 95, 30);
        add_URLLabel = new JLabel("URL :");
        add_URLLabel.setBounds(10, 110, 40, 40);
        add_IDLabel = new JLabel("ID :");
        add_IDLabel.setBounds(10, 10, 40, 40);
        add_NameLabel = new JLabel("Name :");
        add_NameLabel.setBounds(10, 60, 40, 40);
        add_IDField = new JTextField();
        add_IDField.setBounds(60, 15, 200, 30);
        add_NameField = new JTextField();
        add_NameField.setBounds(60, 65, 200, 30);
        add_URLField = new JTextField();
        add_URLField.setBounds(60, 115, 200, 30);

        //editCourses
        editCourses_previous = new JButton("< Previous");
        editCourses_previous.setBounds(10, 175, 95, 30);
        editCourses_next = new JButton("Next >");
        editCourses_next.setBounds(120, 175, 95, 30);
        editCourses_Add = new JButton("Add");
        editCourses_Add.setBounds(255, 10, 95, 30);
        editCourses_Delete = new JButton("Delete");
        editCourses_Delete.setBounds(255, 50, 95, 30);
        editCourses_Edit = new JButton("Edit");
        editCourses_Edit.setBounds(255, 90, 95, 30);
        editCourses_Save = new JButton("Save");
        editCourses_Save.setBounds(255, 130, 95, 30);
        editCourses_DontSave = new JButton("Don't Save");
        editCourses_DontSave.setBounds(255, 175, 95, 30);
        editCourses_IDLabel = new JLabel("Course ID :");
        editCourses_IDLabel.setBounds(10, 5, 70, 40);
        editCourses_nameLabel = new JLabel("Course Name :");
        editCourses_nameLabel.setBounds(10, 45, 85, 40);
        editCourses_creditLabel = new JLabel("Course Credit :");
        editCourses_creditLabel.setBounds(10, 85, 90, 40);
        editCourses_scoreLabel = new JLabel("Course Score :");
        editCourses_scoreLabel.setBounds(10, 125, 90, 40);

        //search Filed
        searchField = new JTextField();
        searchField.setBounds(10,10,130,30);
        findBotton = new JButton("Find");
        findBotton.setBounds(150, 10, 90, 30);



        if (stArray.isEmpty() == false) {
            if (stArray.get(count).getCourseList().isEmpty() == false) {
                String tmp0;
                tmp0 = String.valueOf(stArray.get(count).getCourseList().get(countCourse).getId());
                editCourses_IDField = new JTextField(tmp0);
                tmp0 = stArray.get(count).getCourseList().get(countCourse).getName();
                editCourses_nameField = new JTextField(tmp0);
                tmp0 = String.valueOf(stArray.get(count).getCourseList().get(countCourse).getCredit());
                editCourses_creditField = new JTextField(tmp0);
                tmp0 = String.valueOf(stArray.get(count).getCourseList().get(countCourse).getScore());
                editCourses_scoreField = new JTextField(tmp0);
            } else {
                editCourses_previous.setEnabled(false);
                editCourses_next.setEnabled(false);
                editCourses_Delete.setEnabled(false);
                editCourses_Edit.setEnabled(false);
                editCourses_IDField = new JTextField();
                editCourses_nameField = new JTextField();
                editCourses_creditField = new JTextField();
                editCourses_scoreField = new JTextField();
            }
        } else {
            editCourses_previous.setEnabled(false);
            editCourses_next.setEnabled(false);
            editCourses_Delete.setEnabled(false);
            editCourses_Edit.setEnabled(false);
            editCourses_IDField = new JTextField();
            editCourses_nameField = new JTextField();
            editCourses_creditField = new JTextField();
            editCourses_scoreField = new JTextField();
        }
        editCourses_IDField.setBounds(115, 10, 130, 30);
        editCourses_nameField.setBounds(115, 50, 130, 30);
        editCourses_creditField.setBounds(115, 90, 130, 30);
        editCourses_scoreField.setBounds(115, 130, 130, 30);


        mainForm.add(first);
        mainForm.add(previous);
        mainForm.add(next);
        mainForm.add(last);
        mainForm.add(add);
        mainForm.add(delete);
        mainForm.add(edit);
        mainForm.add(picture);
        mainForm.add(list);
        mainForm.add(sort);
        mainForm.add(avarage);
        mainForm.add(search);
        mainForm.add(save);
        mainForm.add(load);
        mainForm.add(edit_Save);
        mainForm.add(getAvarage);
        mainForm.add(courseList);
        mainForm.add(editCourse);
        mainForm.add(idLabel);
        mainForm.add(idField);
        mainForm.add(nameLabel);
        mainForm.add(nameField);
        mainForm.add(avarageField);
        mainForm.add(totalAvarageField);


        nameField.setEditable(false);
        idField.setEditable(false);
        editCourses_IDField.setEditable(false);
        editCourses_nameField.setEditable(false);
        editCourses_creditField.setEditable(false);
        editCourses_scoreField.setEditable(false);
        editCourses_DontSave.setEnabled(false);
        editCourses_Save.setEnabled(false);
        editCourse.setEnabled(false);
        edit_Save.setVisible(false);
        avarageField.setVisible(false);
        totalAvarageField.setVisible(false);
        edit_Save.setLayout(null);
        editCoursesForm.setLayout(null);
        searchFrame.setLayout(null);
        mainForm.setLayout(null);
        searchFrame.setVisible(false);
        mainForm.setVisible(true);
        listFormStudents.setVisible(false);


        //add
        addForm.add(add_IDField);
        addForm.add(add_NameField);
        addForm.add(add_URLField);
        addForm.add(add_SaveButton);
        addForm.add(add_DontSaveButton);
        addForm.add(add_URLLabel);
        addForm.add(add_IDLabel);
        addForm.add(add_NameLabel);


        //editCourses
        editCoursesForm.add(editCourses_next);
        editCoursesForm.add(editCourses_previous);
        editCoursesForm.add(editCourses_Add);
        editCoursesForm.add(editCourses_Delete);
        editCoursesForm.add(editCourses_Edit);
        editCoursesForm.add(editCourses_Save);
        editCoursesForm.add(editCourses_IDLabel);
        editCoursesForm.add(editCourses_nameLabel);
        editCoursesForm.add(editCourses_creditLabel);
        editCoursesForm.add(editCourses_scoreLabel);
        editCoursesForm.add(editCourses_IDField);
        editCoursesForm.add(editCourses_nameField);
        editCoursesForm.add(editCourses_creditField);
        editCoursesForm.add(editCourses_scoreField);
        editCoursesForm.add(editCourses_DontSave);



        //search Frame
        searchFrame.add(findBotton);
        searchFrame.add(searchField);


        first.addActionListener(this);
        previous.addActionListener(this);
        next.addActionListener(this);
        last.addActionListener(this);
        add.addActionListener(this);
        add_SaveButton.addActionListener(this);
        add_DontSaveButton.addActionListener(this);
        delete.addActionListener(this);
        edit.addActionListener(this);
        editCourse.addActionListener(this);
        editCourses_next.addActionListener(this);
        editCourses_previous.addActionListener(this);
        editCourses_Add.addActionListener(this);
        editCourses_Edit.addActionListener(this);
        editCourses_Save.addActionListener(this);
        editCourses_Delete.addActionListener(this);
        editCourses_DontSave.addActionListener(this);
        edit_Save.addActionListener(this);
        courseList.addActionListener(this);
        getAvarage.addActionListener(this);
        list.addActionListener(this);
        sort.addActionListener(this);
        save.addActionListener(this);
        load.addActionListener(this);
        avarage.addActionListener(this);
        search.addActionListener(this);
        findBotton.addActionListener(this);
        mainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == first) {
            if (count != 0) {
                count = 0;
                idField.setText(Integer.toString(stArray.get(count).getId()));
                nameField.setText(stArray.get(count).getName());
                picture.setIcon(stArray.get(count).getIcon());
                avarageField.setVisible(false);
                totalAvarageField.setVisible(false);
            }
        }


        if (e.getSource() == previous) {
            if (count != 0) {
                count--;
                idField.setText(Integer.toString(stArray.get(count).getId()));
                nameField.setText(stArray.get(count).getName());
                picture.setIcon(stArray.get(count).getIcon());
                avarageField.setVisible(false);
                totalAvarageField.setVisible(false);

            }
        }


        if (e.getSource() == next) {
            if (stArray.size() - 1 > count) {
                count++;
                idField.setText(Integer.toString(stArray.get(count).getId()));
                nameField.setText(stArray.get(count).getName());
                picture.setIcon(stArray.get(count).getIcon());
                avarageField.setVisible(false);
                totalAvarageField.setVisible(false);
            }
        }


        if (e.getSource() == last) {
            if (count != stArray.size() - 1) {
                count = stArray.size() - 1;
                idField.setText(Integer.toString(stArray.get(count).getId()));
                nameField.setText(stArray.get(count).getName());
                picture.setIcon(stArray.get(count).getIcon());
                avarageField.setVisible(false);
                totalAvarageField.setVisible(false);
            }
        }


        if (e.getSource() == add) {
            addForm.setVisible(true);
            addForm.setLayout(null);
            avarageField.setVisible(false);
            totalAvarageField.setVisible(false);
        }


        if (e.getSource() == add_SaveButton) {
            Student tmpStudent = new Student();
            ImageIcon tmpIcon = new ImageIcon(add_URLField.getText());
            tmpStudent.setIcon(tmpIcon);
            tmpStudent.setName(add_NameField.getText());
            tmpStudent.setId(Integer.parseInt(add_IDField.getText()));
            stArray.add(tmpStudent);
            count = stArray.size() - 1;
            idField.setText(Integer.toString(stArray.get(count).getId()));
            nameField.setText(stArray.get(count).getName());
            picture.setIcon(stArray.get(count).getIcon());
            add_IDField.setText("");
            add_NameField.setText("");
            add_URLField.setText("");
            addForm.setVisible(false);
            getAvarage.setEnabled(true);
            courseList.setEnabled(true);
            first.setEnabled(true);
            previous.setEnabled(true);
            next.setEnabled(true);
            last.setEnabled(true);
            delete.setEnabled(true);
            edit.setEnabled(true);
            list.setEnabled(true);
            sort.setEnabled(true);
            avarage.setEnabled(true);
            search.setEnabled(true);
        }


        if (e.getSource() == add_DontSaveButton) {
            add_IDField.setText("");
            add_NameField.setText("");
            add_URLField.setText("");
            addForm.setVisible(false);
        }


        if (e.getSource() == delete) {
            if (count != 0) {
                stArray.remove(count);
                count--;
                idField.setText(Integer.toString(stArray.get(count).getId()));
                nameField.setText(stArray.get(count).getName());
                picture.setIcon(stArray.get(count).getIcon());
                avarageField.setVisible(false);
                totalAvarageField.setVisible(false);
            }
            if (count == 0) {
                stArray.remove(count);
                if (stArray.isEmpty() == true) {
                    idField.setText(null);
                    nameField.setText(null);
                    picture.setIcon(null);
                    getAvarage.setEnabled(false);
                    courseList.setEnabled(false);
                    first.setEnabled(false);
                    previous.setEnabled(false);
                    next.setEnabled(false);
                    last.setEnabled(false);
                    delete.setEnabled(false);
                    edit.setEnabled(false);
                    list.setEnabled(false);
                    sort.setEnabled(false);
                    avarage.setEnabled(false);
                    search.setEnabled(false);
                    avarageField.setVisible(false);
                    totalAvarageField.setVisible(false);
                } else {
                    idField.setText(Integer.toString(stArray.get(count).getId()));
                    nameField.setText(stArray.get(count).getName());
                    picture.setIcon(stArray.get(count).getIcon());
                    avarageField.setVisible(false);
                    totalAvarageField.setVisible(false);
                }
            }
        }


        if (e.getSource() == edit) {
            nameField.setEditable(true);
            idField.setEditable(true);
            editCourse.setEnabled(true);
            first.setEnabled(false);
            previous.setEnabled(false);
            next.setEnabled(false);
            last.setEnabled(false);
            add.setEnabled(false);
            edit.setEnabled(false);
            list.setEnabled(false);
            sort.setEnabled(false);
            avarage.setEnabled(false);
            search.setEnabled(false);
            save.setEnabled(false);
            load.setEnabled(false);
            getAvarage.setEnabled(false);
            courseList.setEnabled(false);
            delete.setEnabled(false);
            edit_Save.setVisible(true);
            avarageField.setVisible(false);
            totalAvarageField.setVisible(false);
        }


        if (e.getSource() == editCourse) {
            editCoursesForm.setVisible(true);
            editCoursesForm.setVisible(true);
            editCourses_DontSave.setVisible(true);
            editCourses_Save.setVisible(true);
            editCourses_Add.setVisible(true);
            editCourses_Delete.setVisible(true);
            editCourses_Edit.setVisible(true);
            avarageField.setVisible(false);
            totalAvarageField.setVisible(false);
        }


        if (editCoursesForm.isActive() == false) {
            if (stArray.isEmpty() == false)
                if (stArray.get(count).getCourseList().isEmpty() == true) {
                    editCourses_IDField.setText(null);
                    editCourses_nameField.setText(null);
                    editCourses_creditField.setText(null);
                    editCourses_scoreField.setText(null);
                } else {
                    editCourses_IDField.setText(String.valueOf(stArray.get(count).getCourseList().get(countCourse).getId()));
                    editCourses_nameField.setText(stArray.get(count).getCourseList().get(countCourse).getName());
                    editCourses_creditField.setText(String.valueOf(stArray.get(count).getCourseList().get(countCourse).getCredit()));
                    editCourses_scoreField.setText(String.valueOf(stArray.get(count).getCourseList().get(countCourse).getScore()));
                }
        }


        if (e.getSource() == editCourses_next) {
            if (stArray.get(count).getCourseList().size() - 1 > countCourse) {
                countCourse++;
                editCourses_IDField.setText(String.valueOf(stArray.get(count).getCourseList().get(countCourse).getId()));
                editCourses_nameField.setText(stArray.get(count).getCourseList().get(countCourse).getName());
                editCourses_creditField.setText(String.valueOf(stArray.get(count).getCourseList().get(countCourse).getCredit()));
                editCourses_scoreField.setText(String.valueOf(stArray.get(count).getCourseList().get(countCourse).getScore()));
            }
        }


        if (e.getSource() == editCourses_previous) {
            if (countCourse != 0) {
                countCourse--;
                editCourses_IDField.setText(String.valueOf(stArray.get(count).getCourseList().get(countCourse).getId()));
                editCourses_nameField.setText(stArray.get(count).getCourseList().get(countCourse).getName());
                editCourses_creditField.setText(String.valueOf(stArray.get(count).getCourseList().get(countCourse).getCredit()));
                editCourses_scoreField.setText(String.valueOf(stArray.get(count).getCourseList().get(countCourse).getScore()));
            }
        }


        if (e.getSource() == editCourses_Add) {
            Course tmpCourse0 = new Course();
            stArray.get(count).addCourse(tmpCourse0);
            countCourse = stArray.get(count).getCourseList().size() - 1;
            editCourses_IDField.setText(String.valueOf(stArray.get(count).getCourseList().get(countCourse).getId()));
            editCourses_nameField.setText(stArray.get(count).getCourseList().get(countCourse).getName());
            editCourses_creditField.setText(String.valueOf(stArray.get(count).getCourseList().get(countCourse).getCredit()));
            editCourses_scoreField.setText(String.valueOf(stArray.get(count).getCourseList().get(countCourse).getScore()));
            editCourses_IDField.setEditable(true);
            editCourses_nameField.setEditable(true);
            editCourses_creditField.setEditable(true);
            editCourses_scoreField.setEditable(true);
            editCourses_Delete.setEnabled(false);
            editCourses_Edit.setEnabled(false);
            editCourses_Save.setEnabled(true);
            editCourses_DontSave.setEnabled(true);
            editCourses_previous.setEnabled(false);
            editCourses_next.setEnabled(false);
            editCourses_Add.setEnabled(false);
        }


        if (e.getSource() == editCourses_Edit) {
            editCourses_IDField.setEditable(true);
            editCourses_nameField.setEditable(true);
            editCourses_creditField.setEditable(true);
            editCourses_scoreField.setEditable(true);
            editCourses_Delete.setEnabled(false);
            editCourses_Edit.setEnabled(false);
            editCourses_Save.setEnabled(true);
            editCourses_DontSave.setEnabled(true);
            editCourses_previous.setEnabled(false);
            editCourses_next.setEnabled(false);
            editCourses_Add.setEnabled(false);
        }


        if (e.getSource() == editCourses_Save) {
            editCourses_IDField.setEditable(false);
            editCourses_nameField.setEditable(false);
            editCourses_creditField.setEditable(false);
            editCourses_scoreField.setEditable(false);
            editCourses_Delete.setEnabled(true);
            editCourses_Edit.setEnabled(true);
            editCourses_Save.setEnabled(false);
            editCourses_DontSave.setEnabled(false);
            editCourses_previous.setEnabled(true);
            editCourses_next.setEnabled(true);
            editCourses_Add.setEnabled(true);
            stArray.get(count).getCourseList().get(countCourse).setId(Integer.parseInt(editCourses_IDField.getText()));
            stArray.get(count).getCourseList().get(countCourse).setName(editCourses_nameField.getText());
            stArray.get(count).getCourseList().get(countCourse).setCredit(Integer.parseInt(editCourses_creditField.getText()));
            stArray.get(count).getCourseList().get(countCourse).setScore(Float.parseFloat(editCourses_scoreField.getText()));
        }


        if (e.getSource() == editCourses_DontSave) {
            editCourses_IDField.setEditable(false);
            editCourses_nameField.setEditable(false);
            editCourses_creditField.setEditable(false);
            editCourses_scoreField.setEditable(false);
            if (stArray.get(count).getCourseList().get(stArray.get(count).getCourseList().size() - 1).getName() == null) {
                stArray.get(count).getCourseList().remove(stArray.get(count).getCourseList().size() - 1);
            }
            if (stArray.get(count).getCourseList().isEmpty() == false) {
                editCourses_Delete.setEnabled(true);
                editCourses_Edit.setEnabled(true);
                editCourses_Save.setEnabled(false);
                editCourses_DontSave.setEnabled(false);
                editCourses_previous.setEnabled(true);
                editCourses_next.setEnabled(true);
                editCourses_Add.setEnabled(true);
                countCourse = 0;
                editCourses_IDField.setText(String.valueOf(stArray.get(count).getCourseList().get(countCourse).getId()));
                editCourses_nameField.setText(stArray.get(count).getCourseList().get(countCourse).getName());
                editCourses_creditField.setText(String.valueOf(stArray.get(count).getCourseList().get(countCourse).getCredit()));
                editCourses_scoreField.setText(String.valueOf(stArray.get(count).getCourseList().get(countCourse).getScore()));
            } else {
                editCourses_Add.setEnabled(true);
                editCourses_Save.setEnabled(false);
                editCourses_DontSave.setEnabled(false);
                editCourses_IDField.setText("");
                editCourses_nameField.setText("");
                editCourses_creditField.setText("");
                editCourses_scoreField.setText("");
            }
        }


        if (e.getSource() == editCourses_Delete) {
            if (countCourse != 0) {
                stArray.get(count).deleteCourse(stArray.get(count).getCourseList().get(countCourse).getId());
                countCourse--;
                editCourses_IDField.setText(String.valueOf(stArray.get(count).getCourseList().get(countCourse).getId()));
                editCourses_nameField.setText(stArray.get(count).getCourseList().get(countCourse).getName());
                editCourses_creditField.setText(String.valueOf(stArray.get(count).getCourseList().get(countCourse).getCredit()));
                editCourses_scoreField.setText(String.valueOf(stArray.get(count).getCourseList().get(countCourse).getScore()));
            }
            if (countCourse == 0 && stArray.get(count).getCourseList().isEmpty() == false) {
                stArray.get(count).deleteCourse(stArray.get(count).getCourseList().get(countCourse).getId());
                if (stArray.get(count).getCourseList().isEmpty() == true) {
                    editCourses_IDField.setText(null);
                    editCourses_nameField.setText(null);
                    editCourses_creditField.setText(null);
                    editCourses_scoreField.setText(null);
                    editCourses_Delete.setEnabled(false);
                    editCourses_Edit.setEnabled(false);
                    editCourses_next.setEnabled(false);
                    editCourses_previous.setEnabled(false);
                    editCourses_Save.setEnabled(false);
                } else {
                    editCourses_IDField.setText(String.valueOf(stArray.get(count).getCourseList().get(countCourse).getId()));
                    editCourses_nameField.setText(stArray.get(count).getCourseList().get(countCourse).getName());
                    editCourses_creditField.setText(String.valueOf(stArray.get(count).getCourseList().get(countCourse).getCredit()));
                    editCourses_scoreField.setText(String.valueOf(stArray.get(count).getCourseList().get(countCourse).getScore()));
                }
            }
        }


        if (e.getSource() == edit_Save) {
            nameField.setEditable(false);
            idField.setEditable(false);
            editCourse.setEnabled(false);
            first.setEnabled(true);
            previous.setEnabled(true);
            next.setEnabled(true);
            last.setEnabled(true);
            add.setEnabled(true);
            edit.setEnabled(true);
            list.setEnabled(true);
            sort.setEnabled(true);
            avarage.setEnabled(true);
            search.setEnabled(true);
            save.setEnabled(true);
            load.setEnabled(true);
            getAvarage.setEnabled(true);
            courseList.setEnabled(true);
            delete.setEnabled(true);
            edit_Save.setVisible(false);
            stArray.get(count).setName(nameField.getText());
            stArray.get(count).setId(Integer.parseInt(idField.getText()));
        }
        if (e.getSource() == courseList) {
            editCoursesForm.setVisible(true);
            editCourses_DontSave.setVisible(false);
            editCourses_Save.setVisible(false);
            editCourses_Add.setVisible(false);
            editCourses_Delete.setVisible(false);
            editCourses_Edit.setVisible(false);
        }
        if(e.getSource() == getAvarage){
            avarageField.setText(String.valueOf(stArray.get(count).average()));
            if(stArray.get(count).average() >= 17) {
                avarageField.setBackground(Color.GREEN);
            }
            if(stArray.get(count).average() < 10){
                avarageField.setBackground(Color.RED);
            }
            avarageField.setVisible(true);
        }
        if(e.getSource() == list){
            String tmp1[][] = new String[stArray.size()][3];
            for(int i =0 ; i < stArray.size(); i++){
                tmp1[i][0] = String.valueOf(stArray.get(i).getId());
                tmp1[i][1] = stArray.get(i).getName();
                tmp1[i][2] = String.valueOf(stArray.get(i).average());
            }
            studentsTable = new JTable(tmp1, new String[]{"ID :", "Name :" ,"Avarage :" });
            JScrollPane tmp =new JScrollPane(studentsTable);
            listFormStudents.add(tmp);
            listFormStudents.setVisible(true);
        }
        if(e.getSource() == sort){
            Collections.sort(stArray,Comparator.comparing(Student::average));
            count = 0;
            idField.setText(Integer.toString(stArray.get(count).getId()));
            nameField.setText(stArray.get(count).getName());
            picture.setIcon(stArray.get(count).getIcon());
        }



        if(e.getSource() == save){
            ArrayList<String> tmp0 = new ArrayList<>();
            for(int i = 0 ; i < stArray.size() ; i++){
                String tmp ="________________________________________________________________________________________________________________________\n"+
                        "#Student "+Integer.toString(i) +":\n"+stArray.get(i).toString();
                tmp0.add(tmp);
            }
            fh.writeInFile(tmp0);
        }


        if(e.getSource() == load){
            stArray = fh.overReading();
            count = 0;
            idField.setText(Integer.toString(stArray.get(count).getId()));
            nameField.setText(stArray.get(count).getName());
            picture.setIcon(stArray.get(count).getIcon());
            getAvarage.setEnabled(true);
            courseList.setEnabled(true);
            first.setEnabled(true);
            previous.setEnabled(true);
            next.setEnabled(true);
            last.setEnabled(true);
            delete.setEnabled(true);
            edit.setEnabled(true);
            list.setEnabled(true);
            sort.setEnabled(true);
            avarage.setEnabled(true);
            search.setEnabled(true);
        }


        if(e.getSource() == avarage){
            float total = 0;
            for(int i = 0;i < stArray.size();i++ ){
                total = total + stArray.get(i).average();
            }
            total = total / stArray.size();
            if(total >= 17) {
                totalAvarageField.setBackground(Color.GREEN);
            }
            if(stArray.get(count).average() < 10){
                totalAvarageField.setBackground(Color.RED);
            }
            totalAvarageField.setText(String.valueOf(total));
            totalAvarageField.setVisible(true);
        }
        if(e.getSource() == search){
            searchFrame.setVisible(true);
        }
        if(e.getSource() == findBotton){
            int id = Integer.parseInt(searchField.getText());
            for(int i = 0 ; i < stArray.size() ; i++){
                if(stArray.get(i).getId() == id){
                    count = i;
                    idField.setText(Integer.toString(stArray.get(count).getId()));
                    nameField.setText(stArray.get(count).getName());
                    picture.setIcon(stArray.get(count).getIcon());
                }
            }
            searchFrame.setVisible(false);
        }
    }
}
