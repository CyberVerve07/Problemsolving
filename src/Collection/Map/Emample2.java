package Collection.Map;

import java.util.LinkedHashMap;
import java.util.Map;

public class Emample2 {
    public static void main(String[] args) {


        Map<String,String> map=new LinkedHashMap<>();
        map.put("Maharashtra", "Mumbai");
        map.put("Karnataka", "Bengaluru");
        map.put("Tamil Nadu", "Chennai");
        map.put("Shimla", "Himachal");
        map.put("WestBengal", "Kolkata");
        map.put("Chandigarh", "Punjab");
        map.put("Chandigarh", "Punjab");  //key is duplicate
        map.put("Utter Pradesh", "Lucknow");
        //linked hashmap
        //Contain return type is Boolean :::
        System.out.println(map);

    }
}
