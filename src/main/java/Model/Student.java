package Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age")
    private int age;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "students")
    private Set<Group> groups;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        groups = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setGroup(Group group) {
        groups.add(group);
    }

    @Override
    public String toString() {
        return "Student{" +
                ", name='" + name + '\'' +
                ", age=" + age +

                '}';
    }
}