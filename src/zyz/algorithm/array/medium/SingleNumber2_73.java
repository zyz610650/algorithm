package zyz.algorithm.array.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyz
 * @title: 只出现一次的数字 II
 * @seq: 137
 * @address: https://leetcode-cn.com/problems/single-number-ii/
 * @idea:
 */
public class SingleNumber2_73 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int ans = 0 ;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey(), occ = entry.getValue();
            if (occ == 1) {
                ans = num;
                break;
            }
        }
        return ans;
    }

}
