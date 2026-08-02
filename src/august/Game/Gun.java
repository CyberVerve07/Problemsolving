package august.Game;

public class Gun  extends  Weapon{
    @Override
    public void attack() {
        System.out.println("Bullet Fired \uD83D\uDD2B");
    }

    @Override
    public void damage() {
        System.out.println("Damage is 60 ");
    }
}
