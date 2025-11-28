import java.util.*;

class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        // Surprisingly, for any bits divisible by (x), no matter if you shift left or right
        // it will always be divisible by (x)
        // 101 (5) % 5 == 0
        // 1010 (10) % 5 == 0
        // 10100 (20) % 5 == 0
        // 101000 (40) % 5 == 0

        // Note: the key here is the remain after the modulo
        // 110 (6) % 5 == 1 -> 1
        // 1100 (12) -> 10 (2) % 5 == 2
        // 11001 (25) -> 101 (5) % 5 == 0

        List<Boolean> ans = new ArrayList<>();
        int prefix = 0;

        for (int num : nums) {
            prefix = (prefix << 1 + num) % 5;
            ans.add(prefix == 0);
        }

        return ans;
    }
}

public class Leetcode_1018 {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {1,0,1,0};
        List<Boolean> ans = s.prefixesDivBy5(nums);
        System.out.println(ans);
    }
}