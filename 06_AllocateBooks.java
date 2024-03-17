import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (n < m) {
            return -1; // If number of students is more than number of books
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr.get(i);
        }

        int start = 0, end = sum, result = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(arr, n, m, mid)) {
                result = Math.min(result, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    private static boolean isPossible(ArrayList<Integer> arr, int n, int m, int max) {
        int studentsRequired = 1;
        int pagesRead = 0;

        for (int i = 0; i < n; i++) {
            if (arr.get(i) > max) {
                return false; // If any book has more pages than max
            }
            if (pagesRead + arr.get(i) > max) {
                studentsRequired++;
                pagesRead = arr.get(i);
                if (studentsRequired > m) {
                    return false; // If required students exceed given count
                }
            } else {
                pagesRead += arr.get(i);
            }
        }
        
        return true;
    }
}
