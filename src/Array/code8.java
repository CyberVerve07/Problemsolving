package Array;

public class code8 {
    //finding the maxvalue of an array
    public static void main(String[] args) {
         int arr[]={10,30,40,50,-5,-89,100};
         int n=arr.length;
         int naxValue=arr[0];
         //compare thw index value from each other
        for(int i=1;i<=n-1;i++){
            if (arr[i]>naxValue){
                //update max value :
                naxValue=arr[i];
            }
            }
        System.out.println(naxValue);
        }

    }
