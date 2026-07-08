package dailycode.july8;

public class Student {
    private String name;
    private int age;
    private int marks;

    // Constructor - initializing using setters to ensure validation
    public Student(String name, int age, int marks) {
        setName(name);
        setAge(age);
        setMarks(marks);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age! Age must be greater than 0.");
        }
    }
    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        } else {
            System.out.println("Invalid marks! Must be between 0 and 100.");
        }
    }
}
