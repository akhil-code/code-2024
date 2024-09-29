package algorithms.dynamicprogramming;

public class LongestWordInDictionaryByDeletingSomeChars {
    public static void main(String[] args) {
        String[] arr = {"ale", "apple", "monkey", "plea"};
        String str = "abpcplea";
        System.out.println(findLongestString(arr, str));
    }

    public static String findLongestString(String[] arr, String s) {
        String maxString = "";
        for (String arrElement : arr) {
            if(isSubSequence(s, arrElement) && arrElement.length() > maxString.length()) {
                maxString = arrElement;
            }
        }
        return maxString;
    }

    private static boolean isSubSequence(String s, String seq) {
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if(j >= seq.length()) {
                return true;
            }
            if(s.charAt(i) == seq.charAt(j)) {
                j++;
            }
        }

        if(j >= seq.length()) {
            return true;
        }

        return false;
    }
}
