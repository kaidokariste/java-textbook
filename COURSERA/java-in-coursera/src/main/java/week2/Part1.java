package week2;

public class Part1 {

    public String findSimpleGene(String s) {
        String result = "";

        int startIndex = s.indexOf("ATG");
        if (startIndex == -1) {
            return "";
        }
        int endIndex = s.indexOf("TAA", startIndex + 3);
        if (endIndex == -1) {
            return "";
        }

        //If the length of the substring between the “ATG” and “TAA” is a multiple of 3, then return the substring that starts with that “ATG” and ends with that “TAA”.
        if ((endIndex - (startIndex + 3)) % 3 == 0) {
            result = s.substring(startIndex, endIndex + 3);
        }
        //System.out.println(startIndex + " " + endIndex + " " + result);
        return result;
    }

    public void testSimpleGene() {
        String dna1 = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println("Gene is " + findSimpleGene(dna1));
        String dna2 = "XXXXXTAA";
        System.out.println("Gene is " + findSimpleGene(dna2));
        String dna3 = "ATGXXXXX";
        System.out.println("Gene is " + findSimpleGene(dna3));
        String dna4 = "ATGXXTAA";
        System.out.println("Gene is " + findSimpleGene(dna4));
    }

    public static void main(String args[]) {
        Part1 dnaCalc = new Part1();
        dnaCalc.testSimpleGene();
    }
}
