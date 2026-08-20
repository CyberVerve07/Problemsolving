package Collections.Set.linkedHashSet;

import java.util.LinkedHashSet;

public class WatchHistory {
    public static void main(String[] args) {

        LinkedHashSet<String> searchHistory = new LinkedHashSet<>();


//Use HashLinkedSet when we want to main duplicate+ordered connection :

         searchHistory.add("Java Spring 0 to 100");
         searchHistory.add("How to improve your Communication");
         searchHistory.add("Learn the things fast ");
         searchHistory.add("Jvm Working in deep ");
         searchHistory.add("Best interviews tricks ");
         searchHistory.add("How notifications is work");
         searchHistory.add(null); //Due to uniqueness only one null is Allowed ::;
        System.out.println(searchHistory);

    }
}
//Question for which ds is used  for maintaining the Yt search history,browser search history::::

//HashLinkedSet is use double linked list :