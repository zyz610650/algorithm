package zyz.algorithm.type.BinarySearch;

/**
 * @author zyz
 * @title: 寻找峰值
 * @seq: 162
 * @address: https://leetcode-cn.com/problems/find-peak-element/
 * @idea:
 */
public class BinarySearch_76 {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int low=0,high=n-1;
        int mid=0;
        while(low<high)
        {
            mid=low+(high-low)/2;
            if(mid<n-1&&nums[mid]>nums[mid+1])
            {
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}
