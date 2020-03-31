package ee.kk.CH1_JavaSyntax;

// Checked exception - This is any type of exception that extends Exception
public class NegativeAgeException extends Exception{
    public NegativeAgeException(String message) {
        super(message);
    }
}
