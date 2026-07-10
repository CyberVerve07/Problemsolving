package oops.Multiple;
class Smartphone implements Camera, MusicPlayer {

    public void click() {
        System.out.println("Photo Clicked");
    }

    public void playMusic() {
        System.out.println("Playing Music");
    }

}

