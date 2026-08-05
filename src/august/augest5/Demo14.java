package august.augest5;

public class Demo14 {
    public static void main(String[] args) {

        try {
            System.out.println(12 / 0);
            String name = null;
            int[] arr = {12, 3, 6, 7, 8, 9, 20};
            System.out.println(arr[16]);

            System.out.println("Simple exception");
        }
        catch (ArithmeticException e){
            System.out.println("Airthmatic Exception");

        }
        catch (NullPointerException n){
            System.out.println("Null pointer Exception");

        }
        catch (ArrayIndexOutOfBoundsException a){
            System.out.println("Array out of boundry exception");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
