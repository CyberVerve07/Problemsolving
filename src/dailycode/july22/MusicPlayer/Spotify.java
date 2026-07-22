package dailycode.july22.MusicPlayer;

public interface Spotify {

      //Abstract methods:

    public  abstract void searchMusic();
     public  abstract  void  favArtist();
      public  abstract  void  addSongFav();
       public  abstract  void  playlist();

          //default method  is used in parent class it is a feature of java8 in default method
    //the method we declare default is optional to use for Child classes :

     public  default  void  stop(){
         System.out.println("Music is Stopped : ");

     }
      public  default void  aiSearch(){
          System.out.println("Ai will Suggest You songs based on your mood ::: ");
      }



}
