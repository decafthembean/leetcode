/**
 * https://leetcode.com/problems/count-partitions-with-max-min-difference-at-most-k
 * patterns: partitions
 * topics: sliding_windows, arrays, dynamic_programming
 */

import java.util.TreeMap;
import java.util.Arrays;

class Solution {
    private final long MOD = (long) 1e9 + 7;

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long[] dp = new long[n+1];
        long[] prefixSum = new long[n+1];
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // setup base case
        dp[0] = 1;
        prefixSum[0] = 1;

        for (int right = 0, left = 0; right < n; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // do sliding window
            while (left <= right && map.lastKey() - map.firstKey() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0) map.remove(nums[left]);

                left++;
            }

            dp[right + 1] = (prefixSum[right] - (left > 0 ? prefixSum[left - 1] : 0) + MOD) % MOD;
            prefixSum[right + 1] = (prefixSum[right] + dp[right + 1]) % MOD;
        }

        return (int) dp[n];
    }
}

public class Leetcode_3578 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countPartitions(new int[]{9,4,1,3,7}, 4));
    }
}