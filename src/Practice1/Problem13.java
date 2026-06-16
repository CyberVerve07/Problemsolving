package Practice1;

import static java.lang.System.out;

public class Problem13 {
static  int addtwoNumbers(int a,int b){
    int sum=a+b;
//    out.println("The Sum is "+(sum));
    return sum;
}

    public static void main(String[] args) {
       int res= addtwoNumbers(10,90);
        out.println("The result is "+res);
    }
}
