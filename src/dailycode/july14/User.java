package dailycode.july14;

public class User {
    User login() {
        System.out.println("User is login");
        return this;
    }
    }

       class Client extends User{

@Override

        Client login(){
    super.login();
            System.out.println("Client is login:");
            return this;
        }

      }



        //Parent class ka reference Variable bna ka child class ka object assign krwa dena he upcasting ha ::