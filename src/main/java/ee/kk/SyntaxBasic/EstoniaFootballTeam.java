package ee.kk.SyntaxBasic;

import java.util.Calendar;
import java.util.List;

public class EstoniaFootballTeam extends FootballTeam {

    private String country;
    private String leagueName;
    /**
     * List is orderd collection (array)
     * Precise control where element is inserted
     * List allows duplicate elements (unlike sets)
     */
    private List<String> players;

    public EstoniaFootballTeam(String clubName, String headCoach, Integer foundationYear, String country, String leagueName ){
        // Trough "super" you can call constructor from FootballTeam class
        super(clubName, headCoach, foundationYear);
        this.country = country;
        this.leagueName = leagueName;
    }

    @Override
    public int computeAndPrintAge() {
        // Get current year
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return year - getFoundationYear();
    }
}
