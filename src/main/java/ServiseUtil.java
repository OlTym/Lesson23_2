import Model.Group;
import Model.Student;
import Service.Service;
import Service.ServiceEntity;

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


    public static String getStudentByGroup(Group group) {
        final StringBuilder sb = new StringBuilder();
        Service service = new ServiceEntity();
        Map<String, Integer> map = service.getStudentsByGroup(group);

        sb.append("Group " + group.getName()).append("\n");

        for (Map.Entry entry : map.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }
        return sb.toString();

    }

    public static String getGroupByStudent(Student student) {
        final StringBuilder sb = new StringBuilder();
        Service service = new ServiceEntity();
        Map<String, String> map = service.getGroupByStudent(student);

        sb.append(student.getName()).append(" group").append("\n");

        for (Map.Entry entry : map.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }
        return sb.toString();

    }


}
