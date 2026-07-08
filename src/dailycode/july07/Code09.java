package dailycode.july07;

public class Code09 {
    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer();
        int capacity= sb.capacity();
          System.out.println("Initial capacity of String buffer is :"+capacity);

            //Append content that exceed the current capacity:

         sb.append("Welcome to Kodewala !!!!!!!");
          System.out.println(sb.capacity());
    }
}
