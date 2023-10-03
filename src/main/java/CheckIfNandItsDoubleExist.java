import java.util.HashSet;

public class CheckIfNandItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        final HashSet<Integer> hashSet = new HashSet<>();
        for (int i: arr) {
            if (hashSet.contains(i * 2) || (i % 2 == 0 && hashSet.contains(i / 2))) {
                return true;
            } else {
                hashSet.add(i);
            }
        }
        return false;
    }


}
