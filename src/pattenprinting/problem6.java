package pattenprinting;

public class problem6 {
    public static void main(String[] args) {

        //code for printing the pattern
         int n=5;

         for(int row=1;row<=n;row++){

         //for printing spaces
         for (int col=1;col<=n-row;col++) {
             System.out.print(" ");
         }
             for (int col=1;col<=2*row-1;col++){
                 System.out.print("* ");
             }
             System.out.println();
         }

}}
