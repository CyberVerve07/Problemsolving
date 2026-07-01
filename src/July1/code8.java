package July1;
 class CountDigits {
    public static void main(String[] args) {

        int num = 987654;
        int count = 0;

        while (num != 0) {
            count++;
            num = num / 10;
        }

        System.out.println("Digits = " + count);
    }
}