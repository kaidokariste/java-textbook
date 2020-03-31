package ee.kk.SyntaxBasic;

/**
 * Example of using enum class
 */
public enum FootballPositions {
    FORWARD("F"),
    MIDFIELDER("M"),
    DEFENDER("D");

    private final String shortForm;

    FootballPositions(String shortForm) {
        this.shortForm = shortForm;
    }

    public String getShortForm(){
        return shortForm;
    }
}
