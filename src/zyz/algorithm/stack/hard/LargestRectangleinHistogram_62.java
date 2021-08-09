package zyz.algorithm.stack.hard;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.print.attribute.standard.NumberUp;
import java.nio.file.Path;
import java.util.*;

/**
 * @author zyz
 * @title: 柱状图中最大的矩形
 * @seq: 84
 * @address: https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * @idea:
 */
public class LargestRectangleinHistogram_62 {

    public static void main(String[] args) {
        int[] heights = {3,6,5,7,4,8,1,0};
        System.out.println(largestRectangleArea(heights));
    }
    // 计算每一种高度的面积
    public static int largestRectangleArea(int[] heights)
    {
        int n=heights.length;
        Deque<Integer> stack=new ArrayDeque<>();

        stack.addLast(0);
        int maxArea=heights[0];
        // 该层遍历最终在栈里保留的是 一个递增的序列  2,1,5,6,2,3 该层遍历后得到的是2 5 6
        for(int i=1;i<n;i++)
        {
            while (i<n&&heights[i]>=heights[stack.peekLast()])   stack.addLast(i++);
            if (i==n) break;
          while(!stack.isEmpty()&&heights[stack.peekLast()]>=heights[i])
          {
              int ele=stack.peekLast();
              while (!stack.isEmpty()&&heights[ele]==heights[stack.peekLast()])  ele=stack.pollLast();
              // 这里需要注意 比如栈里为1 5 6 i=4 height[i]=2 5的面积是 i-(栈里比5小的下标)-1 才为 5的矩形宽 若栈里5的前面没元素
              // 则表明5前面没有比自己小的了 这时特殊处理 这里只是举个例子 这里特殊处理的是height[1]=1;
              if(!stack.isEmpty())
              maxArea=Math.max(maxArea,(i-stack.peekLast()-1)*heights[ele]);
              else          maxArea=Math.max(maxArea,(i)*heights[ele]);
          }
          if (stack.isEmpty()||heights[i]>heights[stack.peekLast()])  stack.addLast(i);
        }
        int h=stack.peekLast();
        //对递增的序列计算面积
        while(!stack.isEmpty())
        {
            int pop=stack.pollLast();
            if (!stack.isEmpty())
            maxArea=Math.max(maxArea,(h-stack.peekLast())*heights[pop]);
            else   maxArea=Math.max(maxArea,(h+1)*heights[pop]);

        }
        return maxArea;
    }




}
