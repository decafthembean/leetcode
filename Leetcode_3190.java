class Solution {
    public int minimumOperations(int[] nums) {
        int ans = 0;

        for (int num : nums) {
            ans += Math.min(3 - (num % 3), num % 3);
        }

        return ans;
    }
 }

public class  Leetcode_3190 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        Solution s = new Solution();
        System.out.println(s.minimumOperations(nums));
    }
}