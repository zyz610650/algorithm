package zyz.algorithm.array.Hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zyz
 * @title: 接雨水
 * @seq: 42
 * @address: https://leetcode-cn.com/problems/trapping-rain-water/
 * @idea:
 */
public class TrappingRainWater_45 {

    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) { //Search the left part for max bar size
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < size; j++) { //Search the right part for max bar size
                max_right = Math.max(max_right, height[j]);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }

    //双指针 比较好 看官方题解的评论 该思路是思路一 思路二延申出来的
    public int trap1(int[] height) {
        int n=height.length;
        if(n==0) return 0;
        int left=1,right=n-2;
        int left_Max=height[0],right_Max=height[n-1];
        int ans=0;
        while(left<=right)
        {
            if(left_Max<right_Max)
            {
                left_Max=Math.max(left_Max,height[left]);
                ans+=(left_Max-height[left]);
                left++;
            }else{
                right_Max=Math.max(right_Max,height[right]);
                ans+=(right_Max-height[right]);
                right--;
            }
        }
        return ans;
    }

    //单调栈
    public int trap2(int[] height)
    {
        Deque<Integer> stack=new ArrayDeque<>();
        stack.addLast(0);
        int n=height.length;
        int ele;
        int ans=0;
        for(int i=1;i<n;i++)
        {
            while(i<n&&height[stack.peekLast()]>=height[i]) stack.addLast(i++);
            if (i==n) break;
            while (!stack.isEmpty()&&height[i]>height[stack.peekLast()])
            {
                ele=stack.pollLast();
                if (ele==0) continue;;

            }
        }
    }
}
