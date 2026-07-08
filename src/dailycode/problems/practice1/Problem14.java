package dailycode.problems.practice1;

public class Problem14 {
    static  int mul(int a,int b){
        return a*b;

    }
    static int mul(int a,int b,int c){
        return a*b*c;

    }
//Mrthod overloading example two method name are same but diffrent parameters
    public static void main(String[] args) {
        int res1=mul(2,4);
        int res2=mul(2,4,6);
        System.out.println("The Multiplication of two no is "+res1);
        System.out.println("The multiplication of Three number is "+res2);
    }
}
