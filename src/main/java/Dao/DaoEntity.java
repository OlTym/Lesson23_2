package Dao;

import Model.Group;
import Model.Student;
import Service.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DaoEntity implements Dao {


    @Override
    public void creatGroup(Group group) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(group);
            transaction.commit();
        }

    }

    @Override
    public void creatStudent(Student student) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        }


    }


    public List<?> getStudentByGroup(Group group) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createSQLQuery("Select t1.name, t1.age FROM students as t1 " +
                    "JOIN group_student as t2 on t1.id = t2.student_id " +
                    "JOIN groups as t3 on t2.group_id = t3.id " +
                    "where t3.name = :name")
                    .setParameter("name", group.getName())
                    .list();
        }

    }

    @Override
    public List<?> getGroupByStudent(Student student) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createSQLQuery("Select t1.name, t1.date FROM groups as t1 " +
                    "JOIN group_student as t2 on t1.id = t2.group_id " +
                    "JOIN students as t3 on t2.student_id = t3.id " +
                    "where t3.name = :name")
                    .setParameter("name", student.getName())
                    .list();


        }

    }

}
