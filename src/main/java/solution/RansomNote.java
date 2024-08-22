package solution;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Assume ransomNote and magazine are not null and lowercase english letters only
        int[] magazineCharCount = new int[26];
        for (char c : magazine.toCharArray()) {
            magazineCharCount[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (magazineCharCount[c - 'a'] == 0) {
                return false;
            }
            magazineCharCount[c - 'a']--;
        }
        return true;
    }
}
