package august.augest5;

public class Demo5 {
    public static void main(String[] args) {

        try {
            Class.forName("txt Java");  //File name not Exist so it throws an exception ::
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

  //The Class.forName() method in Java is a static method used to dynamically
// load and initialize a class at runtime based on its fully qualified string name.
// It is part of the java.lang.Class class and forms the backbone of Java Reflection,
// plugin architectures, and database driver loading.