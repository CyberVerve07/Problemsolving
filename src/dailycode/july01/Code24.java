package dailycode.july01;

public class Code24 {
    // Create 10 objects.
    // Count how many objects are created at even positions.
    // Example:
    // Object 1
    // Object 2 <- Count
    // Object 3
    // Object 4 <- Count
    //
    // Output:
    // Even Objects = 5
    static int count=0;
    public static void Main(String[] args) {
        {
            count=count+1;
            System.out.println(count);
        }
        Code24 onj1=new Code24();
        Code24 obj2=new Code24();
        System.out.println("Count Number is:"+count);



    }
}
