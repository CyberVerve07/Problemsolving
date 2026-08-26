package Collection.Set;

import java.util.HashSet;

public class Demo5 {
    public static void main(String[] args) {

        HashSet<String>product=new HashSet<>();
        product.add("iPhone");
        product.add("SamsungS23");
        product.add("RealMe7");
        product.add("One plus");
        //hash code  s generated
        System.out.println();
        int hash ="RealMe7".hashCode();
        int spreadHash =hash ^ (hash>>>16);
        int bucketNumber=spreadHash &15;
        System.out.println(bucketNumber);

        //





    }
}
