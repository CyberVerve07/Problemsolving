package loops;

public class code17 {
    //solid rombhus patern
    public static void main(String[] args) {

        int n=5;
        //for part 1
        for(int row=1;row<=n;row++){
            //code for print spaces
            for (int col=1;col<=n-row;col++){
                System.out.print("  ");
                //code for print star
                for ( col = 1; col <=n; col++){
                    System.out.print(" *");

                }
            }
            System.out.println();
        }



        }

    }



