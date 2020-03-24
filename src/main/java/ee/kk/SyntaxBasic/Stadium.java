package ee.kk.SyntaxBasic;

public class Stadium {

    private String StadiumName;
    private Integer ConstructionYear;
    private Integer Capacity;

    // Constructors are different than methods as they have same name as class and doesn't have return statement
    // Implicit constructor for Stadium is not called any more meaning in main - Stadum stadium = new Stadium(); does not compile

    public Stadium(String StadiumName, Integer Capacity){
        this.StadiumName = StadiumName;
        this.Capacity = Capacity;
    }

    // If you don't want to set all the parameters, then another constructor is need
    // For not repeating ourselves, we use this keyword. Constructors can call each other using this.
    public Stadium(String StadiumName, Integer Capacity, Integer ConstructionYear){
        this(StadiumName,Capacity);
        this.ConstructionYear = ConstructionYear;
    }

    public String getStadiumName() {
        return StadiumName;
    }

    public Integer getConstructionYear() {
        return ConstructionYear;
    }

    public Integer getCapacity() {
        return Capacity;
    }
}
