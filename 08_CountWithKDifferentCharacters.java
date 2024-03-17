import java.util.*;

public class Solution {
    public static int countSubStrings(String str, int k) {
        int n = str.length();
        int[] count = new int[26];
        int result = 0;
        int uniqueCount = 0;
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(count, 0);
            uniqueCount = 0;
            for (int j = i; j < n; j++) {
                if (count[str.charAt(j) - 'a'] == 0) {
                    uniqueCount++;
                }
                count[str.charAt(j) - 'a']++;
                
                if (uniqueCount == k) {
                    result++;
                }
                if (uniqueCount > k) {
                    break;
                }
            }
        }
        
        return result;
    }
}
