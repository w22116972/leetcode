import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class OptimalPartitionOfString {

    //

    public static int partitionString(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        int countOfSubstring = 0;

        for (Character c: s.toCharArray()) {
            if (hashSet.contains(c)) {
                countOfSubstring++;
                hashSet.clear();
                hashSet.add(c);
            } else {
                hashSet.add(c);
            }
        }
        if (hashSet.size() > 0) {
            countOfSubstring++;
        }
        return countOfSubstring;
    }

    @Test
    public void exampleTest() {
        Assertions.assertEquals(4, partitionString("abacaba"));
        Assertions.assertEquals(6, partitionString("ssssss"));
    }


    @Test
    public void singleCharacterTest() {
        Assertions.assertEquals(1, partitionString("s"));
    }

    @Test
    public void exampleTest2() {
        Assertions.assertEquals(4, partitionString("hdklqkcssgxlvehva"));
    }
}
