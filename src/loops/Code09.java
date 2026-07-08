package loops;

public class Code09 {
    public static void main(String[] args) {
        // 1se 20 tk even number 2,4,6;
        int count=0;
        for (int i=2;i<=10;i=i+2){
            if (i %2==0){
                count++;
            }
        }
        System.out.println(count);
    }
}
