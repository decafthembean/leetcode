class Solution {
    public int minOperations(int[] nums, int k) {
        int ans = 0;

        for (int num : nums) {
            ans = (ans + num) % k;
        }

        return ans;
    }
}

public class Leetcode_3512 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {4, 1, 3};
        int k = ;
        System.out.println(s.minOperations(nums, k));
    }
}