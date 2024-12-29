package algorithms.strings;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInString {

    public static void main(String[] args) {
        String str = "..geeks..for.geeks.";
        System.out.println("input: " + str);
        System.out.println("Output: " + reverseWords(str));
    }

    private static String reverseWords(String s) {
        String[] splitString = s.split("\\.");

        List<String> reversedString = new ArrayList<>();

        for (int i = splitString.length - 1; i >= 0; i--) {
            String word = splitString[i];
            if(!word.isBlank()) {
                reversedString.add(word);
            }
        }

        return String.join(".", reversedString);

    }

    private static String reverseWord(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
}
