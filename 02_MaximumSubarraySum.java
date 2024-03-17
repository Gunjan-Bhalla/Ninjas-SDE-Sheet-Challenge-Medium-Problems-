import java.util.*;

public class Solution {

    public static long maxSubarraySum(int[] arr, int n) {
        long maxSum = 0;
        long currentSum = 0;

        for (int i = 0; i < n; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
