package July6;

  final class  July6 {
    public static void main(String[] args) {
        //Find first Repete Chracter ::

           final  int NUMBER=29; //Constant
        System.out.println(NUMBER);

         String name="Aaditya";
         char[] inputArr1=name.toCharArray();

          //using for loop
        for (int i=0;i< inputArr1.length;i++){
            char currentChar=inputArr1[i];

            if (name.indexOf(currentChar)==name.lastIndexOf(currentChar)){

               }
            System.out.println("Current character is :"+currentChar);
               break;

        }
        final class Animal   {

            final void eat() {
                System.out.println("Animal is eating");
            }
        } /// Final class din't extend the parent class it becomes final

        //class Dog extends Animal {

            //@Override
            //void eat() {
              //  System.out.println("Dog is eating");
            }
        }




