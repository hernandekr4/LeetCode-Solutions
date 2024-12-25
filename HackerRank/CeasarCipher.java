package HackerRank;

/**
 * This program implements the Caesar Cipher encryption technique, which shifts 
 * each letter in a given string by a specified number of positions (k) in the alphabet. 
 * The goal is to encrypt the input string while leaving non-alphabetic characters unchanged.
 * A HashMap is used to precompute the shifted alphabet mappings for both lowercase 
 * and uppercase letters, ensuring efficient lookups during encryption. The program 
 * processes each character of the input string, substitutes it with the corresponding 
 * rotated character using the HashMap, and builds the encrypted string with a StringBuilder. 
 * This approach is efficient, concise, and handles edge cases like non-alphabetic characters seamlessly.
 * 
 * 
 * 
 * 12-23-25 11:16pm
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class CeasarCipher{
     public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);


        int n = in.nextInt();
        in.nextLine();

        String s = in.nextLine();

        int k = in.nextInt();

        String result = Result.caesarCipher(s, k);
        String result2 =Result.ceaserCipher2(s, k);
        String result3 =Result.ceaserCipher2(s, k);

        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);


        in.close();
    }


}


class Result {
    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

     public static String caesarCipher(String s, int k) {        
        k = k %26;

        // Step 2: Define the lowercase and uppercase alphabets
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String lowerRotation = lowerAlphabet.substring(k)+ lowerAlphabet.substring(0,k);
        String upperRotation = upperAlphabet.substring(k)+ upperAlphabet.substring(0,k);

        StringBuilder result = new StringBuilder();

        for(char c: s.toCharArray()){
            if(Character.isLowerCase(c)){
                int index = lowerAlphabet.indexOf(c);
                char encryptedChar = lowerRotation.charAt(index);

                result.append(encryptedChar);
            }else if(Character.isUpperCase(c)){
                int index = upperAlphabet.indexOf(c);
                char encryptedChar = upperRotation.charAt(index);

                result.append(encryptedChar);
            }else {
                result.append(c);
            }
            
        }
        return result.toString();

        }


        //Hashmap approach 
        public static String ceaserCipher2(String s, int k ){
            //normalize K 
            k = k %26;
            String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
            String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            HashMap<Character, Character> mySet = new HashMap<>();

            for(int i =0; i< 26; i++){
                // For lowercase letters:
                // - Map the current character (e.g., 'a') to the rotated character (e.g., 'c' for k = 2).
                // - The rotated character's position is calculated as (i + k) % 26 to handle wrap-around.
                mySet.put(lowerAlphabet.charAt(i), lowerAlphabet.charAt((i+k)%26));
                 // For uppercase letters:
                // - Similarly, map the current character (e.g., 'A') to the rotated character (e.g., 'C' for k = 2).
                mySet.put(upperAlphabet.charAt(i), upperAlphabet.charAt((i+k)%26));
            }

            StringBuilder result = new StringBuilder();
            // Convert the input string to a character array for processing each character.
        for (char c : s.toCharArray()) {
        // Use the HashMap to get the rotated character for the current character 'c'.
        // If the character 'c' is not a key in the HashMap (e.g., it's a space or punctuation),
        // use the original character 'c' as the default value.
        result.append(mySet.getOrDefault(c, c));
    }

    return result.toString();


        }

        public static String ceaserCipher3(String s, int k ){
            k = k %26;

            String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
            String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            HashMap<Character, Character> map = new HashMap<>();

            for(int i =0; i<26;i++){
                map.put(lowerAlphabet.charAt(i), lowerAlphabet.charAt((i+k)%26));
                map.put(upperAlphabet.charAt(i), lowerAlphabet.charAt((i+k)%26));
            }

            StringBuilder result = new StringBuilder();

            for(char c: s.toCharArray()){
                result.append(map.getOrDefault(c, c));
            }
            return result.toString();

        }

    
}