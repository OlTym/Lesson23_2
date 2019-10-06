package Service;

import Model.Group;
import Model.Student;

import java.util.Map;

public interface Service {

    void addGroup(Group group);

    void addStudent(Student student);

    Map<String, Integer> getStudentsByGroup(String groupName);

    Map<String, String> getGroupByStudent(String studentName);


}
