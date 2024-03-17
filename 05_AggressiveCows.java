import java.util.Arrays;

public class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 1, high = stalls[n - 1] - stalls[0];
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(stalls, n, k, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    private static boolean isPossible(int[] stalls, int n, int k, int distance) {
        int cowsPlaced = 1;
        int lastPlacedPosition = stalls[0];

        for (int i = 1; i < n; i++) {
            if (stalls[i] - lastPlacedPosition >= distance) {
                cowsPlaced++;
                lastPlacedPosition = stalls[i];
            }
        }

        return cowsPlaced >= k;
    }
}