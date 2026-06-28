package pattenprinting;

public class problem5 {
    //Solid Romes pattern
    public static void main(String[] args) {
        int n = 5;
        for (int row = 1;row<n; row++) { //print row
            //for each row we will print spaces
            for(int col=1;col<=n-row;col++) {
                System.out.print(" ");
            }
            //for printing stars
            for (int i=1;i<=n;i++){
                System.out.print(" *");
            }
            System.out.println();
        }



    }
}
