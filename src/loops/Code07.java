package loops;

public class Code07 {
    //1 se 20 tak odd numbers count
    static int count=0;
    public static void main(String[] args) {
        for (int i=1;i<=20;i=i+2) {
            if (i%2 !=0) count++;
            }
        System.out.println(count);

    }
}
