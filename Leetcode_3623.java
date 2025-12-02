import java.util.HashMap;

class Solution {
    final int MOD = (int) 1e7;

    public int countTrapezoids(int[][] points) {
        HashMap<Integer, Integer> yAxis = new HashMap<>();

        for (int[] point : points) {
            yAxis.put(point[1], yAxis.getOrDefault(point[1], 0) + 1);
        }

        long totalEdges = 0, ans = 0;

        for (int y : yAxis.values()) {
            long currentEdges = ((long) y * (y - 1)) / 2; // formula to find the horizontal edges
            ans = (ans + currentEdges * totalEdges) % MOD;
            totalEdges = (totalEdges + currentEdges) % MOD;
        }

        return (int) ans;
    }
}

public class Leetcode_3623 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] points = {
                {1,0},
                {2,0},
                {3,0},
                {2,2},
                {3,2}
        };
        System.out.println(s.countTrapezoids(points));
    }
}