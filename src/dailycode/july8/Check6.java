package dailycode.july8;

public class Check6 {
    public static void main(String[] args) {
        Liabrary sc = new Liabrary(5);
        sc.setAuthor("Denis Riche");
        sc.setBookName("C language in details");

         sc.returnBook(15);


        System.out.println("The Author name is "+sc.getAuthor());
        System.out.println("The Book name is "+sc.getBookName());
        System.out.println("Avilabe copies are "+sc.getAvilableCopies());
        System.out.println("Borrow books are:");
        sc.borrowBook();

    }
}