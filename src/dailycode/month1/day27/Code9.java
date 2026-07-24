package dailycode.month1.day27;

   public class Code9 {

        String name;
        int age;

        static String college = "HPU";

        public static void main(String[] args) {
            String college1 = Code9.college;
            System.out.println(college1);

            //               JVM
            //
            //           Student.class
            //        ---------------------
            //        static college="HPU"
            //        methods
            //        metadata
            //        ---------------------

        }

}
