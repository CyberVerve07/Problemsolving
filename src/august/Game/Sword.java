package august.Game;

public class Sword extends Weapon {
    @Override
    public void attack() {
        System.out.println("Sword Slash ⚔\uFE0F");

    }

    @Override
    public void damage() {
        System.out.println("20 damage of each bullet");

    }
}

