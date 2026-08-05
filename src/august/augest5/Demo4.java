package august.augest5;

public class Demo4 {
    public static void main(String[] args) {

        try {


            Class.forName("august.augest5.Demo4");  //File name is found not Exception is handled
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
