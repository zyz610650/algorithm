package zyz.algorithm.sorts;

import java.util.Arrays;
import java.util.HashMap;

public class ShellSort
{
        public static void main(String[] args) {
                int[] arr={123214,95, -1,94, 91, 32432,98, -3, 43, 99, 93, 91, 92};
                System.out.println(Arrays.toString(shellSort(arr)));
                HashMap<Integer,Integer> map=new HashMap<>();

        }
        public static int[] shellSort(int[] nums)
        {
                int n=nums.length;
                for(int i=n/2;i>0;i/=2)
                {
                        for (int j=i;j<n;j++)
                        {
                                for(int k=j;k>=i&&nums[k]<nums[k-i];k-=i)
                                {
                                        int tmp=nums[k];
                                        nums[k]=nums[k-i];
                                        nums[k-i]=tmp;
                                }
                        }
                }
                return nums;
        }
}
