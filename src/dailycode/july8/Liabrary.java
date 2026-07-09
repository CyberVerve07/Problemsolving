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
    //Use encapsulation and const+ructor.
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

    void borrowBook() {
        if (this.avilableCopies > 0) { // check karo copies bachi hain ya nahi
            this.avilableCopies--;     // 1 copy kam kar do
            System.out.println("Book borrowed successfully. Remaining copies: " + this.avilableCopies);
        } else {
            System.out.println("Cannot borrow! No copies available.");
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
