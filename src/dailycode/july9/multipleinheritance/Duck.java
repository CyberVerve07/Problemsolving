package dailycode.july9.multipleinheritance;

public class Duck implements Swimmable, Flyable {
    private String name;

    public Duck(String name) {
        this.name = name;
    }

    @Override
    public void swim() {
        System.out.println(name + " is swimming in the water.");
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying in the sky.");
    }
}
