package zyz.algorithm.array.Hard;

import java.util.*;

/**
 * @author zyz
 * @title: 滑动窗口最大值
 * @seq: 239
 * @address: https://leetcode-cn.com/problems/sliding-window-maximum/
 * @idea:
 */
public class SlidingWindowMaximum_99 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow1(nums,k)));
    }
    //优先队列
    public static int[] maxSlidingWindow(int[] nums, int k)
    {
        int n=nums.length;
        int[] ans=new int[n-k+1];
        Queue<int[]> queue=new PriorityQueue<>((o1, o2) -> o1[0]==o2[0]?o2[1]-o1[1]:o2[0]-o1[0]);

        for (int i=0;i<k;i++)
            queue.add(new int[]{nums[i],i});
        ans[0]=queue.peek()[0];
        int t=1;
        for (int i=k;i<n;i++)
        {
            queue.add(new int[]{nums[i],i});
            while (queue.peek()[1]<i-k+1) queue.poll();
            ans[t++]=queue.peek()[0];
        }
        return ans;
    }

    //单调队列
    public static int[] maxSlidingWindow1(int[] nums, int k)
    {
        Deque<Integer> queue=new LinkedList<>();
        int n=nums.length;
        queue.addFirst(0);
        int[] ans=new int[n-k+1];
        int t=0;
        for (int i=1;i<n;i++)
        {
            while(queue.size()>0&&nums[queue.peekLast()]>nums[i]) queue.pollFirst();
            queue.addLast(i);
            if (i<k-1) continue;
            ans[t++]=nums[queue.peekFirst()];
        }
        return ans;
    }

}
