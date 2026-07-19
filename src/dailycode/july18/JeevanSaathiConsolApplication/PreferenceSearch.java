package dailycode.july18.JeevanSaathiConsolApplication;

import java.util.List;

public class PreferenceSearch {

    public static class Preference {
        private int minAge;
        private int maxAge;
        private String city;
        private String profession;

        public Preference(int minAge, int maxAge, String city, String profession) {
            this.minAge = minAge;
            this.maxAge = maxAge;
            this.city = city;
            this.profession = profession;
        }

        public int getMinAge() {

            return minAge;
        }

        public int getMaxAge() {

            return maxAge;
        }

        public String getCity()
        {
            return city;
        }

        public String getProfession() {

            return profession;
        }
    }

    public static void searchByPreference(User currentUser, List<User> database, Preference preference) {
        System.out.println("========================================");
        System.out.println("Searching partners for: " + currentUser.getName() + " (ID: " + currentUser.getUserId() + ")");
        System.out.println("Preferences -> Age range: " + preference.getMinAge() + "-" + preference.getMaxAge() +
                           ", City: " + (preference.getCity() != null ? preference.getCity() : "Any") +
                           ", Profession: " + (preference.getProfession() != null ? preference.getProfession() : "Any"));
        System.out.println("----------------------------------------");

        boolean matchFound = false;

        for (User candidate : database) {
            // Self-match check
            if (candidate.getUserId() == currentUser.getUserId()) {
                continue;
            }

            // A Male user searches for Female users, and a Female user searches for Male users.
            if (currentUser instanceof MaleUser && !(candidate instanceof FemaleUser)) {
                continue;
            }
            if (currentUser instanceof FemaleUser && !(candidate instanceof MaleUser)) {
                continue;
            }

            // Age preference match
            if (candidate.getAge() < preference.getMinAge() || candidate.getAge() > preference.getMaxAge()) {
                continue;
            }

            // City preference match (case-insensitive, skip checking if null/empty)
            if (preference.getCity() != null && !preference.getCity().trim().isEmpty() &&
                !preference.getCity().equalsIgnoreCase(candidate.getCity())) {
                continue;
            }

            // Profession preference match (case-insensitive, skip checking if null/empty)
            if (preference.getProfession() != null && !preference.getProfession().trim().isEmpty() &&
                !preference.getProfession().equalsIgnoreCase(candidate.getProfession())) {
                continue;
            }

            // Display details of matching user
            candidate.displayDetails();
            matchFound = true;
        }

        if (!matchFound) {
            System.out.println("No matching profiles found.");
        }
        System.out.println("========================================\n");
    }
}
