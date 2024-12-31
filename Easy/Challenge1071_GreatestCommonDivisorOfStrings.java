package Easy;

public class Challenge1071_GreatestCommonDivisorOfStrings {
    public static String gcdOfStrings(String str1, String str2) {
        // Step 1: Check if strings are compatible
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Step 2: Compute the GCD of lengths
        int gcdLength = gcd(str1.length(), str2.length());

        // Step 3: Return the substring representing the GCD string
        return str1.substring(0, gcdLength);
    }

    // Helper method: Euclidean Algorithm for GCD
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings2("ABCABC", "ABC"));    // Output: "ABC"
        System.out.println(gcdOfStrings2("ABABAB", "ABAB"));   // Output: "AB"
        System.out.println(gcdOfStrings2("LEET", "CODE"));     // Output: ""
    }


    public static String gcdOfStrings2(String str1, String str2) {
                    //check compatibility 

            if(!(str1 + str2).equals(str2+str1)){
                return "";
            }

            int gcdLength = findGCD(str1.length(),str2.length());

            return str1.substring(0, gcdLength);

    }


    private static int findGCD(int a, int b){
        return b==0 ? a: findGCD(b, a %b);
    }




}
