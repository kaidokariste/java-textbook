package week1;

import edu.duke.*;

public class HelloWorld {
    public void runHello(){
        FileResource res = new FileResource("resources/hello_unicode.txt");
        for (String line : res.lines()) {
            System.out.println(line);
        }
    }

	public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
        hw.runHello();
	}
}
