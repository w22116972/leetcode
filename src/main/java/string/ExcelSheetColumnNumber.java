package string;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int size = columnTitle.length();
        int count = 0;
        for (int i = 0; i < size; i++) {
            final int value = toNumber(columnTitle.charAt(i));
            count += value * Math.pow(26, size - i - 1);
        }
        return count;
    }

    // A 65
    private int toNumber(char c) {
        return (int) c - 64;
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("AB"));
    }
}
