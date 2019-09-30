package Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date")
    private String data;
    @ManyToMany
    @JoinTable(name = "group_student",
            joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id")
    )
    private Set<Student> students;

    public Group() {
    }

    public Group(String name, String data) {
        this.name = name;
        this.data = data;
        students = new HashSet<>();

    }

    public String getName() {
        return name;
    }

    public void setStudents(Student student) {

        students.add(student);

    }

    @Override
    public String toString() {
        return "Group{" +
                ", name='" + name + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}