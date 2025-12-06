import java.util.Arrays;

class Solution {
    public int countPartitions(int[] nums) {
        int left = 0;
        int right = Arrays.stream(nums).sum();

        int ans = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            left += nums[i];
            right -= nums[i];

            if ((left - right) % 2 == 0) ans++;
        }

        return ans;
    }
}

public class Leetcode_3432 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {10, 10, 3, 7, 6};
        System.out.println(s.countPartitions(nums));
    }
}