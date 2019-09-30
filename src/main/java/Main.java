import Model.Group;
import Model.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {

   /* Отношение M:M
    Создать несколько групп
    Добавить несколько студентов в каждую группу
    Добавить студента в несколько групп
    И записать в БД. Сделать запрос в БД и вывести:
    Список студентов по названию группы (в любом регистре)
    Список групп по имени студента (в любом регистре)*/

    public static void main(String[] args) {


        Group groupJava = new Group("Java", "26.08.19");
        Group groupPhp = new Group("PHP", "21.09.19");

        Student alex = new Student("Alex", 22);
        Student norman = new Student("Norman", 20);
        Student ben = new Student("Ben", 25);
        Student natali = new Student("Natali", 30);

        List<Student> students = new ArrayList<>();
        students.add(alex);
        students.add(ben);
        students.add(norman);
        students.add(natali);

        List<Student> studentPhp = new ArrayList<>();
        studentPhp.add(alex);
        studentPhp.add(ben);


        ServiseUtil.creatGroup(students, groupJava);
        ServiseUtil.creatGroup(studentPhp, groupPhp);

        ServiseUtil.fillStudent(students);
        ServiseUtil.fillGroup(groupJava);
        ServiseUtil.fillGroup(groupPhp);

        System.out.println(ServiseUtil.getStudentByGroup(groupJava));
        System.out.println(ServiseUtil.getStudentByGroup(groupPhp));
        System.out.println(ServiseUtil.getGroupByStudent(alex));


    }


}
