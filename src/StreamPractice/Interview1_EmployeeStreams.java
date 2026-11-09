package StreamPractice;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

/**
 * ═══════════════════════════════════════════════════════════════════════
 *   STREAM API — MOST ASKED INTERVIEW QUESTIONS (Employee Based)
 * ═══════════════════════════════════════════════════════════════════════
 *
 *  Ye questions 90% interviews me puche jaate hain:
 *  Q1.  Department-wise highest paid employee
 *  Q2.  Second highest salary across all employees
 *  Q3.  Department-wise average salary
 *  Q4.  Top 3 earners in each department
 *  Q5.  Count employees by department
 *  Q6.  Employees earning above average salary
 *  Q7.  Names of all employees sorted by salary DESC
 *  Q8.  Department-wise total salary
 *  Q9.  Find if any employee earns > 1 lakh (anyMatch)
 *  Q10. Comma-separated names of employees in "Engineering"
 */
public class Interview1_EmployeeStreams {

    // ─── Employee Model ───────────────────────────────────────────────────
    record Employee(String name, String department, double salary, int age) {}

    // ─── Sample Data ──────────────────────────────────────────────────────
    static List<Employee> employees = List.of(
        new Employee("Ravi",    "Engineering", 95000,  28),
        new Employee("Priya",   "Engineering", 120000, 32),
        new Employee("Amit",    "Engineering", 85000,  26),
        new Employee("Sneha",   "HR",          60000,  30),
        new Employee("Rahul",   "HR",          55000,  27),
        new Employee("Pooja",   "HR",          70000,  35),
        new Employee("Kiran",   "Sales",       45000,  24),
        new Employee("Anjali",  "Sales",       50000,  25),
        new Employee("Vikas",   "Sales",       48000,  29),
        new Employee("Deepak",  "Finance",     110000, 40),
        new Employee("Meena",   "Finance",     98000,  36),
        new Employee("Suresh",  "Finance",     130000, 45)
    );

