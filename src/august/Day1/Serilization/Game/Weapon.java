package august.Day1.Serilization.Game;
abstract class Weapon {

    String name;
     int damage;

    public abstract void attack();

    public  abstract  void  damage();


    public void showWeaponInfo() {
        System.out.println("Weapon name is :"+name);
        System.out.println("Weapon damage is :"+damage);

        // Common code



    }
}