package dailycode.month1.day30;
//Program to use of Static and Init
public class Demo {
    int count=0;
    static {
        System.out.println("Static Execution");
    }
    {
        count=count+1;
        System.out.println("Instance Execution");
    }
    public Demo(){
        System.out.println("Constructor is call");
    }

    public static void main(String[] args) {
        Demo obj1=new Demo();
        Demo onj2=new Demo();
        System.out.println("Start program ");
    }
}
