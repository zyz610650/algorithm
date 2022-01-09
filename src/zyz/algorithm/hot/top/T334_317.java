package zyz.algorithm.hot.top;


/**
 * @author zyz
 * @title: 334. 递增的三元子序列
 * @seq: 334
 * @address: https://leetcode-cn.com/problems/increasing-triplet-subsequence/
 * @idea:
 */
public class T334_317 {
    public boolean increasingTriplet(int[] nums) {
        int o=Integer.MAX_VALUE,t=Integer.MAX_VALUE;

        for(int th:nums)
        {

            if(th>t) return true;
            else if(th<=o) o=th;
            else  t=th;

        }
        return false;
    }
}
