package ee.kk.CH1_JavaSyntax;

import java.util.Calendar;
import java.util.List;

/**
 * Child class of parent class FootballTeam
 */
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
    public int computeAndPrintAge() throws NegativeAgeException {
        // Get current year
        int year = Calendar.getInstance().get(Calendar.YEAR);

        // Test if club age will be more than 0, else throw NegativeAgeException
        if (year - getFoundationYear() <0){
            throw new NegativeAgeException("Club age can not be negative");
        }
        return year - getFoundationYear();
    }
}
