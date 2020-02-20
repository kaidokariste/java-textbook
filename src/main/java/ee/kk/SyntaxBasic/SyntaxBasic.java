package ee.kk.SyntaxBasic;

public class SyntaxBasic {
    public static void main(String[] args){
        // Initaiate new football team called Flora
        FootballTeam Flora = new FootballTeam();
        Flora.setTeamName("FC Flora");
        Flora.setHeadCoach("Jürgen Henn");
        Flora.setFoundationYear(1990);
        System.out.println("Team name:" + Flora.getTeamName() + "Head coach: "+ Flora.getHeadCoach());
    }
}
