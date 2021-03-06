package ee.kk.CH1_JavaSyntax;

public class Main {
    public static void main(String[] args) throws NegativeAgeException {

        // The operation through which instances are created is called instantiation
        // Instantiate new football team called Flora
        EstoniaFootballTeam Flora = new EstoniaFootballTeam(
                "Flora",
                "Jürgen Henn",
                1990,
                "Estonia", 
                "Premium liiga");

        System.out.println("Team name:" + Flora.getTeamName() + "Head coach: " + Flora.getHeadCoach());

        // Using Method in FootballTeam class to get team age
        int HowOldIsFlora = Flora.computeAndPrintAge();
        System.out.println("Club age is: " + HowOldIsFlora);

        // Set a stadium for football team
        Stadium stadium = new Stadium("A. Le Coq Arena", 14405, 2001);
        System.out.println("Floar is playing in: " + stadium.getStadiumName() + " , that can hold " + stadium.getCapacity() + " persons");

        // Accessing to Enum Value
        System.out.println(FootballPositions.DEFENDER.getShortForm());
    }
}
