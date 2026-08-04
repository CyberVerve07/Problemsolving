package august.Game;

public class Bow extends Weapon{
    @Override
    public void attack() {
        System.out.println("Arrow Shot \uD83C\uDFF9");
    }

    @Override
    public void damage() {
        System.out.println("Damage is 40% of each bullet ");

    }
}
