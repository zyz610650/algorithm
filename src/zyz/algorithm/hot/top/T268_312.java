package zyz.algorithm.hot.top;

/**
 * @author zyz
 * @title: 268. 丢失的数字
 * @seq: 268
 * @address: https://leetcode-cn.com/problems/missing-number/
 * @idea:
 */
public class T268_312 {

    public int missingNumber(int[] nums) {
        int n=nums.length;
        int res=0;
        for(int i=0;i<=n;i++) res+=i;
        for(int i=0;i<n;i++) res-=nums[i];
        return res;
    }
}
