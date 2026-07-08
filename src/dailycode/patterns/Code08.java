package dailycode.patterns;

public class Code08 {
    public static void main(String[] args) {
        int n=4;
        for (int row=1;row<=n;row++){
            if (row==1||row==2||row==4){
                for (int col=1;col<=row;col++){
                    System.out.print("* ");
                }
            }
            else {
                //Middle rows
                //1*print krna ha
                System.out.print("* ");
            }
                //row-2spaces
                for (int col=1;col<=(row-2);col++) {
                    System.out.print(" ");
                }

                System.out.println();
            }

        }

}
