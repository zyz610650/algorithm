package zyz.algorithm.type.array.medium;

/**
 * @author zyz
 * @title: 盛最多水的容器
 * @seq: 11
 * @address: https://leetcode-cn.com/problems/container-with-most-water/
 * @idea:
 *
 */
public class ContainerWithMostWater_36 {

    public int maxArea(int[] height) {

        int len=height.length;
        int i=0,j=len-1,max=0;
        while(j!=i)
        {
            max=Math.max(max,Math.min(height[i],height[j])*(j-i));
            if(height[j]>height[i]) i++;
            else j--;
        }
        return max;

    }
}
