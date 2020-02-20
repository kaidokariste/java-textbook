package ee.kk.SyntaxBasic;

public class FootballTeam {
    /*  Static - also known as class variable. Used for defining common property, like company for employees of school
     *  for students. Here we use to define football league name
     *  Final - if variable is final, you can not change it afterwards. It will be constant
     *  private - variable is accessible only inside it's own class
     */

    static final String LEAGUE = "Premium liiga";
    private String TeamName;
    private String HeadCoach;
    private Integer FoundationYear;

    /* Good principle in Java is encapsulation - use special methods to access and change class variables */

    public static String getLEAGUE() {
        return LEAGUE;
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

    public void setFoundationYear(Integer foundationYear) {
        FoundationYear = foundationYear;
    }
}
