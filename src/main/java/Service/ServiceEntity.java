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
    public Map<String, Integer> getStudentsByGroup(Group group) {
        Dao dao = new DaoEntity();
        List<?> list = dao.getStudentByGroup(group);

        Map<String, Integer> map = new HashMap<>();


        for (int i = 0; i < list.size(); i++) {
            Object[] row = (Object[]) list.get(i);
            map.put((String) row[0], (int) row[1]);

        }
        return map;
    }

    @Override
    public Map<String, String> getGroupByStudent(Student student) {

        Dao dao = new DaoEntity();
        List<?> list = dao.getGroupByStudent(student);

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            Object[] row = (Object[]) list.get(i);
            map.put((String) row[0], (String) row[1]);

        }
        return map;
    }


}
