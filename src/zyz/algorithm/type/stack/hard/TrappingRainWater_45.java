package zyz.algorithm.type.stack.hard;

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
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap2(height));
    }

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

    //单调栈解法 不好理解得地方是虽然单调递减栈只能确定左边的边界 目前虽然遇到了右边比自己高的柱子，计算了一部分
    //储水面积，但当后来遇见更高柱子时会把原来少计算的给补回来 看图
    public static  int trap2(int[] height)
    {

        Deque<Integer> stack=new ArrayDeque<>();
        int ans=0;
        int n=height.length;
        for(int i=0;i<n;i++)
        {
            while(!stack.isEmpty()&&height[i]>height[stack.peekLast()])
            {
                int cur=stack.pollLast();
                if(stack.isEmpty()) break;
                int left=stack.peekLast();
                int h=Math.min(height[left],height[i]);
                ans+=(i-left-1)*(h-height[cur]);
            }
            stack.addLast(i);
        }
        return ans;
    }
}
