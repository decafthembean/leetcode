class Solution {
    public int countOdds(int low, int high) {
        if (low % 2 == 0) low++;
        if (high % 2 == 0) high--;

        if (low > high || high < low) return -1;

        int n = high - low + 1;
        return (n / 2) + 1;
    }
}

public class  Leetcode_1523 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int low = 2;
        int high = 8;
        System.out.println(s.countOdds(low, high));
    }
}