package pattenprinting;

public class problem2 {
    public static void main(String[] args) {
        int n=3;
        for (int row=1;row<=n;row++){ //outerloop
            for (int col=1;col<=5;col++){ //inner loop
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
