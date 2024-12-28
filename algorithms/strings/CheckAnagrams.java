package algorithms.strings;

public class CheckAnagrams {

    public static void main(String[] args) {
        String s1 = "geeks";
        String s2 = "kseefg";
        System.out.println(areAnagrams(s1, s2));
    }

    private static boolean areAnagrams(String s1, String s2) {
        int[] count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            count[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if(count[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
