import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Match {

    public static List<User> findMatches(User givenProfile, String dataFilePath) {
        List<User> profiles = readProfiles(dataFilePath);

        for (User profile : profiles) {
            int matches = calculateMatches(givenProfile, profile);
            profile.setMatches(matches);
        }

        Collections.sort(profiles, Comparator.comparingInt(User::getMatches).reversed());

        return profiles;
    }

    private static List<User> readProfiles(String dataFilePath) {
        List<User> profiles = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(dataFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] profileData = line.split(",");
                User profile = new User(profileData[0], profileData[1], profileData[2], profileData[3],
                        Integer.parseInt(profileData[4]), profileData[5], profileData[6], profileData[7]);
                profiles.add(profile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return profiles;
    }

    private static int calculateMatches(User givenProfile, User otherProfile) {
        int matches = 0;
        if (!givenProfile.getGender().equals(otherProfile.getGender())) {
            matches++;
        }
        if (!givenProfile.getRace().equals(otherProfile.getRace())) {
            matches++;
        }
        if (givenProfile.getAge() == otherProfile.getAge()) {
            matches++;
        }
        if (!givenProfile.getIdentity().equals(otherProfile.getIdentity())) {
            matches++;
        }
        if (!givenProfile.getCurrProblems().equals(otherProfile.getCurrProblems())) {
            matches++;
        }
        return matches;
    }
}