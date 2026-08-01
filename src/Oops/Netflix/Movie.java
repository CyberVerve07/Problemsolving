package oops.netflix;

/**
 * Movie — Represents a Netflix movie with details.
 *
 * INTERVIEW DEFINITION — Static Nested Class:
 * -----------------------------------------------
 * Q: What is a Static Nested Class?
 * A: A static nested class is a class defined INSIDE another class with the 'static' keyword.
 *    - It can be instantiated WITHOUT an instance of the outer class.
 *    - It CANNOT access non-static members of the outer class directly.
 *    - Usage: Movie.Watching session = new Movie.Watching(...);
 *
 * Q: Why use a Static Nested Class?
 * A: 1. LOGICAL GROUPING — Watching is logically related to Movie.
 *    2. ENCAPSULATION — hides Watching inside Movie namespace.
 *    3. READABILITY — Movie.Watching clearly shows the relationship.
 *
 * Q: Static Nested Class vs Inner Class?
 * A: | Feature              | Static Nested Class        | Inner Class (non-static) |
 *    |----------------------|----------------------------|--------------------------|
 *    | 'static' keyword     | Yes                        | No                       |
 *    | Access outer members | Only static members        | All members              |
 *    | Instantiation        | new Outer.Nested()         | outerObj.new Inner()     |
 *    | Use case             | Independent utility class  | Tightly coupled          |
 *
 * BUG FIX: Renamed field 'name' → 'genre' (was semantically incorrect — name was storing genre).
 * BUG FIX: Made fields private with getters for proper Encapsulation.
 *
 * JAVA TYPE: class (with static nested class)
 * OOP PILLAR: Encapsulation + Inheritance (Watching extends Movie)
 *
 * @author Aditya
 * @version 2.0
 */
public class Movie {

    /** BUG FIX: Encapsulated fields (public → private) */
    private String movieId;
    private String title;
    private String genre; // BUG FIX: Renamed from 'name' to 'genre' (semantic fix)
    private String duration;
    private String rating;

    /**
     * Constructor — initializes movie details.
     *
     * @param movieId  String — unique movie ID
     * @param title    String — movie title
     * @param genre    String — movie genre (e.g., "Sci-Fi/Action")
     * @param duration String — movie duration (e.g., "2h 28m")
     * @param rating   String — movie rating (e.g., "8.8/10")
     */
    Movie(String movieId, String title, String genre, String duration, String rating) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
    }

    // ======================== GETTERS ========================

    /** @return String — the movie ID */
    public String getMovieId() {
        return movieId;
    }

    /** @return String — the title */
    public String getTitle() {
        return title;
    }

    /** @return String — the genre */
    public String getGenre() {
        return genre;
    }

    /** @return String — the duration */
    public String getDuration() {
        return duration;
    }

    /** @return String — the rating */
    public String getRating() {
        return rating;
    }

    /**
     * Displays movie details.
     */
    void displayMovie() {
        System.out.println("Movie Details--------------------");
        System.out.println();
        System.out.println("Movie ID       : " + this.movieId);
        System.out.println("Movie Title    : " + this.title);
        System.out.println("Movie Genre    : " + this.genre);
        System.out.println("Movie Duration : " + this.duration);
        System.out.println("Movie Rating   : " + this.rating);
    }

    /**
     * Watching — Static Nested Class representing an active watch session.
     *
     * INTERVIEW: How to create an instance of a Static Nested Class?
     * → Movie.Watching session = new Movie.Watching(...);
     * → No need to create a Movie object first (because it's static).
     *
     * @see Movie
     */
    public static class Watching extends Movie {

        /**
         * Constructor — creates a watch session and displays watch status.
         *
         * @param movieId  String — movie ID
         * @param title    String — movie title
         * @param genre    String — movie genre
         * @param duration String — movie duration
         * @param rating   String — movie rating
         */
        public Watching(String movieId, String title, String genre, String duration, String rating) {
            super(movieId, title, genre, duration, rating);

            System.out.println("Movie is Watched: " + this.getGenre());
            System.out.println("Complete Watching: " + this.getDuration());
            System.out.println("Your last watched Movie: " + this.getTitle());
        }
    }
}