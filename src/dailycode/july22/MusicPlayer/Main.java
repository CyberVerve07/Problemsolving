package dailycode.july22.MusicPlayer;

public class Main {
    public static void main(String[] args) {
        Spotify spotify=new NormalUser();
        Spotify spotify1=new GoPlan();
        Spotify spotify2=new GoPlusplan();
         spotify.searchMusic();
         spotify.aiSearch();
         spotify1.stop();

           spotify2.addSongFav();
           spotify2.playlist();
           spotify2.searchMusic();
           spotify2.favArtist();
           spotify2.stop();
    }
}
