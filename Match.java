import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Match{
    private static class MatchedProfile {
        private User user;
        private int matches;

        public MatchedProfile(User user, int matches) {
            this.user = user;
            this.matches = matches;
        }

        public User getUser() {
            return user;
        }

        public int getMatches() {
            return matches;
        }
    }

    
    public static List<User> findMatches(User givenProfile, String dataFilePath) {
        List<User> profiles = readProfiles(dataFilePath);
        List<User> sortedProfiles = new ArrayList<User>();
       
        List<MatchedProfile> matchedProfiles = new ArrayList<>();
        for (User profile: profiles){
            int matches = calculateMatches(givenProfile, profile);
            MatchedProfile matchedProfile =  new MatchedProfile(profile, matches);
            matchedProfiles.add(matchedProfile);
        }
        Collections.sort(matchedProfiles, Comparator.comparingInt(MatchedProfile::getMatches));
        for (MatchedProfile matchedProfile : matchedProfiles) {
            sortedProfiles.add(matchedProfile.getUser());
        }
        return sortedProfiles;
    }
    

    private static List<User> readProfiles(String dataFilePath) {
        List<User> profiles = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(dataFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] profileData = line.split(",");
                User profile = new User(profileData[0], profileData[1], profileData[2], profileData[3], Integer.parseInt(profileData[4]), profileData[5], profileData[6], profileData[7], profileData[8]);
                
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
        if (givenProfile.getAge() == otherProfile.getAge()){
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
