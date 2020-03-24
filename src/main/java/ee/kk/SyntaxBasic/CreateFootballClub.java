package ee.kk.SyntaxBasic;

public class CreateFootballClub {
    public static void main(String[] args){
        // Initaiate new football team called Flora
        FootballTeam Flora = new FootballTeam();

        // Set team info trough set and get methods
        Flora.setTeamName("FC Flora");
        Flora.setHeadCoach("Jürgen Henn");
        Flora.setFoundationYear(1990);
        System.out.println("Team name:" + Flora.getTeamName() + "Head coach: "+ Flora.getHeadCoach());

        // Using Method in FootballTeam class to get team age
        int HowOldIsFlora = Flora.computeAndPrintAge();
        System.out.println("Club age is: " + HowOldIsFlora);

        // Set a stadium for football team
        Stadium stadium = new Stadium("Le Coq Arena", 14405, 2001);
        System.out.println("Floar is playing in: " + stadium.getStadiumName() + " , that can hold " + stadium.getCapacity() + " persons");
    }
}
