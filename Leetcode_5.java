import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public String longestPalindrome(String s) {
        int size  = s.length();
        boolean[][] dp = new boolean[size][size];
        Map<Integer, LinkedList<Integer>> indices = new HashMap<>();

        for (int i = 0; i < size; i++) {
            dp[i][i] = true;
            indices.put(s.charAt(i) - 'a', new LinkedList<>());
        }

        int maxL = 0, maxR = 0;

        for (int r = 0; r < s.length(); r++) {
            int characterIndex = s.charAt(r) - 'a';

            for (Integer l : indices.get(characterIndex)) {
                if (dp[l + 1][r - 1] || (s.charAt(l) == s.charAt(r) && l + 1 == r)) {

                    if (r - l >= maxR - maxL) {
                        maxL = l;
                        maxR = r;
                    }

                    dp[l][r] = true;
                    dp[r][l] = true;
                }
            }

            indices.get(characterIndex).add(r);
        }

        return s.substring(maxL, maxR + 1);
    }
}

public class Leetcode_5 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("1"));
    }
}