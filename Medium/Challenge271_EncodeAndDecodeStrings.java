package Medium;

import java.util.*;


public class Challenge271_EncodeAndDecodeStrings {

    // Encodes a list of strings to a single string.

    // List<String> strs = Arrays.asList("neet", "code", "love", "you");
 
    /*After first iteration
     * encoded = "4#neet"
* second iteration
*encoded = "4#neet4#code"
*third encoded = "4#neet4#code4#love"
*fourth encoded = "4#neet4#code4#love3#you"
*final encoded.toString() = "4#neet4#code4#love3#you"
     */
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            // Append <length>#<string> to the encoded result
            encoded.append(str.length()).append("#").append(str);
        }
        return encoded.toString();
    }

    public String encode2(List<String> strs){
        StringBuilder result = new StringBuilder();
        for(String str: strs){
            result.append(str.length()).append('#').append(str);
        }
        return result.toString();
    }


//String encodedStr = "4#neet4#code4#love3#you";
    // Decodes a single string to a list of strings.

    /*1st Iteration: i = 0 → hashIndex = 1. -> length =4
*2nd Iteration: i = 6 → hashIndex = 7. -> length = 4
*3rd Iteration: i = 12 → hashIndex = 13. -> length = 4
*4th Iteration: i = 18 → hashIndex = 19. -> length = 4
 */
    public List<String> decode(String encodedStr) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < encodedStr.length()) {
            // Find the position of the next delimiter (#)
            int hashIndex = encodedStr.indexOf('#', i);
            // Extract the length of the next string
            int length = Integer.parseInt(encodedStr.substring(i, hashIndex));
            // Extract the string using the length
            /*
             * For encodedStr = "4#neet4#code4#love3#you":

*1st Iteration: Extract "neet" (hashIndex = 1, length = 4).
*2nd Iteration: Extract "code" (hashIndex = 7, length = 4).
*3rd Iteration: Extract "love" (hashIndex = 13, length = 4).
*4th Iteration: Extract "you" (hashIndex = 19, length = 3).
             */
            String str = encodedStr.substring(hashIndex + 1, hashIndex + 1 + length);
            decoded.add(str);
            /*State of decoded:
*1st Iteration: decoded = ["neet"].
*2nd Iteration: decoded = ["neet", "code"].
*3rd Iteration: decoded = ["neet", "code", "love"].
*4th Iteration: decoded = ["neet", "code", "love", "you"]. */
            // Move the pointer to the next section
            i = hashIndex + 1 + length;

            //23 (past the length of encodedStr)

        }
        return decoded;
    }


    public List<String> decode2(String encodedStr) {
        List<String> decoded = new ArrayList<>();

        int i =0; 
        while(i < encodedStr.length()){
            int hashIndex = encodedStr.indexOf('#', i);
            int length = Integer.parseInt(encodedStr.substring(i, hashIndex));

            String temp = encodedStr.substring(hashIndex+1, hashIndex+1 + length );
            decoded.add(temp);
            i = hashIndex+1+ length;
        }
        return decoded;

    }


    public static void main(String[] args) {
        Challenge271_EncodeAndDecodeStrings codec = new Challenge271_EncodeAndDecodeStrings();
        List<String> input = Arrays.asList("neet", "code", "love", "you");
        String encoded = codec.encode2(input);
        System.out.println("Encoded: " + encoded);

        List<String> decoded = codec.decode2(encoded);
        System.out.println("Decoded: " + decoded);
    }
}


