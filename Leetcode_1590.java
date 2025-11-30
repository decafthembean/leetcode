import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum = (totalSum + num) % p;
        }

        if (totalSum == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int ans = nums.length;

        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % p;

            int remainder = (sum - totalSum + p) % p;

            if (map.containsKey(remainder)) {
                ans = Math.min(ans, i - map.get(remainder));
            }

            map.put(sum, i);
        }

        return ans == nums.length ? -1 : ans;
    }
}

public class Leetcode_1590 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3};
        int p = 26;
        System.out.println(s.minSubarray(nums, p));
    }
}