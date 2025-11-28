class Solution {
    public int smallestRepunitDivByK(int k) {
        // the problem requires all digits to be 1 => it's always odd 1, 3, 9, 21 and so on
        if (k % 2 == 0 || k % 5 == 0) return -1;

        int ans = 0;
        int remain = 0;

        do {
            remain = (remain * 10 + 1) % k;
            ans++;
        } while (remain != 0);

        return ans;
    }
}

public class Leetcode_1015 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.smallestRepunitDivByK(1));
    }
}