package codility;

public class Smartnews2 {

    public int solution(int[] A) {
        if (A.length == 1) {
            return 1;
        } else if (A.length == 2) {
            return 2;
        }

        // write your code in Java SE 8
        int maxLength = 0;
        int localMaxLength = 2;
        int oddIndex = 1;
        int oddValue = A[oddIndex];
        int evenIndex = 0;
        int evenValue = A[evenIndex];

        while (oddIndex < A.length && evenIndex < A.length) {
            if (oddIndex > evenIndex) {
                if (evenIndex + 2 >= A.length) {
                    break;
                }
                if (evenValue == A[evenIndex + 2]) {
                    localMaxLength++;
                    maxLength = Math.max(maxLength, localMaxLength);

                } else {
                    evenValue = A[evenIndex + 2];
                    maxLength = Math.max(maxLength, localMaxLength);
                    localMaxLength = 2;
                }
                evenIndex += 2;
            } else {
                if (oddIndex + 2 >= A.length) {
                    break;
                }
                if (oddValue == A[oddIndex + 2]) {
                    localMaxLength++;
                    maxLength = Math.max(maxLength, localMaxLength);

                } else {
                    oddValue = A[oddIndex + 2];
                    maxLength = Math.max(maxLength, localMaxLength);
                    localMaxLength = 2;
                }
                oddIndex += 2;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Smartnews2().solution(new int[]{3, -7, 3, -7, 3}));
        System.out.println(new Smartnews2().solution(new int[]{3, -7, 3, -7, 3}));
    }
}
