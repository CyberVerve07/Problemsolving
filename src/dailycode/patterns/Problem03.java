package dailycode.patterns;

public class Problem03 {
    public static void main(String[] args) {
        //code for printing right angle triangle
        int n=5;
        for (int row=1;row<=n;row++){
            //for each col print row value
            for (int col=1;col<=row;col++){
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}