    public static void main(String[] args) {

        separator("Q1: Department-wise HIGHEST PAID Employee");
        /*
         *  Approach:
         *  1. groupingBy(department)        → Map<String, List<Employee>>
         *  2. collectingAndThen + maxBy     → Har department ka max salary employee
         *  Collector: Collectors.maxBy(Comparator)
         */
        Map<String, Optional<Employee>> highestPaid = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::department,
                Collectors.maxBy(Comparator.comparingDouble(Employee::salary))
            ));

        highestPaid.forEach((dept, emp) ->
            System.out.printf("  %-15s → %s (₹%.0f)%n",
                dept, emp.get().name(), emp.get().salary()));


        separator("Q2: Second Highest Salary (Across All)");
        /*
         *  Approach:
         *  1. map to salary → distinct → sorted DESC → skip(1) → findFirst
         *  distinct() → Duplicate salaries ignore karo
         *  skip(1)    → Highest skip karo, next wala lelo
         */
        OptionalDouble secondHighest = employees.stream()
            .mapToDouble(Employee::salary)
            .distinct()
            .boxed()
            .sorted(Comparator.reverseOrder())
            .skip(1)                     // ← Highest skip, 2nd lelo
            .mapToDouble(Double::doubleValue)
            .findFirst();

        secondHighest.ifPresent(s -> System.out.printf("  Second Highest Salary: ₹%.0f%n", s));


        separator("Q3: Department-wise AVERAGE Salary");
        /*
         *  Collectors.averagingDouble() → Average nikalta hai
         *  groupingBy + averagingDouble → Ek line me department-wise avg
         */
        Map<String, Double> avgSalary = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::department,
                Collectors.averagingDouble(Employee::salary)
            ));

        avgSalary.forEach((dept, avg) ->
            System.out.printf("  %-15s → Avg: ₹%.0f%n", dept, avg));


        separator("Q4: Top 2 Earners in Each Department");
        /*
         *  Approach:
         *  groupingBy → toList → sort DESC → limit(2)
         *  collectingAndThen() → Collection ke baad ek aur transform karo
         */
        Map<String, List<Employee>> top2PerDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::department,
                Collectors.collectingAndThen(
                    Collectors.toList(),
                    list -> list.stream()
                                .sorted(Comparator.comparingDouble(Employee::salary).reversed())
                                .limit(2)
                                .collect(Collectors.toList())
                )
            ));

        top2PerDept.forEach((dept, list) -> {
            System.out.printf("  %-15s → %s%n", dept,
                list.stream()
                    .map(e -> e.name() + "(₹" + (int)e.salary() + ")")
                    .collect(Collectors.joining(", ")));
        });


        separator("Q5: Count Employees by Department");
        /*
         *  Collectors.counting() → Department-wise count
         */
        Map<String, Long> countByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::department,
                Collectors.counting()
            ));

        countByDept.forEach((dept, count) ->
            System.out.printf("  %-15s → %d employees%n", dept, count));


        separator("Q6: Employees Earning ABOVE Average Salary");
        /*
         *  Step 1: Pehle overall average nikalo
         *  Step 2: Filter karo jiska salary > average ho
         *  NOTE: Stream ek baar hi iterate kar sakta hai, isliye average pehle nikalo
         */
        double overallAvg = employees.stream()
            .mapToDouble(Employee::salary)
            .average()
            .orElse(0);

        System.out.printf("  Overall Average: ₹%.0f%n", overallAvg);

        employees.stream()
            .filter(e -> e.salary() > overallAvg)
            .sorted(Comparator.comparingDouble(Employee::salary).reversed())
            .forEach(e -> System.out.printf("  %-10s %-15s ₹%.0f%n",
                e.name(), e.department(), e.salary()));


        separator("Q7: All Employee Names Sorted by Salary DESC");
        /*
         *  map → sorted → collect toList
         *  Simple but frequently asked
         */
        List<String> namesBySalary = employees.stream()
            .sorted(Comparator.comparingDouble(Employee::salary).reversed())
            .map(Employee::name)
            .collect(Collectors.toList());

        System.out.println("  " + namesBySalary);


        separator("Q8: Department-wise TOTAL Salary (summingDouble)");
        /*
         *  Collectors.summingDouble() → Sum nikalta hai
         */
        Map<String, Double> totalSalary = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::department,
                Collectors.summingDouble(Employee::salary)
            ));

        totalSalary.forEach((dept, total) ->
            System.out.printf("  %-15s → Total: ₹%.0f%n", dept, total));


        separator("Q9: Boolean Checks — anyMatch / allMatch / noneMatch");
        /*
         *  anyMatch  → Koi EK bhi condition satisfy kare → true
         *  allMatch  → SABHI satisfy kare → true
         *  noneMatch → KOI BHI satisfy na kare → true
         */
        boolean anyEarnsAbove1L = employees.stream()
            .anyMatch(e -> e.salary() > 100000);
        System.out.println("  Any employee earns > ₹1 lakh?  " + anyEarnsAbove1L);

        boolean allAbove40k = employees.stream()
            .allMatch(e -> e.salary() > 40000);
        System.out.println("  All employees earn > ₹40k?     " + allAbove40k);

        boolean noneBelow30k = employees.stream()
            .noneMatch(e -> e.salary() < 30000);
        System.out.println("  No employee earns < ₹30k?      " + noneBelow30k);


        separator("Q10: Comma-separated Names of Engineering Dept");
        /*
         *  Collectors.joining(delimiter, prefix, suffix)
         *  Most asked: "String me convert karo list ko"
         */
        String engineeringNames = employees.stream()
            .filter(e -> e.department().equals("Engineering"))
            .map(Employee::name)
            .collect(Collectors.joining(", ", "[", "]"));

        System.out.println("  Engineering Team: " + engineeringNames);


        separator("BONUS Q11: Department-wise Employee Names (grouping + joining)");
        /*
         *  groupingBy + mapping + joining
         *  Ek collector ke andar dusra collector — NESTED COLLECTORS
         */
        Map<String, String> deptNames = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::department,
                Collectors.mapping(
                    Employee::name,                  // ← Employee → Name
                    Collectors.joining(", ")         // ← Names join karo
                )
            ));

        deptNames.forEach((dept, names) ->
            System.out.printf("  %-15s → %s%n", dept, names));
    }

    private static void separator(String title) {
        System.out.println("\n┌─────────────────────────────────────────────────────────────┐");
        System.out.printf( "│  %-60s│%n", title);
        System.out.println("└─────────────────────────────────────────────────────────────┘");
    }
}

