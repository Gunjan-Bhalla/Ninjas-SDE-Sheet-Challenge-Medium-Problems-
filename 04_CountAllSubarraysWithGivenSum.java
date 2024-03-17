import java.util.*;

public class Solution {
    public static int findAllSubarraysWithGivenSum(int arr[], int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : arr) {
            sum += num;
            
            if (sum == k) {
                count++;
            }
            
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
