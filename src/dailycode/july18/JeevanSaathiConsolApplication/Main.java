package dailycode.july18.JeevanSaathiConsolApplication;

import dailycode.july17.Code1.TCS.SoftwareEngineer;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        User.CompanyInfo();

        Process process = new Process();

        // Define a database of user profiles
        List<User> database = new ArrayList<>();
        
        // Male Users
        User aditya = new MaleUser(9383, "Aditya", 20, "Himachal", "SoftwareEngineer", "Hindu", true);
        User rahul = new MaleUser(9384, "Rahul", 24, "Delhi", "Doctor", "Hindu", true);
        User amit = new MaleUser(9385, "Amit", 22, "Himachal", "HR", "Sikh", false);
        
        // Female Users
        User prachi = new FemaleUser(8392, "Prachi", 19, "Delhi", "HR", "Hindu", false);
        User sneha = new FemaleUser(8393, "Sneha", 21, "Delhi", "SoftwareEngineer", "Hindu", true);
        User kiran = new FemaleUser(8394, "Kiran", 25, "Mumbai", "Teacher", "Sikh", true);

        database.add(aditya);
        database.add(rahul);
        database.add(amit);
        database.add(prachi);
        database.add(sneha);
        database.add(kiran);

        Membership membership = new Freemember();
        Membership membership2 = new Premium();

        System.out.println("--- Processing Profile Matches ---");
        // Process Male User (Premium)
        process.match(aditya);
        process.match1(membership2);

        // Process Female User (Free)
        process.match(prachi);
        process.match1(membership);

        System.out.println("\n--- Performing Preference-Based Searches ---");

        // 1. Aditya (Male) searching for Female profiles, age 18-22, in Delhi
        PreferenceSearch.Preference malePreferences = new PreferenceSearch.Preference(18, 22, "Delhi", null);
        PreferenceSearch.searchByPreference(aditya, database, malePreferences);

        // 2. Prachi (Female) searching for Male profiles, age 20-25, in Himachal
        PreferenceSearch.Preference femalePreferences = new PreferenceSearch.Preference(20, 25, "Himachal", null);
        PreferenceSearch.searchByPreference(prachi, database, femalePreferences);

        // 3. Sneha (Female) searching with specific age range and profession (e.g. Doctor)
        PreferenceSearch.Preference docPreference = new PreferenceSearch.Preference(22, 26, null, "Doctor");
        PreferenceSearch.searchByPreference(sneha, database, docPreference);
    }
}
