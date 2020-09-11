package week1;

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int totalPoints = 0;
        for (Point p: s.getPoints()) {
            totalPoints = totalPoints +1;
        }
        return totalPoints;
    }

    public double getAverageLength(Shape s) {
        // Get perimeter
        double shapePer = getPerimeter(s);
        int shapeSides = getNumPoints(s);

        return shapePer/shapeSides;
    }

    public double getLargestSide(Shape s) {
        // Start with totalPerim = 0
        double largestSide = 0.0;
        // Start wth prevPt = the last point
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            //System.out.println("From " + prevPt + " to " + currPt + " is " +currDist);
            // Update totalPerim by currDist
            if (currDist > largestSide){
            // Update prevPt to be currPt
            largestSide = currDist;
            }
            // Update prevPt to be currPt
            prevPt = currPt;

        }
        // Largest side is is the answer
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Start with largestX = 0.0
        double largestX = 0.0;

        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double theX = currPt.getX();
            //System.out.println("Current X is = "+theX);
            // Update the X
            if (theX > largestX){
                // Update prevPt to be currPt
                largestX = theX;
            }
        }
        // Largest side is is the answer
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        return 0.0;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource("resources/example1.txt");
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int pointsCount = getNumPoints(s);
        System.out.println("Shape has "+ pointsCount + " points");
        double avgLenth = getAverageLength(s);
        System.out.println("Sides average length = "+ avgLenth);
        double largestSide = getLargestSide(s);
        System.out.println("Largest side is = "+ largestSide);
        double largestX = getLargestX(s);
        System.out.println("Largest X is = "+ largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println("Looking file: " +f);
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            System.out.println("perimeter = " + length);
            int pointsCount = getNumPoints(s);
            System.out.println("Shape has "+ pointsCount + " points");
            double avgLenth = getAverageLength(s);
            System.out.println("Sides average length = "+ avgLenth);
            double largestSide = getLargestSide(s);
            System.out.println("Largest side is = "+ largestSide);
            double largestX = getLargestX(s);
            System.out.println("Largest X is = "+ largestX);
        }
    }

    public void testFileWithLargestPerimeter() {
        double largestPerimeter = 0.0;
        File k = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            System.out.println("perimeter = " + length);
            if (length > largestPerimeter) {
                largestPerimeter = length;
                k = f;
            }
        }
        System.out.println("File that contains largest perimeter is:" + k);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        //System.out.println("perimeter = "+peri);

    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        //pr.triangle();
        //pr.printFileNames();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
