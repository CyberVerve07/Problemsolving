package loops;
public class code16 {
    public static void main(String[] args) {
        int num=3;
        for (int row=1;row<=num;row++){//outter loop for printing rows
            for (int col=1;col<=5;col++){//inner loop for printing collumns
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}
