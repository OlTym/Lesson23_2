package Service;


import Dao.Dao;
import Dao.DaoEntity;
import Model.Group;
import Model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceEntity implements Service {

    @Override
    public void addGroup(Group group) {

        Dao dao = new DaoEntity();
        dao.creatGroup(group);
    }

    @Override
    public void addStudent(Student student) {

        Dao dao = new DaoEntity();
        dao.creatStudent(student);
    }

    @Override
    public Map<String, Integer> getStudentsByGroup(String groupName) {

        Map<String, Integer> map = null;
        Dao dao = new DaoEntity();
        Group group = dao.getGroupByName(groupName);

        if (group != null) {
            List<?> list = dao.getStudentByGroup(group);
            map = new HashMap<>();
            for (int i = 0; i < list.size(); i++) {
                Object[] row = (Object[]) list.get(i);
                map.put((String) row[0], (int) row[1]);
            }

        }
        return map;
    }

    @Override
    public Map<String, String> getGroupByStudent(String studentName) {

        Map<String, String> map = null;
        Dao dao = new DaoEntity();

        Student student = dao.getStudentByName(studentName);

        if (student != null) {
            map = new HashMap<>();

            List<?> list = dao.getGroupByStudent(student);
            for (int i = 0; i < list.size(); i++) {
                Object[] row = (Object[]) list.get(i);
                map.put((String) row[0], (String) row[1]);
            }

        }
        return map;
    }


}
