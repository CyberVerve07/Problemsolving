package dailycode.july20.monthlyBudgetPlanner;

import java.util.Scanner;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        sc.nextLine(); // Buffer clear

        System.out.print("Enter City: ");
        String city = sc.nextLine();

        // Create Objects
        User user = new User("Aditya","Himachal",20);
        Income income = new Income("Ashish","Delhi",24);
        Needs needs = new Needs();
        Wants wants = new Wants();
        Saving saving = new Saving();
        BudgetManager manager = new BudgetManager(8000);

        // Store Data
        user.setName(name);
        user.setAge(age);
        user.setCity(city);

        income.setSalary(salary);

        // Next: Take Needs, Wants and Savings input

        // Pass objects to Manager
        manager.setUser(user);
        manager.setIncome(income);
        manager.setNeeds(needs);
        manager.setWants(wants);
        manager.setSaving(saving);

        // Start Budget Management
        manager.manageBudget();

        sc.close();
    }
}