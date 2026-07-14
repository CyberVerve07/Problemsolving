package dailycode.july13;

abstract  class Bird {
    public static void main(String[] args) {
          Bird bird =new Sparrow();
          bird.eat();
          bird.fly();


           Bird bird1=new Parrot();
           bird1.eat();
           bird.fly();


    }

    abstract void fly();

    abstract void eat();

}

  class  Sparrow extends Bird {

      @Override
      void fly() {
          System.out.println("Sparrow is flying");
      }

      @Override
      void eat() {
          System.out.println("Sparrow is Eating:");

      }
  }
class  Parrot extends Bird {

    @Override
    void fly() {
        System.out.println(" Parrot is flying");
    }

    @Override
    void eat() {
        System.out.println("Parrot  is Eating:");

    }
}

