package week2;

import edu.duke.FileResource;
import edu.duke.StorageResource;

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
        //System.out.println("ATG: "+ startCodonIndex+" TAA: "+endCodonTaaIndex+" TAG: "+endCodonTagIndex+" TGA: "+endCodonTgaIndex);
        if (closestStop == dnaLength){
            return "";
        } else {
            return dna.substring(startCodonIndex,closestStop+3);
        }
    }

    // All genes method
    public StorageResource getAllGenes(String dna){
        //create an empty sorage resource
        StorageResource geneList = new StorageResource();
        //
        int startIndex = 0;
        while(true){
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()){
                break;
            }
            // Add the gene to gene list
            geneList.add(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return geneList;
    }

    public int howMany(String strA, String strB ){
        int startIndex = 0;
        int lenA = strA.length();
        int counter = 0;

        while(true){

            startIndex = strB.indexOf(strA,startIndex);
            //System.out.println(startIndex);
            if (startIndex == -1){
                break;
            }
            counter = counter +1;
            startIndex = startIndex + lenA;
        }
        return counter;
    }

    public double cgRatio(String dna){
        int dnaLength = dna.length();
        int countG = howMany("G",dna);
        int countC = howMany("C",dna);
        //System.out.println("Kokku G-sid: "+countG);
        //System.out.println("Kokku C-sid: "+countC);
        //System.out.println("Suhtarv: " + ((double)(countC+countG)/dnaLength));
        return ((double)(countC+countG))/dnaLength;
    }

    public String mystery(String dna) {
        int pos = dna.indexOf("T");
        int count = 0;
        int startPos = 0;
        String newDna = "";
        if (pos == -1) {
            return dna;
        }
        while (count < 3) {
            count += 1;
            newDna = newDna + dna.substring(startPos,pos);
            startPos = pos+1;
            pos = dna.indexOf("T", startPos);
            if (pos == -1) {
                break;
            }
        }
        newDna = newDna + dna.substring(startPos);
        return newDna;
    }


    public void testFindAllGenes() {
        String dna1 = "AATGCTAACTAGCTGAppppATGKAIDOKTAA";
        StorageResource myGenes = getAllGenes(dna1);
        for (String s: myGenes.data()){
            System.out.println(s);
        }
    }


    public static void main(String args[]) {
        DnaFinder dnaCalc = new DnaFinder();
        FileResource fr = new FileResource("resources/GRch38dnapart.fa");
        String dna = fr.asString().toUpperCase();
        int countSuhtarv = 0;
        int countPikkus = 0;
        int longestGene = 0;


        StorageResource myGenes = dnaCalc.getAllGenes(dna);
        System.out.println("Total genes: " +myGenes.size());
        for (String s: myGenes.data()){
            if (s.length() > 60) { countPikkus = countPikkus +1; }
            if (dnaCalc.cgRatio(s) > 0.35) { countSuhtarv = countSuhtarv +1; }
            if(s.length() > longestGene){longestGene = s.length();}
            //System.out.println("Suhtarv: "+ dnaCalc.cgRatio(s));
            //System.out.println(s);
        }
        System.out.println("Geeni pikkus rohkem kui 60: " + countPikkus);
        System.out.println("Geeni pikkus suhtarvuga > 0.35: " + countSuhtarv);
        System.out.println("CTG esinemine kogu DNA ahelas: " + dnaCalc.howMany("CTG",dna));
        System.out.println("Longest gene length is: " + longestGene);
        System.out.println(dnaCalc.mystery("AATGCTAACTAGCTGAppppATGKAIDOKTAA"));
    }
}
