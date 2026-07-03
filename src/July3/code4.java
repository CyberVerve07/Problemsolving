package July3;
//Create a Student class with the following fields:
//
//name
//age
//course
//
//Create 3 objects and print their details.
//
//Concepts Tested:
//
//Class
//Object
//Instance variables

public class code4 {
     public String name;
     public int  age;
     public  String course;

     code4(String name,int age, String course) {

         this.name = name;
         this.age = age;
         this.course = course;

     }

           //Create 3 objects

               void  study(){
                   System.out.println("Student is study "+this.name);
                   System.out.println(age);
                   System.out.println(course);
               }
                void play(){
                    System.out.println("Student is playing "+name);
                    System.out.println(age);
                    System.out.println(course);
                }


                    void sleep(){
                        System.out.println("Student is Sleep "+name);
                        System.out.println(age);
                        System.out.println(course);

                    }


    }
