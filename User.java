public class User {

    private String name;
    private String email;
    private String gender;
    private String race;
    private int age;
    private String identity;
    private String resources;
    private String currProblems;
    private String viewedGroups;

    public User() {
    }

    public User(String name, String email, String gender, String race, int age, String identity, String currProblems,
            String viewedGroups) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.race = race;
        this.age = age;
        this.identity = identity;
        this.resources = resources;
        this.currProblems = currProblems;
        this.viewedGroups = viewedGroups;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }

    public int getAge() {
        return age;
    }

    public String getIdentity() {
        return identity;
    }

    public String getResources() {
        return resources;
    }

    public String getCurrProblems() {
        return currProblems;
    }

    public String getViewedGroups() {
        return viewedGroups;
    }

}
