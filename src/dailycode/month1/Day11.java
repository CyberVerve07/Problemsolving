package dailycode.month1;

class Day11 {


    public static void main(String[] args) {

//        sayHello();
//        sayHello();
//        sayHello();
//        sayBy();
//addtwoNumbers(10,20);
        int[] a = {10, 20, 30, 40, 50};
      int z=  sumofArray(a);
        System.out.println(z);
        int[] b = {200,90,90,100};
      int x=  sumofArray(b);
        System.out.println(x);
    }

    static void addtwoNumbers(int a, int b ) {
        int sum = a + b;
        System.out.println("The sum of a and b is" + sum);

//
    }

    static int sumofArray(int[] arr) {
        int res = 0;
        for (int i : arr) {
            res += i;
        }
        return res;
    }

}

