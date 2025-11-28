import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    private int counts = 0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] neighbors = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            neighbors[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int node1 = edge[0],  node2 = edge[1];
            neighbors[node1].add(node2);
            neighbors[node2].add(node1);
        }

        depthFirstSearch(0, -1, neighbors, values, k);

        return counts;
    }

    private int depthFirstSearch(
            int currentNode,
            int parentNode,
            List<Integer>[] neighbors,
            int[] values,
            int k
    ) {
        int sum = 0;

        for (int neighborNode : neighbors[currentNode]) {
            if (neighborNode != parentNode) {
                sum += depthFirstSearch(
                        neighborNode,
                        currentNode,
                        neighbors,
                        values,
                        k
                );
                sum %= k;
            }
        }

        sum += values[currentNode];
        sum %= k;

        if (sum == 0) {
            counts++;
        }

        return sum;
    }
}

public class Leetcode_2872 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 5;
        int[][] edges = {
                {0, 2},
                {1, 2},
                {1, 3},
                {2, 4}
        };
        int[] values = {1, 8, 1, 4, 4};
        int k = 6;
        System.out.println(s.maxKDivisibleComponents(n, edges, values, k));
    }
}