package dailycode.july04;

public class Code01 {
    public static void main(String[] args) {
        String s1="Java";
        String s2=new String("Java");

        String s3=s2.intern();
        String s4="Java";

          String s5=new String("JavaScript").intern();
        System.out.println(s1==s2);//false
        System.out.println(s3==s4);//true
        System.out.println(s5=="Javascript");//false 
    }
}
