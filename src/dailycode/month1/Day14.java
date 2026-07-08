package dailycode.month1;

import java.util.Scanner;

 class Day14 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String name = input.nextLine();

        System.out.print("Enter Salary: ");
        double salary = input.nextDouble();

        System.out.print("Enter Experience (Years): ");
        int experience = input.nextInt();

        System.out.print("Enter Performance Rating (1-5): ");
        int rating = input.nextInt();

        double performanceBonus = 0;
        double experienceBonus = 0;
        double tax = 0;

        // Performance Bonus
        if (rating == 5) {
            performanceBonus = salary * 20 / 100;
        }
        else if (rating == 4) {
            performanceBonus = salary * 15 / 100;
        }
        else if (rating == 3) {
            performanceBonus = salary * 10 / 100;
        }
        else if (rating == 2) {
            performanceBonus = salary * 5 / 100;
        }
        else if (rating == 1) {
            performanceBonus = 0;
        }
        else {
            System.out.println("Invalid Rating!");
            return;
        }

        // Experience Bonus
        if (experience >= 5) {

            if (salary < 50000) {
                experienceBonus = 5000;
            }
            else {
                experienceBonus = 3000;
            }

        }
        else {
            experienceBonus = 0;
        }

        double totalSalary = salary + performanceBonus + experienceBonus;

        // Tax
        if (totalSalary > 100000) {
            tax = totalSalary * 10 / 100;
        }

        double finalSalary = totalSalary - tax;

        // Output
        System.out.println("\n----- Employee Details -----");
        System.out.println("Employee Name      : " + name);
        System.out.println("Performance Bonus  : " + performanceBonus);
        System.out.println("Experience Bonus   : " + experienceBonus);
        System.out.println("Tax                : " + tax);
        System.out.println("Final Salary       : " + finalSalary);

        input.close();
    }
}