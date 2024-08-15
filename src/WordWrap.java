import java.util.*;
import java.util.Arrays;
public class WordWrap {
    public static void printNeatly(int[] nums, int n, int K) {
        // Extras[i][j] will have number of extra spaces if words i to j are placed in a single line
        int[][] extras = new int[n + 1][n + 1];

        // Line cost[i][j] will have cost of a line which has words from i to j
        int[][] lineCost = new int[n + 1][n + 1];

        // minCost[j] will have minimum cost to arrange words from 1 to j
        int[] minCost = new int[n + 1];

        // result[j] will store the position of the line break
        int[] result = new int[n + 1];

        // Fill the extras array
        for (int i = 1; i <= n; i++) {
            extras[i][i] = K - nums[i - 1];
            for (int j = i + 1; j <= n; j++) {
                extras[i][j] = extras[i][j - 1] - nums[j - 1] - 1;
            }
        }

        // Fill the lineCost array
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (extras[i][j] < 0) {
                    lineCost[i][j] = Integer.MAX_VALUE;
                } else if (j == n && extras[i][j] >= 0) {
                    lineCost[i][j] = 0;
                } else {
                    lineCost[i][j] = extras[i][j] * extras[i][j];
                }
            }
        }
        minCost[0] = 0;
        for (int j = 1; j <= n; j++) {
            minCost[j] = Integer.MAX_VALUE;
            for (int i = 1; i <= j; i++) {
                if (minCost[i - 1] != Integer.MAX_VALUE && lineCost[i][j] !=
                        Integer.MAX_VALUE && (minCost[i - 1] + lineCost[i][j] <
                        minCost[j])) {
                    minCost[j] = minCost[i - 1] + lineCost[i][j];
                    result[j] = i;
                }
            }
        }
        printResult(result, n);
    }
    private static void printResult(int[] result, int n) {
        if (result[n] == 1)
            System.out.print(result[n] + " " + n + "\n");
        else {
            printResult(result, result[n] - 1);
            System.out.print(result[n] + " " + n + "\n");
        }
    }
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 5};
        int n = nums.length;
        int K = 6;
        printNeatly(nums, n, K);
    }
}

