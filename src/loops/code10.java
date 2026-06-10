import java.util.Scanner;

 class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int number = input.nextInt();

        int sum = 0;

        for(int i = 1; i <= number; i++) {

            if(i % 3 == 0) {

                sum = sum + i;
            }

        }
        System.out.println(sum);

    }
}