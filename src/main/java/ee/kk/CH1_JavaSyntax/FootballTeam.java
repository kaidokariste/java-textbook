package ee.kk.CH1_JavaSyntax;

/**
 * Abstract - A class that does not need to be instantiated, but groups together fields and methods
 * for other classes to inherit, or provide a concrete implementation for
 */
public abstract class FootballTeam {
    /*  Static - also known as class variable. Used for defining common property, like company for employees of school
     *  for students. Here we use to define football league name
     *  Final - if variable is final, you can not change it afterwards. It will be constant
     *  private - variable is accessible only inside it's own class
     */

    public static final String ASSOCIATION = "UEFA";
    private String TeamName;
    private String HeadCoach;
    private Integer FoundationYear;

    /* Good principle in Java is encapsulation - use special methods to access and change class variables */

    // Constructor for footballteam  - shorter form if you don't want to use getters (accessors) or setters(mutators)
    public FootballTeam(String TeamName, String HeadCoach, Integer FoundationYear){
        this.TeamName = TeamName;
        this.HeadCoach = HeadCoach;
        this.FoundationYear = FoundationYear;
    }

    public static String getASSOCIATION() {
        return ASSOCIATION;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public String getHeadCoach() {
        return HeadCoach;
    }

    public void setHeadCoach(String headCoach) {
        HeadCoach = headCoach;
    }

    public Integer getFoundationYear() {
        return FoundationYear;
    }

    // Using void means that method is not returning anything
    public void setFoundationYear(Integer foundationYear) {
        FoundationYear = foundationYear;
    }

    /**
     * Method to compute club age.
     * @return - footballclub age
     */

    public abstract int computeAndPrintAge() throws NegativeAgeException;
}
