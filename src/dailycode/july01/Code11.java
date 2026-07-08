package dailycode.july01;

public class Code11 {
    public static void Main(String[] args) {
        int arr[]={10,303,40,30,4,8};
        int smallestElement=arr[0];
        //For loop
        for (int i=1;i<arr.length;i++){
            if (arr[i]<smallestElement) {

                smallestElement = arr[i];
            }

        }
        System.out.println("The Smallest Element is "+smallestElement);

        }

}
