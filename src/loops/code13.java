package loops;

public class Code13 {
    //pattern printing is ma 3 row and 5 collum ha
    public static void main(String[] args) {
        int n = 3;
        for (int row = 1; row <= n; row++) {//outter loop
            for (int col = 1; col <= 5; col++) {//inner loop
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}


//first of all find the no of rows and collum and now take n number of roes now finf tthe collum phir condition and loops
