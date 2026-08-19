package oops.multiple;

/**
 * SmartPhone — Implements MULTIPLE interfaces (Camera + MusicPlayer).
 */
public class SmartPhone implements Camera, MusicPlayer {

    @Override
    public void click() {
        System.out.println("Photo Clicked");
    }

    @Override
    public void playMusic() {
        System.out.println("Playing Music");
    }

    public static void main(String[] args) {
        SmartPhone phone = new SmartPhone();
        phone.click();
        phone.playMusic();
    }
}
