package week5;

import edu.duke.*;


public class CaesarCipher {
    public String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input.toUpperCase());
        // WRITE DOWN THE ALPHABET
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String siftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        System.out.println(siftedAlphabet);
        for(int i = 0; i <encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            //find the index of currChar in alphabet
            int idx = alphabet.indexOf(currChar);
            //if currChar is in alphabet
            if (idx != -1){
                char newChar = siftedAlphabet.charAt(idx);
                encrypted.setCharAt(i,newChar);
            }
        }
        return encrypted.toString();
    }

    public void testCaesar(){
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26 - key);
        System.out.println(decrypted);
    }

    public static void main (String[] args){
    CaesarCipher cc = new CaesarCipher();
    cc.testCaesar();
    }
}
