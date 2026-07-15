package dailycode.july15.employeeManagement;

public class Main {
    public static void main(String[] args) {
        Employee employee=new Hr(" Prachi","@590",21,"Prachi@gmail.com","8093038929","HR",0);
         Employee employee1=new Tester(" Sahil","38@849",35,"gautm@gmail.com","9016789379","Testing",50000);
          Employee employee2=new Manager(" Rahul","@007",46,"Rahul@987gmail.com","7393987390","Management",150000);
          Employee employee3=new Devolper(" Aditya","@0001",20,"mahajan@879gmail.com","9816534203","Software Devolpmnt",80000);

             employee.login();
             employee.work();
             employee.present();
             employee.companyPolicy();
             employee.calculateSalary();
             employee.logout();

    }

}
