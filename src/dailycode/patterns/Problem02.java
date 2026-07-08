package dailycode.patterns;

public class Problem02 {
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
