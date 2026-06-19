package Array;

public class code3 {
    public static void main(String[] args) {
        String sum;
        add();
        //code for print values of array
//        int arr[]={10,20,30,40};
//        int n=arr.length;
//        for(int i=0;i<=n-1;i++){
//            System.out.println(arr[i]);
//        }
    }

    static void add() {
        int arr[] = {10, 10};
        int n = arr.length;
        for (int i = 0; i <= n - 1; i++) {
            System.out.println(arr[i]);
            int sum = 0;
            sum = sum + arr[i];
        }

        System.out.println("The of the the elements of array is " );


}
}

