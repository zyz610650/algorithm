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
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea2(heights));
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
              // 这个循环可加可不加 比如 2 1 5 6 6 2 3  计算6的高度时  计算了第一个6 (i-3)
              // 虽然这个并不是高度为6的真是面积 但是计算第二个6时 会计算高度为6的真是面积
             // while (!stack.isEmpty()&&heights[ele]==heights[stack.peekLast()])  ele=stack.pollLast();
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

// 用这个单调栈 模板会比我写的这个 要简洁
//    stack<int> st;
//for(int i = 0; i < nums.size(); i++)
//    {
//        while(!st.empty() && st.top() > nums[i])
//        {
//            st.pop();
//        }
//        st.push(nums[i]);

    // 在原数组的的前后分别加了一个0  最后一个0会强迫原来栈中所有数据出栈 就比较简洁 这个特别好
    public static int largestRectangleArea2(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] new_heights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++) {
            new_heights[i] = heights[i - 1];
        }
        for (int i = 0; i < new_heights.length; i++) {
            while (!stack.isEmpty() && (i==new_heights.length||new_heights[stack.peekLast()] > new_heights[i])) {
                int cur = stack.pollLast();
                int l = stack.peekLast();
                int r = i;
                res = Math.max(res, (r - l - 1) * new_heights[cur]);
            }
            stack.addLast(i);
        }
        return res;
    }
}
