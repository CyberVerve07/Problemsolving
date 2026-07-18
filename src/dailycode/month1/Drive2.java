package dailycode.month1;

class Parent{

    void show(Number n){
        System.out.println("Number");
    }
}

class Child extends Parent{

    void show(Integer n){
        System.out.println("Integer");
    }
}
  class Main{

    public static void main(String[] args){

        Parent p = new Child();

        p.show(10);
    }
}
