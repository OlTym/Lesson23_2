package Dao;

import Model.Group;
import Model.Student;
import Service.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
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
                    "where lower(t3.name) = lower(:name)")
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
                    "where lower(t3.name) = lower(:name)")
                    .setParameter("name", student.getName())
                    .list();


        }

    }

    @Override
    public Student getStudentByName(String nameStudent) {

        Student student = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            student = session
                    .createQuery("FROM Student WHERE lower(name) = lower(:name)", Student.class)
                    .setParameter("name", nameStudent)
                    .getSingleResult();

        } catch (NoResultException e) {

            System.out.println("Student named " + nameStudent + " is not in the base");
        }
        return student;
    }

    @Override
    public Group getGroupByName(String nameGroup) {

        Group group = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            group = session
                    .createQuery("FROM Group WHERE lower(name) = lower(:name)", Group.class)
                    .setParameter("name", nameGroup)
                    .getSingleResult();

        } catch (NoResultException e) {

            System.out.println("Group named " + nameGroup + " is not in the base");
        }
        return group;
    }


}
