package tsmc;

//  Given an encrypted string consisting of English letters ['A'-'Z'] only, decrypt the string by replacing each character with the kth character away on the wheel in the counter-clockwise direction.
//  Counter-clockwise is the opposite direction in which the hands on a clock usually move.
//  In the image, Z is 1 unit counter-clockwise from A.
//  Example
//      encrypted = VTAOG
//      k = 2
//
//  Looking back 2 from V returns T, from T returns R, and so on. The decrypted string is TRYME.
public class SimpleCipher {
    public String simpleCipher(String encrypted, int k) {
        StringBuilder result = new StringBuilder(encrypted.length());
        int shift = k % 26;  // just in case k > 26

        for (char c : encrypted.toCharArray()) {
            // 0..25 offset from 'A'
            int offset = c - 'A';
            // shift backwards, wrap in [0,25]
            int newOffset = (offset - shift + 26) % 26;
            // convert back to a letter
            result.append((char)('A' + newOffset));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        SimpleCipher simpleCipher = new SimpleCipher();
        System.out.println(simpleCipher.simpleCipher("VTAOG", 2));
    }
}
