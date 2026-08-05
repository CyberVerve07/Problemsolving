package august.augest5;

public class Demo1 {
    public static void main(String[] args) {

         try {
             int[] arr = {104, 56, 6, 3, 5, 69, 39};
             System.out.println(arr[2]);
         }
          catch (ArrayIndexOutOfBoundsException a){
              System.out.println("Exception is found ");
          }
         finally {
             System.out.println("Execution is Complete ");  //finally execute atlesat one time due to Resourse
             //management :
         }


    }
}
