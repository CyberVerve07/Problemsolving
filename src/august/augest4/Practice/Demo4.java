package august.augest4.Practice;

public class Demo4 {
    public static void main(String[] args) {
        try{
            int x=10/0;
        }
        catch(Exception e){
            System.out.println("Catch");
        }
        finally{
            System.out.println("Finally");
        }
    }
}
