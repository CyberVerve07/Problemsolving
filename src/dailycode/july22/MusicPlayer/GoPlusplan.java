package dailycode.july22.MusicPlayer;

public class GoPlusplan implements Spotify {
    @Override
    public void searchMusic() {
        System.out.println("You can search Unlimited music ");
    }

    @Override
    public void favArtist() {
        System.out.println("You got free Concert ticket of your favourite Artist:");
    }

    @Override
    public void addSongFav() {
        System.out.println("You can download and get unlimited skips of your fav songs : ");

    }

    @Override
    public void playlist() {
        System.out.println("You can Download and get share your fav playlist :");

    }

}
