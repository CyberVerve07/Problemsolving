package august.augest4.Practice;

public class Demo3 {
    public static void main(String[] args) {

          int []books={10,20,30,40,49,95,49,95,29};
          try {
              System.out.println(books[9]);
          } catch (ArithmeticException a){
              System.out.println("Book  id in not found : ");

          }

    }


}
