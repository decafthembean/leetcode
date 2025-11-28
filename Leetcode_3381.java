import java.util.Arrays;

class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[nums.length];

        // find the prefix
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = nums[i] + prefixSum[i - 1];
        }

        long ans = Long.MIN_VALUE;

        long[] minK = new long[k];
        Arrays.fill(minK, Long.MAX_VALUE / 2);
        minK[k - 1] = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, prefixSum[i] - minK[i % k]);
            minK[i % k] = Math.min(minK[i % k], prefixSum[i]);
        }


        return ans;
    }
}

public class Leetcode_3381 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int k = 4;
        System.out.println(solution.maxSubarraySum(nums, k));
    }
}