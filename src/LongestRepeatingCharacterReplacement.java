import java.util.*;
import java.util.Arrays;
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] prefixSum = new int[n + 1];
        int maxLength = 0;
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            Arrays.fill(prefixSum, 0);
            for (int i = 0; i < n; i++) {
                prefixSum[i + 1] = prefixSum[i] + (s.charAt(i) == ch ? 0 : 1);
                /* Update the prefixSum array at the (i + 1)-th position by adding the
                 current prefixSum and a 0 or 1 based on whether the character at
                  index i in the string s matches the character ch.
              If s.charAt(i) == ch, add 0 (no mismatch), otherwise add 1 (mismatch).*/
            }
            /*apply binary search to find the longest character replacement*/
            for (int i = 0; i < n; i++) {
                int low = i, high = n;
                while (low < high) {
                    int mid = (low + high + 1) / 2;
                    int changeCount = prefixSum[mid] - prefixSum[i];
                    if (changeCount <= k) {
                        low = mid;
                    } else {
                        high = mid - 1;
                    }
                }
                maxLength = Math.max(maxLength, low - i);
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();
        String s1 = "ABAB";
        int k1 = 2;
        System.out.println(solution.characterReplacement(s1, k1));
        String s2 = "AABABBA";
        int k2 = 1;
        System.out.println(solution.characterReplacement(s2, k2));
        sc.close();
    }
}
