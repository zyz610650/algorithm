package zyz.algorithm.array.medium;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 下一个排列
 * @seq:31
 * @address: https://leetcode-cn.com/problems/next-permutation/
 * @idea:
 */
public class NextPermutation_39 {

    public static void main(String[] args) {
        int[] nums ={1,3,2};
        nextPermutation(nums);
    }
    public static  void nextPermutation(int[] nums) {
        int len=nums.length;
        int index=-1;
        int x,max,tmp;
        for(int i=len-1;i>0;i--)
        {
            if(nums[i]>nums[i-1])
            {
                index=i-1;
                break;
            }
        }
        if(index==-1)
        {
            Arrays.sort(nums);
            return;
        }
        x=index;
        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums,index+1,len);

        System.out.println(Arrays.toString(nums));
        //第一个比index大的位置
        for(int j=index+1;j<len;j++)
        {
            if(nums[j]>nums[index])
            {
                x=j;
                break;
            }
        }
        tmp =nums[x];
        nums[x]=nums[index];
        nums[index]=tmp;
        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums,index+1,len); // 这一步可以省略
        System.out.println(Arrays.toString(nums));
    }
}
