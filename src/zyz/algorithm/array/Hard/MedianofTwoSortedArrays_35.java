package zyz.algorithm.array.Hard;

import java.awt.print.PrinterJob;
import java.util.Arrays;

/**
 * @author zyz
 * @title: 寻找两个正序数组的中位数
 * @seq: 04
 * @address: https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @idea:
 */
public class MedianofTwoSortedArrays_35 {

    public static void main(String[] args) {
       int[] nums1 = {}, nums2 = {2,3};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
    //方法一 合并数组 时间复杂度大 时间复杂度：遍历全部数组 (m+n)(m+n) 空间复杂度：开辟了一个数组，保存合并后的两个数组 O(m+n)O(m+n)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        int i=0,j=0,t=0;
       int[] nums=new int[m+n];
       while (i<m&&j<n)
       {
           if (nums1[i]<nums2[j]) nums[t++]=nums1[i++];
           else nums[t++]=nums2[j++];
       }
       while (i<m)
       {
           nums[t++]=nums1[i++];
       }
        while (j<n)
        {
            nums[t++]=nums2[j++];
        }
//        System.out.println(nums[t/2]);
//        System.out.println(nums[t/2-1]);
//       System.out.println(Arrays.toString(nums));
        if (t%2!=0) return nums[t/2];
        else  return (nums[t/2]+nums[t/2-1])/2.0;

    }
    // 方法二: 双指针 时间复杂度：遍历 len/2+1 次，len=m+n，所以时间复杂度依旧是 O(m+n)O(m+n)。 总共 8 个变量，所以空间复杂度是 O(1）O(1）。
    // 主要的思路是 找到第len/2个数  若是奇数个数 则中位数是 第len/2 否则是 len/2和len/2-1的和÷2
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        boolean f1=true,f2=true;//f1 true x是 nums1 false  x是nums2
        int left=0,right=0,x=0,y=0;

       for(int i=0;i<=(m+n)/2;i++)
       {
           right=left;
           if (x<m&&y<n)
           {
               if (nums1[x]<=nums2[y]) left=nums1[x++];
               else left=nums2[y++];
           }
           else if(x<m){
               left=nums1[x++];
           }else {
               left=nums2[y++];
           }
       }
       if (((m+n)&1)==0) return  (left+right)/2.0;
       else return left>right?left:right;


    }
    //它这个也是双指针 但是细节的处理比我的巧妙
    public double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) { //这点处理比较巧妙
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }

}
