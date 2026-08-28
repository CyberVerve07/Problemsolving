package Collection.Practice;

import java.util.HashSet;
import java.util.Objects;

class Student {
    int id;
    Student(int id) { this.id = id; }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id;
    }
}

public class TestDrive3 {
    public static void main(String[] args) {
        HashSet<Student> set = new HashSet<>();
        set.add(new Student(101));
        set.add(new Student(101));

        System.out.println(set.size()); // Will now correctly print 1
    }
}