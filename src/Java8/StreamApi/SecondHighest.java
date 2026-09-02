//package Java8.StreamApi;
//
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Optional;
//
//public class SecondHighest {
//    static void main() {
//
//        List<Integer>nums= Arrays.asList(10,20,30,40,50,60,70);
//        Optional<Integer>secondMax=nums.stream().sorted()(Comparator.reverseOrder()).skip(1).findFirst();
//
//        System.out.println("Second highesrt sallary is :"+secondMax.get());
//
//
//    }
//}
