package string;

public class ValidPalindrome {


    public boolean sol(String s) {
        String lowS = s.toLowerCase();

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!isCharValid(lowS.charAt(i))) {
                i++;
            } else if (!isCharValid(lowS.charAt(j))) {
                j--;
            } else if (lowS.charAt(i) != lowS.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    private boolean isCharValid(char c) {
        return Character.isLetterOrDigit(c);
    }


    public static void main(String[] args) {
        System.out.println("sol(\" \") = " + new ValidPalindrome().sol(" "));
        System.out.println("sol(\" \") = " + new ValidPalindrome().sol("A man, a plan, a canal: Panama"));
        System.out.println("sol(\" \") = " + new ValidPalindrome().sol("race a car"));
    }

}
