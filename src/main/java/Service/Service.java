package Service;

import Model.Group;
import Model.Student;

import java.util.Map;

public interface Service {

    void addGroup(Group group);

    void addStudent(Student student);

    Map<String, Integer> getStudentsByGroup(Group group);

    Map<String, String> getGroupByStudent(Student student);


}
