package dailycode.july01;

public class Code09 {
    public static void Main(String[] args) {
        //Find the largest element of an array
        int []arr={12,95,10,13,15,44,3};
        int largest=arr[0];
         //  for loop
        for (int i=1;i<arr.length;i++){
            if (arr[i]>largest){
                largest=arr[i];

            }
        }
        System.out.println("Largest element is ::"+largest);
    }
}
