package dailycode.problems.User;

public class UserA {

      String name;
      String email;

       UserA(String name,String email){
           this.name=name;
           this.email=email;

       }
        void  viewItems(){
            System.out.println("User is in  the store :"+this.name);
        }

}
