package dailycode.july20.monthlyBudgetPlanner;

public class Income extends User{
     //salary
    //bonus
    //otherIncome
     private  double salary;
      private  double bonus;
      private  double otherIncome;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getOtherIncome() {
        return otherIncome;
    }

    public void setOtherIncome(double otherIncome) {
        this.otherIncome = otherIncome;
    }

    public Income(String name, String city, int age) {
        super(name, city, age);


    }

}
