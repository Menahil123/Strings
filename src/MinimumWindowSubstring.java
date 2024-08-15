import java.util.*;
public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        int[] targetCount = new int[128];
        for (char c : t.toCharArray()) {
            targetCount[c]++;
        }

        // Array to keep track of the count of characters in the current window
        int[] windowCount = new int[128];
        int required = t.length();
        int formed = 0;
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        // Expand the window by moving the right pointer
        while (right < s.length()) {
            char rChar = s.charAt(right);
            if (targetCount[rChar] > 0) {
                if (windowCount[rChar] < targetCount[rChar]) {
                    formed++;
                }
                windowCount[rChar]++;
            }
            // Contract the window by moving the left pointer
            while (formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }
                char lChar = s.charAt(left);
                if (targetCount[lChar] > 0) {
                    if (windowCount[lChar] == targetCount[lChar]) {
                        formed--;
                    }
                    windowCount[lChar]--;
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
        sc.close();
    }
}

