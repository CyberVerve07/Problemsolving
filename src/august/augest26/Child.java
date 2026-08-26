package august.augest26;

public class Child implements Father,Mother {
    public static void main(String[] args) {
    }

        @Override
        public void walk () {
            Father.super.walk();
        }
    }
