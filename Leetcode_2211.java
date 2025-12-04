import java.util.Stack;

class Solution {
    public int countCollisions(String directions) {
        // -1 for neutral
        int impacts = -1, collisions = 0;

        for (char c : directions.toCharArray()) {
            if (c == 'R') {
                if (impacts > 0) {
                    impacts++;
                } else {
                    impacts = 1;
                }
            } else if (c == 'S') {
                if (impacts > 0) {
                    collisions += impacts;
                }
                impacts = 0;
            } else {
                if (impacts >= 0) {
                    collisions += impacts + 1;
                    impacts = 0;
                }
            }
        }

        return collisions;
    }
}

public class Leetcode_2211 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "RLRSLL";
        System.out.println(solution.countCollisions(s));
    }
}