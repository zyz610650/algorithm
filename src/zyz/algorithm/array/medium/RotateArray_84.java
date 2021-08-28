package zyz.algorithm.array.medium;

import com.sun.javaws.Main;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 旋转数组
 * @seq: 189
 * @address: https://leetcode-cn.com/problems/rotate-array/
 * @idea:
 */
public class RotateArray_84 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        int k = 4;
        rotate1(nums,k);

    }
    //一格一格的跳超时
    public static void rotate(int[] nums, int k) {
        int n=nums.length;
        int tmp=0;
        int t=0;
        for(int i=0;i<k;i++)
        {
            tmp=nums[0];
            for(int j=0;j<n;j++)
            {
                t=nums[(j+1)%n];
                nums[(j+1)%n]=tmp;
                tmp=t;
            }
            System.out.println(Arrays.toString(nums));
        }
    }

    public static void rotate1(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        if(n<=1||k==0) return ;
        int tmp=0;
        int t=0;
        int ans=nums[k-1];
        int[] arr=new int[k];
        System.arraycopy(nums,0,arr,0,k);
        for(int i=0;i<k;i++)
        {
            tmp=nums[i];
            for(int j=i;j<n;j+=k)
            {
                t=nums[(j+k)%n];
                nums[(j+k)%n]=tmp;
                tmp=t;
            }
            System.out.println(Arrays.toString(nums));
        }
        for (int i=0;i<k;i++)
        nums[(2*k-1+i)%n]=arr[i];
    }
}
