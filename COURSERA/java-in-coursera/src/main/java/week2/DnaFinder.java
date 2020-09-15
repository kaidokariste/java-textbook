package week2;

public class DnaFinder {

    public Integer findStopCodon(String dna, int startIndex, String stopCodon){
        //startIndex - represents where the first occurrence of ATG occurs in dna
        int endIndex = dna.indexOf(stopCodon, startIndex+3);
        while (endIndex != -1){
            if ((endIndex - startIndex) % 3 == 0) {
                return endIndex ;
            } else {
                endIndex =dna.indexOf(stopCodon,endIndex+1);
            }
        }
        return dna.length();
    }

    public String findGene(String dna){
        // Find the index of the first occurrence of the start codon “ATG”. If there is no “ATG”, return the empty string.
        int startCodonIndex = dna.indexOf("ATG");
        if (startCodonIndex == -1){
            return "";
        }
        int endCodonTaaIndex = findStopCodon(dna,startCodonIndex,"TAA");
        int endCodonTagIndex = findStopCodon(dna,startCodonIndex,"TAG");
        int endCodonTgaIndex = findStopCodon(dna,startCodonIndex,"TGA");
        int closestStop = Math.min(Math.min(endCodonTaaIndex,endCodonTagIndex),endCodonTgaIndex);
        int dnaLength = dna.length();
        System.out.println("ATG: "+ startCodonIndex+" TAA: "+endCodonTaaIndex+" TAG: "+endCodonTagIndex+" TGA: "+endCodonTgaIndex);
        if (closestStop == dnaLength){
            return "";
        } else {
            return dna.substring(startCodonIndex,closestStop+3);
        }
    }


    public void testFindStopCodon() {
        String dna1 = "AAATGKLMNCCCTAACCCooTAGATTAATGAAAACCC";
        System.out.println("Gene is " + findStopCodon(dna1,0,"CCC"));
        String dna2 = "CCATGCGCTTAATGATAGATTAA";
        System.out.println("Gene is " + findStopCodon(dna2,0,"CCC"));
        String dna3 = "ATGXXXXX";
        System.out.println("Gene is " + findStopCodon(dna3,0,"CCC"));
        String dna4 = "ATGXXTAA";
        System.out.println("Gene is " + findStopCodon(dna4,0,"CCC"));
    }

    public void testFindGene() {
        String dna1 = "AAATGKLMNCCCTAACCCooTAGATTAATGAAAACCC";
        System.out.println("Gene is " + findGene(dna1));
        String dna2 = "PPPATGXXXXXXTAAXXXTAGEEERRR";
        System.out.println("Gene is " + findGene(dna2));
        String dna3 = "CCATGCGCTTAATGATAGATTAA";
        System.out.println("Gene is " + findGene(dna3));
        String dna4 = "ATGTAAMTGA";
        System.out.println("Gene is " + findGene(dna4));
    }

    public static void main(String args[]) {
        DnaFinder dnaCalc = new DnaFinder();
        //dnaCalc.testFindStopCodon();
        dnaCalc.testFindGene();
    }
}
