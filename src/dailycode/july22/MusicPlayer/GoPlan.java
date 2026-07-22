package dailycode.july22.MusicPlayer;

public class GoPlan implements Spotify {
    @Override
    public void searchMusic() {
        System.out.println("You have unlimited access to search :");
    }

    @Override
    public void favArtist() {
        System.out.println("You can join the live concert of yourfav artist : ");

    }

    @Override
    public void addSongFav() {
        System.out.println("You can add more than 1000+fav sounds: ");

    }

    @Override
    public void playlist() {
        System.out.println("You can  download your playlist ");


    }
}
