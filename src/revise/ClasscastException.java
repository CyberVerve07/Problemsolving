package revise;

public class ClasscastException {
    public static void main(String[] args) {
        Object x = Integer.valueOf(10);
        // Compiles fine, but throws ClassCastException at runtime
        String str = (String) x;
    }
}


class B{
    public static void main(String[] args) {
        int a;

        Object x=Integer.valueOf(10);
        // Compiles fine, but throws ClassCastException at runtime
        String str=(String) x;
    }
}