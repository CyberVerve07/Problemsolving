package loops;

public class Code14 {
    //printing statement
    //for each row
    public static void main(String[] args) {
        for (int row=1;row<=5;row++){
            for(int col=1;col<=row;col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
