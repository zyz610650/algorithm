package zyz.algorithm.type.array.Hard;

/**
 * @author zyz
 * @title: 缺失的第一个正数
 * @seq: 41
 * @address: https://leetcode-cn.com/problems/first-missing-positive/
 * @idea:
 */
public class FirstMissingPositive_44 {

    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        int key;
        for(int i=0;i<n;i++)
        {
            if(nums[i]<=0)
                nums[i]=n+1;
        }
        for(int i=0;i<n;i++)
        {
            key=Math.abs(nums[i]);
            if(key<=n)
            {
                nums[key-1]=-Math.abs(nums[key-1]);
            }
        }
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0) return i+1;
        }
        return n+1;

    }
}
