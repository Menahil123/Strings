import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class ValidAnagram{
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> frequencyMap = new HashMap<>();
        // Populate the frequency map with counts from the first string
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        // Subtract counts based on characters from the second string
        for (char c : t.toCharArray()) {
            if (!frequencyMap.containsKey(c)) {
                return false; // Character not in first string
            }
            frequencyMap.put(c, frequencyMap.get(c) - 1);
            if (frequencyMap.get(c) < 0) {
                return false;
            }
        }
        // If all counts are zero, the strings are anagrams
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println("Is '" + t1 + "' an anagram of '" + s1 + "'? " +
                isAnagram(s1, t1));
        String s2 = "rat";
        String t2 = "car";
        System.out.println("Is '" + t2 + "' an anagram of '" + s2 + "'? "
                + isAnagram(s2, t2));
    }
}

