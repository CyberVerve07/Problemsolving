package Netflix;

public class Movie {
    public String movieId;
    public String title;
    public String name;
    public String duration;
    public String rating;

    Movie(String movieId, String title, String name, String duration, String rating) {
        this.movieId = movieId;
        this.title = title;
        this.name = name;
        this.duration = duration;
        this.rating = rating;
    }

    void displayMovie(){
        System.out.println("Movie Details is Display_--------------------");
        System.out.println();
        System.out.println("Movie id is :"+this.movieId);
        System.out.println("Movie title is :"+this.title);
        System.out.println("Movie genre is :"+this.name);
        System.out.println("Movie duration is :"+this.duration);
        System.out.println("Movie rating is :"+this.rating);
    }

    public static class Watching extends Movie {
        public Watching(String movieId, String title, String genre, String duration, String rating) {
            super(movieId, title, genre, duration, rating);

            System.out.println("Movie is Watched "+this.name);
            System.out.println("Complete Watching ::"+this.duration);
            System.out.println("Your last watch Movie is:: "+this.name);
        }
    }
}