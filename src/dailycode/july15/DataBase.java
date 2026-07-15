package dailycode.july15;

public class DataBase {

     String dataBAse,username,password;

         //Code is for Constructor Chaining
     //We can call the one constructor from another:
    // Used to reduce code and redency of code :
    //Within the Class
    //this is used for current class object and this() is used for call the one constructor to another
    //Constructor can be Overload:
    //Constructor can not be inherit:


      //Default Constructor
      DataBase(){
          this(" My DB ","Kali","admin@123");


      }
      //Parametrized Constructor:
       DataBase(String dataBAse,String username,String password){
          this.dataBAse=dataBAse;
          this.username=username;
          this.password=password;
       }

          void  connect(){
              System.out.println("Connect to Database"+dataBAse +" as "+username);

          }

    public static void main(String[] args) {
           DataBase db=new DataBase();
            db.connect();

                DataBase d2=new DataBase( "Testdb "," adminharsh ","kali282");
                d2.connect();



    }


}
