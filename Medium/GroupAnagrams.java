package Medium;

import java.util.*;

/**
 * Challenge: Group Anagrams
 * 
 * Problem Description:
 * - Given an array of strings `strs`, group all anagrams together into sublists.
 * - An anagram is a word or phrase formed by rearranging the letters of another.
 * - The goal is to group words that are anagrams of each other.
 * 
 * Steps to Solve:
 * 1. Create a HashMap to group strings by their sorted character representation.
 *    - Key: The sorted version of the string.
 *    - Value: A list of strings that are anagrams of the key.
 * 2. Iterate through each string in the input array.
 *    - Convert the string to a character array and sort it.
 *    - Convert the sorted character array back to a string.
 *    - Add the original string to the list corresponding to the sorted key in the map.
 * 3. Return the grouped anagrams as the values of the HashMap.
 *    - Convert the map’s values to a list of lists for the result.
 * 
 * Example:
 * Input: ["act", "pots", "tops", "cat", "stop", "hat"]
 * Output: [["hat"], ["act", "cat"], ["pots", "tops", "stop"]]
 */

public class GroupAnagrams {


    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedS = new String(charArray);
            res.putIfAbsent(sortedS, new ArrayList<>());
            res.get(sortedS).add(s);
        }
        return new ArrayList<>(res.values());
    }

    public static void main(String[] args) {
        // Test case 1
        String[] strs1 = {"act", "pots", "tops", "cat", "stop", "hat"};
        System.out.println("Test Case 1: " + groupAnagrams2(strs1));

        // Test case 2
        String[] strs2 = {"listen", "silent", "enlist", "hello", "world"};
        System.out.println("Test Case 2: " + groupAnagrams2(strs2));

        // Test case 3
        String[] strs3 = {"a", "b", "ab", "ba", "abc", "cab"};
        System.out.println("Test Case 3: " + groupAnagrams2(strs3));

        // Test case 4 (empty input)
        String[] strs4 = {};
        System.out.println("Test Case 4: " + groupAnagrams2(strs4));
    }



    public static List<List<String>> groupAnagrams2(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);

            String sortedWord = new String(charArray);
            map.putIfAbsent(sortedWord, new ArrayList<>());
            map.get(sortedWord).add(s);

        }

        return new ArrayList<>(map.values());


    }


}
