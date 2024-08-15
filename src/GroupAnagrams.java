import java.util.*;
import java.util.Arrays;
import java.util.Scanner;
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        //map to store groupAnagrams...
        for (String str : strs) {
            int[] charCount = new int[26];
            for (char c : str.toCharArray()) {
                charCount[c - 'a']++; /* 'a' is subtracted to get the index
                 (0 for 'a', 1 for 'b', etc.)*/
            }
            StringBuilder keyBuilder = new StringBuilder();
            for (int count : charCount) {
                keyBuilder.append(count).append('#'); /*// Separate counts by '#'
                to avoid ambiguity*/
            }
            String key = keyBuilder.toString();
            if (!anagramMap.containsKey(key)) {
                anagramMap.put(key, new ArrayList<>());
            }
            anagramMap.get(key).add(str);
        }
        return new ArrayList<>(anagramMap.values());
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String[] str1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] str2 = {""};
        String[] str3 = {"a"};

        System.out.println(groupAnagrams(str1));
        System.out.println(groupAnagrams(str2));
        System.out.println(groupAnagrams(str3));
        sc.close();
    }
}
