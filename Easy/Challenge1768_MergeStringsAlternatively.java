package Easy;

public class Challenge1768_MergeStringsAlternatively {
    public static void main(String[] args) {
        // Test cases
        System.out.println(mergeAlternately("abc", "pqr"));    // Output: "apbqcr"
        System.out.println(mergeAlternately("ab", "pqrs"));    // Output: "apbqrs"
        System.out.println(mergeAlternately("abcd", "pq"));    // Output: "apbqcd"
    }


    public static String mergeAlternately(String word1, String word2) {
        int i =0;
        int j =0;
        StringBuilder result = new StringBuilder();
        while(i< word1.length() && j < word2.length()){
            result.append(word1.charAt(i++));
            result.append(word2.charAt(j++));
        }


        while(i < word1.length()){
            result.append(word1.charAt(i++));
        }

        while(j < word2.length()){
            result.append(word2.charAt(j++));
        }

        return result.toString();
    }



    public static String mergeAlternately2(String word1, String word2) {
        StringBuilder result = new StringBuilder();


        int maxlength = Math.max(word1.length(), word2.length());

        for(int i =0; i < maxlength; i++){
            if(i < word1.length()){
                result.append(word1.charAt(i));
            }


            if(i < word2.length()){
                result.append(word2.charAt(i));
            }
        }

        return result.toString();
    }







}
