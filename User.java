public class User {

	public static final String GENDER_LIST[] = new String[] {"Male", "Female", "Other"};
    private String name;
    private String email;
    private String gender;
    private String ethnicity;
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
        this.ethnicity = ethnicity;
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

    public String getEthnicity() {
        return ethnicity;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public void setCurrProblems(String currProblems) {
        this.currProblems = currProblems;
    }

    public void setViewedGroups(String viewedGroups) {
        this.viewedGroups = viewedGroups;
    }
}
