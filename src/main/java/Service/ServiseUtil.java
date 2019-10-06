package Service;

import Model.Group;
import Model.Student;

import java.util.List;
import java.util.Map;


public class ServiseUtil {

    public static void creatGroup(List<Student> students, Group group) {

        Service service = new ServiceEntity();
        for (Student student : students) {
            student.setGroup(group);
            group.setStudents(student);

        }

    }

    public static void fillStudent(List<Student> students) {

        Service service = new ServiceEntity();
        for (Student student : students) {
            service.addStudent(student);
        }

    }


    public static void fillGroup(Group group) {
        Service service = new ServiceEntity();
        service.addGroup(group);
    }


    public static String getStudentByGroup(String groupName) {
        final StringBuilder sb = new StringBuilder();
        Service service = new ServiceEntity();
        Map<String, Integer> map = service.getStudentsByGroup(groupName);

        if (map != null) {
            sb.append("Group ").append(groupName).append("\n");

            for (Map.Entry entry : map.entrySet()) {
                sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
            }
        }
        return sb.toString();

    }

    public static String getGroupByStudent(String studentName) {
        final StringBuilder sb = new StringBuilder();
        Service service = new ServiceEntity();
        Map<String, String> map = service.getGroupByStudent(studentName);

        if (map != null) {
            sb.append("Student ").append(studentName).append("\n");

            for (Map.Entry entry : map.entrySet()) {
                sb.append("group ").append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
            }

        }
        return sb.toString();
    }


}
