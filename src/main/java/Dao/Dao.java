package Dao;

import Model.Group;
import Model.Student;

import java.util.List;

public interface Dao {

    void creatGroup(Group group);

    void creatStudent(Student student);

    List<?> getStudentByGroup(Group group);

    List<?> getGroupByStudent(Student student);

    Student getStudentByName(String nameStudent);

    Group getGroupByName(String nameGroup);


}
