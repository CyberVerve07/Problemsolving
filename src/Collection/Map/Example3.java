package Collection.Map;

import java.util.Map;
import java.util.TreeMap;

public class Example3 {
    public static void main(String[] args) {

        Map<String,String> stateMap=new TreeMap<>();
        stateMap.put("Maharashtra", "Mumbai");
        stateMap.put("Karnataka", "Bengaluru");
        stateMap.put("Tamil Nadu", "Chennai");
        stateMap.put("Shimla", "Himachal");
        stateMap.put("WestBengal", "Kolkata");
        stateMap.put("Chandigarh", "Punjab");
        stateMap.put("Utter Pradesh", "Lucknow");
        //TreeMap convert in to the sorted order:

        System.out.println(stateMap);

    }
}
