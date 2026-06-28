package pattenprinting;

public class problem4 {
    public static void main(String[] args) {
        //code for printing right angle reverse
        int n=5;
        for(int row=1;row<=n;row++){
            //for each colum we print stars
            for (int col=1;col <=n-row+1;col++){
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}
