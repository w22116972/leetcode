package array;

public class ValidMountainArray {
    public boolean sol(int[] arr) {
        if (arr.length == 1) {
            return true;
        }
        boolean climb = true;
        boolean atLeastOneClimb = false;
        boolean atLeastOneDown = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                return false;
            } else if (climb && arr[i - 1] < arr[i]) {
                atLeastOneClimb = true;
            }else if (climb && arr[i - 1] > arr[i]) {
                atLeastOneDown = true;
                climb = false;
            } else if (!climb && arr[i - 1] < arr[i]) {
                return false;
            }
        }
        return atLeastOneClimb && atLeastOneDown;
    }
}
