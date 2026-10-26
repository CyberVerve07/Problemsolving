package dsa.algorithms;

public class LuhnAlgorithm {
        public static void main(String[] args) {
            String num = "79927398713";
            int sum = 0;

            for (int i = num.length() - 1; i >= 0; i--) {
                int digit = num.charAt(i) - '0';

                if ((num.length() - 1 - i) % 2 == 1) {
                    digit *= 2;
                    if (digit > 9) digit -= 9;
                }

                sum += digit;
            }

            System.out.println(sum % 10 == 0);
        }
    }

