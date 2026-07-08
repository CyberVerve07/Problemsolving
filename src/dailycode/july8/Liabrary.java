package dailycode.july8;

public class Liabrary {
    /// *
    //Question 12: Library System
    //
    //Create a LibraryBook class.
    //
    //Private Variables:
    //- bookName
    //- author
    //- availableCopies
    //
    //Methods:
    //- borrowBook()
    //- returnBook()
    //- getAvailableCopies()
    //
    //Rules:
    //- Cannot borrow if copies are 0.
    //- Returning a book increases copies.
    //- Copies should never become negative.
    //
    //Use encapsulation and constructor.
    //*/

    private String bookName;
    private String author;
    private int  avilableCopies;


      Liabrary (int avilableCopies){
          this.avilableCopies=avilableCopies;

      }

    public int getAvilableCopies() {
        return avilableCopies;
    }

    public void setAvilableCopies(int  avilableCopies) {
        this.avilableCopies = avilableCopies;
    }

    void borrowBook(int avilableCopies) {
        if (avilableCopies <= 0) {
            System.out.println("Borrow Book:");
            this.avilableCopies=avilableCopies;
        } else {
            System.out.println("Can not avilable copy:");
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    void returnBook(int back) {
        if (back > 0) {
            this.avilableCopies = this.avilableCopies + back; // Copies badha do
            System.out.println("Book returned. Total copies: " + this.avilableCopies);
        }
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
