class Solution {
    private static final int MOD = 1000000007;

    public int numberOfPaths(int[][] grid, int k) {
        // note: the trick here is using 3D matrix which is the thing I never even tried
        // wish: god please stop these modulo problem

        int rows = grid.length;
        int cols = grid[0].length;

        long[][][] dp = new long[rows + 1][cols + 1][k];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (i == 1 && j == 1) {
                    int remainder = grid[0][0] % k;
                    dp[i][j][remainder] = 1;
                    continue;
                }

                int remainder = grid[i - 1][j - 1] % k;
                for (int r = 0; r < k; r++) {
                    int prev = (r - remainder + k) % k;
                    dp[i][j][r] = (dp[i - 1][j][prev] + dp[i][j - 1][prev]) % MOD;
                }
            }
        }

        return (int)dp[rows][cols][0];
    }
}

public class Leetcode_2435 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {
                {5,2,4},
                {3,0,5},
                {0,7,2}
        };
        int k = 3;
        System.out.println(s.numberOfPaths(grid, k));
    }
}