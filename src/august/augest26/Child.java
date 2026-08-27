package august.augest26;

public class Child implements Father,Mother {
    public static void main(String[] args) {
        Child child=new Child();
         child.walk();


    }

        @Override
        public void walk () {
            Mother.super.walk();
            System.out.println("Child follow the instruction: ");
        }
    }
