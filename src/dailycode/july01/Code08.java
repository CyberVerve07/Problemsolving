package dailycode.july01;
 class Code08 {
    public static void Main(String[] args) {

        int num = 987654;
        int count = 0;

        while (num != 0) {
            count++;
            num = num / 10;
        }

        System.out.println("Digits = " + count);
    }
}