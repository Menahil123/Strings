import java.util.*;
import java.util.Scanner;
public class MobileKeypadSequence{
    private static String getKeypadSequence(char c) {
        switch (c) {
            case 'A': case 'B': case 'C': return "2";
            case 'D': case 'E': case 'F': return "3";
            case 'G': case 'H': case 'I': return "4";
            case 'J': case 'K': case 'L': return "5";
            case 'M': case 'N': case 'O': return "6";
            case 'P': case 'Q': case 'R': case 'S': return "7";
            case 'T': case 'U': case 'V': return "8";
            case 'W': case 'X': case 'Y': case 'Z': return "9";
            case ' ': return "0";
            default: return "";
        }
    }
    private static int getPressCount(char c) {
        switch (c) {
            case 'A': case 'D': case 'G': case 'J': case 'M': case 'P': case 'T':
                case 'W': return 1;
            case 'B': case 'E': case 'H': case 'K': case 'N': case 'Q':
                case 'U': case 'X': return 2;
            case 'C': case 'F': case 'I': case 'L': case 'O': case 'R':
                case 'V': case 'Y': return 3;
            case 'S': case 'Z': return 4;
            case ' ': return 1;
            default: return 0;
        }
    }
    //Sequence according to array mapping
    private static String printSequence(String[] arr, String input) {
        StringBuilder output = new StringBuilder();
        int n = input.length();
        for (int i = 0; i < n; i++) {
            char c = input.charAt(i);
            if (c == ' ') {
                output.append("0");
            } else {
                int position = c - 'A';
                output.append(arr[position]);
            }
        }
        return output.toString();
    }
    private static String convertToKeypadSequence(String input) {
        StringBuilder result = new StringBuilder();
        input = input.toUpperCase();
        String[] keypadMapping = {
                "2", "22", "222", "3", "33", "333",
                "4", "44", "444", "5", "55", "555",
                "6", "66", "666", "7", "77", "777", "7777",
                "8", "88", "888", "9", "99", "999", "9999"
        };
        for (char c : input.toCharArray()) {
            if (c == ' ') {
                result.append("0");
            } else if (c >= 'A' && c <= 'Z') {
                int position = c - 'A';
                result.append(keypadMapping[position]);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input1 = "MENAHILDASTGIR";
        String input2 = "ART GALLERIA";
        System.out.println("Input: " + input1);
        System.out.println("Output using combined logic: " +
                convertToKeypadSequence(input1));
        System.out.println("Input: " + input2);
        System.out.println("Output using combined logic: " +
                convertToKeypadSequence(input2));

        String[] keypadMapping = {
                "2", "22", "222", "3", "33", "333",
                "4", "44", "444", "5", "55", "555",
                "6", "66", "666", "7", "77", "777", "7777",
                "8", "88", "888", "9", "99", "999", "9999"
        };
        String input3 = "GHULAM DASTGIR";
        System.out.println("Array-based Output for 'SALEHADASTGIR': " +
                printSequence(keypadMapping, input3));
        sc.close();
    }
}
