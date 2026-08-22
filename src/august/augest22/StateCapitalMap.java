package august.augest22;

import java.util.HashMap;
import java.util.Map;

public class StateCapitalMap {
    public static void main(String[] args) {

        Map<String, String> stateMap = new HashMap<>();///Create a MAp to store state and capital:

        stateMap.put("Maharashtra", "Mumbai");
        stateMap.put("Karnataka", "Bengaluru");
        stateMap.put("Tamil Nadu", "Chennai");
        stateMap.put("Shimla", "Himachal");
        stateMap.put("WestBengal", "Kolkata");
        stateMap.put("Chandigarh", "Punjab");
        stateMap.put("Utter Pradesh", "Lucknow");

        for (Map.Entry<String, String> entry : stateMap.entrySet()) {
            //Print the map Entries:

            System.out.println("State" + entry.getKey());
            System.out.println("Captial:"+entry.getValue());

        }


    }


    }
