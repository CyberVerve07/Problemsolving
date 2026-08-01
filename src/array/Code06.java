package array;

public class Code06 {
    public static void main(String[] args) {
        int arr[]={10,20,30,40,50};
        int n=arr.length;
        int sum=0;
        //for calculating the sum
        for (int i=0;i<=n-1;i++){
            int val=arr[i];
            sum=sum+val;
            System.out.println(sum);
        }
    }
}
