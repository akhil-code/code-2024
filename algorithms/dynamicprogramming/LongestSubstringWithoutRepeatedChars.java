package algorithms.dynamicprogramming;

public class LongestSubstringWithoutRepeatedChars {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(longestUniqueSubstr(s));
    }

    public static int longestUniqueSubstr(String s) {
        int n = s.length();
        if(n <= 1) {
            return n;
        }

        int[] countArr = new int[26];
        for (int i = 0; i < 26; i++) {
            countArr[i] = 0;
        }

        int i = 0, j = i + 1;
        countArr[s.charAt(i) - 'a'] = 1;

        int maxLength = Integer.MIN_VALUE;
        while(j < n) {
            countArr[s.charAt(j) - 'a'] += 1;

            if(countArr[s.charAt(j) - 'a'] == 1) {
                maxLength = Math.max(j - i + 1, maxLength);
            }

            while(countArr[s.charAt(j) - 'a'] > 1) {
                countArr[s.charAt(i) - 'a'] -= 1;
                i++;
            }
            j++;
        }
        return maxLength;
    }
}
