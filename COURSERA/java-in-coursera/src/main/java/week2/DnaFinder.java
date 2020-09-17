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

    public String findGene(String dna, int where){
        // Find the index of the first occurrence of the start codon “ATG”. If there is no “ATG”, return the empty string.
        int startCodonIndex = dna.indexOf("ATG", where);
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

    public void printAllGenes(String dna){
        int startIndex = 0;
        while(true){
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()){
                break;
            }
            System.out.println(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
    }

    public void howMany(String strA, String strB ){
        int startIndex = 0;
        int lenA = strA.length();
        int counter = 0;

        while(true){

            startIndex = strB.indexOf(strA,startIndex);
            System.out.println(startIndex);
            if (startIndex == -1){
                break;
            }
            counter = counter +1;
            startIndex = startIndex + lenA;
        }
        System.out.println(counter);
    }


    public void testFindAllGenes() {
        String dna1 = "AATGCTAACTAGCTGACTAAT";
        printAllGenes(dna1);

    }

    public void testFindGene() {
        String dna1 = "AAATGKLMNCCCTAACCCooTAGATTAATGAAAACCC";
        System.out.println("Gene is " + findGene(dna1,0));
        String dna2 = "PPPATGXXXXXXTAAXXXTAGEEERRR";
        System.out.println("Gene is " + findGene(dna2,0));
        String dna3 = "CCATGCGCTTAATGATAGATTAA";
        System.out.println("Gene is " + findGene(dna3,0));
        String dna4 = "ATGTAAMTGA";
        System.out.println("Gene is " + findGene(dna4,0));
    }

    public static void main(String args[]) {
        DnaFinder dnaCalc = new DnaFinder();
        dnaCalc.testFindAllGenes();
        //dnaCalc.testFindGene();
        dnaCalc.howMany("A","XAXXAXXXA");
    }
}
