package ee.kk.SyntaxBasic;

public class CreateFootballClub extends Object{
    public static void main(String[] args) {

        // Initiate new football team called Flora
        EstoniaFootballTeam Flora = new EstoniaFootballTeam(
                "FC Flora",
                "Jürgen Henn",
                1990,
                "Estonia", 
                "Premium liiga");

        System.out.println("Team name:" + Flora.getTeamName() + "Head coach: " + Flora.getHeadCoach());

        // Using Method in FootballTeam class to get team age
        int HowOldIsFlora = Flora.computeAndPrintAge();
        System.out.println("Club age is: " + HowOldIsFlora);

        // Set a stadium for football team
        Stadium stadium = new Stadium("Le Coq Arena", 14405, 2001);
        System.out.println("Floar is playing in: " + stadium.getStadiumName() + " , that can hold " + stadium.getCapacity() + " persons");

        // Accessing to Enum Value
        System.out.println(FootballPositions.DEFENDER.getShortForm());
    }
}
