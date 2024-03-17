import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int totalBoards = boards.size();
        int sum = 0;
        for (int i = 0; i < totalBoards; i++) {
            sum += boards.get(i);
        }
        
        int start = Collections.max(boards);
        int end = sum;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isPossible(boards, k, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return start;
    }
    
    private static boolean isPossible(ArrayList<Integer> boards, int k, int target) {
        int paintersRequired = 1;
        int currentBoardLength = 0;
        
        for (int board : boards) {
            if (currentBoardLength + board > target) {
                paintersRequired++;
                currentBoardLength = 0;
                if (paintersRequired > k) {
                    return false;
                }
            }
            currentBoardLength += board;
        }
        
        return true;
    }
}
