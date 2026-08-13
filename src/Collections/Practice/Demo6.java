package Collections.Practice;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo6 {
    public static void main(String[] args) {
        String[]arr={"Java","Python","Golang","C++"};
        ArrayList<String>list= (ArrayList<String>) Arrays.asList(arr);
        list.set(0,"Go");
        System.out.println(arr[0]+"");
        try {
            list.add("Rust");

        }catch (UnsupportedClassVersionError e){
            System.out.println("Error");
        }

    }
}
