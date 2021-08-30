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

    public static void main(String[] args) throws InterruptedException {
        int[] nums = {-1,-100,3,99};
        int k = 2;
        rotate2(nums,k);
        System.out.println(Arrays.toString(nums));

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
    //重要 因为 依次往右边移k个位置，有可能会移动到原位置 但是数组没遍历完
    //还有可能移到原来位置 正好遍历一遍数组 所以用一个变量记录 遍历了多少个元素
    public static void rotate2(int[] nums, int k)  {
        int n=nums.length;
        k=k%n;
        int tmp=0;

        int count=0;
        int start=0,prev=0,next=0;
        for (int cnt=0;cnt<n;cnt++)
        {
            prev=nums[cnt];
            start=cnt;
            do {
                start=(start+k)%n;
                tmp= nums[start];
                nums[start]=prev;
                prev=tmp;
                System.out.println(Arrays.toString(nums));

            count++;
            }while (start!=cnt);
            if (count==n) break;
        }

    }
    public static void rotate1(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);

    }
    static void reverse(int[] nums,int low,int high)
    {
        int tmp=0;
        while(low<high)
        {
            tmp=nums[low];
            nums[low]=nums[high];
            nums[high]=tmp;
            low++;
            high--;
        }
    }
}
