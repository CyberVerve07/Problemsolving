package dailycode.july20.monthlyBudgetPlanner;

public class BudgetManager {

    private Income income;
    private Needs needs;
    private Wants wants;
    private Saving saving;

    public BudgetManager(Income income, Needs needs, Wants wants, Saving saving) {
        this.income = income;
        this.needs = needs;
        this.wants = wants;
        this.saving = saving;

    }

    public BudgetManager(int i) {

    }

    public Income getIncome() {
        return income;
    }

    public void setIncome(Income income) {
        this.income = income;
    }

    public Needs getNeeds() {
        return needs;
    }

    public void setNeeds(Needs needs) {
        this.needs = needs;
    }

    public Wants getWants() {
        return wants;
    }

    public void setWants(Wants wants) {
        this.wants = wants;
    }

    public Saving getSaving() {
        return saving;
    }

    public void setSaving(Saving saving) {
        this.saving = saving;
    }

    public void setUser(User user) {

    }

    public void manageBudget() {

    }
}