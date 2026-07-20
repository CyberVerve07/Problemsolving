package dailycode.july20.monthlyBudgetPlanner;

public abstract class BudgetCategory  {
     //categoryName
    //amount
    //description
     private   String categoryName;
      private double amount;
      private String description;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    abstract void display();
     abstract  void  calculate();


      }
