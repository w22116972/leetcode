package leetcode;

public class Q125_ValidPalindrome {


    public boolean sol(String s) {
        String lowS = s.toLowerCase();

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!isCharValid(lowS.charAt(left))) {
                left++;
            } else if (!isCharValid(lowS.charAt(right))) {
                right--;
            } else if (lowS.charAt(left) != lowS.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    private boolean isCharValid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }


    public static void main(String[] args) {
        System.out.println("sol(\" \") = " + new Q125_ValidPalindrome().sol(" "));
        System.out.println("sol(\" \") = " + new Q125_ValidPalindrome().sol("A man, a plan, a canal: Panama"));
        System.out.println("sol(\" \") = " + new Q125_ValidPalindrome().sol("race a car"));
    }

}
