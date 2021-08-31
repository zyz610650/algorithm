package zyz.algorithm.array.medium;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 长度最小的子数组
 * @seq: 209
 * @address: https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * @idea:
 */
public class MinimumSizeSubarraySum_87 {

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        int target=15;
        System.out.println(minSubArrayLen4(target,nums));
    }
    //暴力
    public  static int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int cnt=0;
        int min=Integer.MAX_VALUE;
        boolean flag=false;
        for(int i=0;i<n;i++)
        {
            cnt=nums[i];
            if(cnt>=target)
            {
                min=1;
                flag=true;
                return min;
            }
            for(int j=i+1;j<n;j++)
            {
                cnt+=nums[j];
                if(cnt>=target)
                {
                    min=Math.min(min,j-i+1);
                    flag=true;
                    break;
                }
            }
        }
        min=flag==true?min:0;
        return min;
    }

    // 超时
    public  static int minSubArrayLen1(int target, int[] nums)
    {
        //  dp[i][i+j-1]=dp[i][i+j-2]+nums[i+j-2];
        int n=nums.length;
        int[][] dp=new int[n][n+1];
//        for (int i=0;i<n;i++)
//        dp[i][1]=nums[i];
        for (int i=1;i<=n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if (i+j-1<n)
                dp[j][i]=dp[j][i-1]+nums[i+j-1];
                if (dp[j][i]>=target)
                {
                    return i;
                }
            }
        }
        return 0;
    }
    //滑动窗口 写法1
    public  static int minSubArrayLen2(int target, int[] nums)
    {
        int min=Integer.MAX_VALUE,start=0,end=0;
        int n=nums.length;
        int sum=0;
        while(start<n&&end<=n)
        {
            while(sum<target&&end<n)
            {
                sum+=nums[end++];

            }
            if(sum>=target)   min=Math.min(min,end-start);
            sum-=nums[start];
            start++;

        }
        min=min==Integer.MAX_VALUE?0:min;
        return min;

    }
    //滑动窗口 写法2 官方的方法 写的比我的简便
    public  static int minSubArrayLen3(int target, int[] nums)
    {
        int n=nums.length,start=0,end=0,sum=0,min=n;

        while(end<n)
        {
            sum+=nums[end];
            while(sum>=target)
            {
                min=Math.min(min,end-start+1);
                sum-=nums[start];
                start++;
            }
            end++;
        }
        min=min==n?0:min;
        return min;
    }
    public  static int minSubArrayLen4(int target, int[] nums)
    {
        int n=nums.length,start=0,end=0,sum=0;

        int[] sums=new int[n+1];
        for(int i=1;i<=n;i++) sums[i]=sums[i-1]+nums[i-1];

        int low_bound=0;
        int s=0,min=Integer.MAX_VALUE;
        for(int i=0;i<=n;i++)
        {
            s=sums[i]+target;
            low_bound=Arrays.binarySearch(sums,s);
            if(low_bound<0) low_bound=~low_bound;
            if(low_bound<=n)
                min=Math.min(min,low_bound-i);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
