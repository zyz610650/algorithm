package zyz.algorithm.array.medium;

/**
 * @author zyz
 * @title: 颜色分类
 * @seq: 75
 * @address: https://leetcode-cn.com/problems/sort-colors/
 * @idea:
 */
public class SortColors_56 {

    public void sortColors(int[] nums) {
        int n=nums.length;
        int tmp=0;

        int p0=0,p1=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==1)
            {
                swap(nums,i,p1);
                p1++;
            }else if(nums[i]==0)
            {
                swap(nums,i,p0);
                if(p0<p1)
                {
                    swap(nums,p1,i);
                }
                p0++;
                p1++;
            }
        }
    }

    public static void swap(int[] nums,int left,int right)
    {
        int tmp=nums[left];
        nums[left]=nums[right];
        nums[right]=tmp;
    }
}
