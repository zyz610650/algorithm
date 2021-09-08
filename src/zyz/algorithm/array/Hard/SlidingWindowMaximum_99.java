package zyz.algorithm.array.Hard;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 滑动窗口最大值
 * @seq: 239
 * @address: https://leetcode-cn.com/problems/sliding-window-maximum/
 * @idea:
 */
public class SlidingWindowMaximum_99 {
    public static void main(String[] args) {
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));
    }
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int n=nums.length;
        int arr[]=new int[n-k+1];
        int[] dp=new int[n];
        int ans=nums[0];
        if (k==1)
        {
            for(int i=0;i<n;i++)
                arr[i]=nums[i];
            return arr;
        }

        for(int i=0;i<k;i++)
        {
            ans=dp[i+k-1]-1;
            for(int j=i+k-1;j>=i;j--)
            {
                dp[i]=Math.max(ans,nums[i]);
                ans=dp[i];
            }
        }

        System.out.println(Arrays.toString(dp));
        arr[0]=ans;
        int t=1;
        for(int i=k;i<n;i++)
        {
            if(nums[i-k]==ans) ans=dp[i-k+1];
            ans=Math.max(ans,nums[i]);
            dp[i]=ans;
            arr[t++]=ans;
        }
        return arr;
    }


}
