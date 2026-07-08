package July7;

public class Code8 {
    public static void main(String[] args) {

          //Used multiple methods of String::
         // Create a StringBuffer with initial content
        StringBuffer sb=new StringBuffer(" Kodewala");

           //Used the append method to add more text in the existing string
           sb.append(" Academy:");
           sb.append("  Btm layout:");
        System.out.println(sb);
//Insert methd is used to insert the new values ::
          sb.insert(10,"2nd Stage ");
        System.out.println(sb );

         //char at
        sb.charAt(2);
        System.out.println(sb);

         //capacity
        sb.capacity();
        System.out.println(sb);
         sb.reverse();
        System.out.println(sb);

          sb.deleteCharAt(7);
        System.out.println(sb);




    }
}
