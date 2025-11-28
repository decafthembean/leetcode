import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        Map<Integer, List<Integer>> modulos = new HashMap<>();
        modulos.put(0, new ArrayList<>(Arrays.asList(0)));
        modulos.put(1, new ArrayList<>(Arrays.asList(0)));
        modulos.put(2, new ArrayList<>(Arrays.asList(0)));

        for (int num : nums) {
            sum += num;
            int m = num % 3;
            if (modulos.get(m).size() < 3) modulos.get(m).add(num);
        }

        int ans = 0;

        int sumModulo1 = 0;
        for (int modulo1 : modulos.get(1)) {
            sumModulo1 += modulo1;

            int sumModulo2 = 0;
            for (int modulo2 : modulos.get(2)) {
                sumModulo2 += modulo2;

                int sam = sum - sumModulo1 - sumModulo2;
                if (sam % 3 == 0) {
                    ans = Math.max(ans, sam);
                }
            }
        }

        return ans;
    }
}

public class Leetcode_1262 {
    public static void main(String[] args) {
        Solution s = new Solution();

        // 1,2,0,1,1
        int[] nums = {1, 2, 3, 4, 4};
        System.out.println(s.maxSumDivThree(nums));
    }
}