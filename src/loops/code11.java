package loops;
import java.util.*;
public class Code11 {
    public static void main(String[] args) {
        System.out.println("Enter the Posstive number");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int fact=1;
        for(int i=1;i<=n;i++){
            fact=fact*i;
            System.out.println("The factorial of "+n+" is "+fact);
        }
        
    }
}

